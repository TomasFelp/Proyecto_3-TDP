package juego;

import java.awt.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.JLabel;

import GUI.GUI_juego;
import GUI.SplashScreen;
import Niveles.Nivel;
import cerebros.ComandoPlayer;
import entidades.*;

public class Juego extends Mediator {
	private static final int UNIDAD_DE_TIEMPO_EN_NANOSEGUNDOS = 10000000;
	private static final int NANOSEGUNDOS_EN_UN_SEGUNDO = 1000000000;
	private static final int FRAMERATE_DESEADO = 120;
	private static final int TIEMPO_POR_FRAME = NANOSEGUNDOS_EN_UN_SEGUNDO / FRAMERATE_DESEADO;
	private static final long NANOSEGUNDOS_EN_UN_MILISEGUNDO = 1000000;

	private Map<Integer, Entidad> entidades;

	private Map<Integer, Colisionador> colisionadores;
	private Map<Integer, Colisionable> colisionables;

	private boolean termino;
	protected GUI_juego interfaz;
	protected Jugador jugador;
	protected Generador_de_niveles niveles;
	protected Nivel nivelActual;
	protected ComandoPlayer controlesPlayer;
	private float deltaTime;
	private SplashScreen screen;

	public Juego(GUI_juego inter) {
		screen = new SplashScreen(3000);
		screen.mostrarPantallaStart();
		termino = false;
		interfaz = inter;

		entidades = new ConcurrentHashMap<Integer, Entidad>();

		// Mantienen las referencias a los colisionadores y colisionables en el juego
		colisionadores = new ConcurrentHashMap<Integer, Colisionador>();
		colisionables = new ConcurrentHashMap<Integer, Colisionable>();

		niveles = new Generador_de_niveles();

		interfaz.setVisible(true);
		configurarJugador();
	}

	/**
	 * Realiza todo lo pertienete a la inicializacion del jugador.
	 */
	private void configurarJugador() {
		jugador = new Jugador();

		interfaz.addEntidad(jugador);
		int x = interfaz.getAncho() / 2 - jugador.getWidth() / 2;
		int y = interfaz.getAlto() - jugador.getHeight();
		jugador.setLocation(x, y);
		addColisionable(jugador);

		controlesPlayer = new ComandoPlayer(jugador, interfaz.getAncho() - 20);
		controlesPlayer.setJuego(this);
		interfaz.addKeyListener(controlesPlayer);

		this.addEntidad(jugador);
	}

	public void empezarJuego() {
		long frameStart;
		long frameEnd;
		long elapsedTime;

		cargarNivel();
		cargarOleada();

		interfaz.setCartelSuperiorIzquierdo(nivelActual.getNombre());

		// Las colisionadores se tienen que mover en una unidad fija de tiempo
		// por ej: 10 px por segundo
		// El problema es que no podemos asegurar que cada update ocurra cada un
		// segundo.
		// Denotemos a esta unidad de tiempo elegida como U

		// Para solucionar esto, calculamos lo que falta para alcanzar U.
		// Guardamos el tiempo cuando empezó el loop del update
		frameStart = System.nanoTime();
		deltaTime = 1;

		while (!Thread.currentThread().isInterrupted() && !termino) {
			administrarNiveles();

			update();

			chequearColisiones();

			// Este comando soluciona la baja en el rendimiento que desaparecia cuando
			// pasabamos el mouse por arriba o moviamos el player
			Toolkit.getDefaultToolkit().sync();

			// Guardamos el tiempo cuando termino el loop del update
			frameEnd = System.nanoTime();

			// Encontramos el tiempo que pasó entre inicio y fin del update
			elapsedTime = frameEnd - frameStart;

			// Calculamos el porcentaje de U transcurrido
			deltaTime = elapsedTime / (float) UNIDAD_DE_TIEMPO_EN_NANOSEGUNDOS;
			frameStart = frameEnd;

			vSync(elapsedTime);
		}
	}

	/**
	 * Realiza las acciones correspondientes a la finalizacion del juego tales como
	 * remover todas las entidades.
	 */
	private void terminarJuego() {
		termino = true;
		interfaz.removeKeyListener(controlesPlayer);
	}

	/**
	 * Verifica las colisiones entre los Colisionables y los Colisionadores
	 */
	private void chequearColisiones() {

		for (Colisionable colisionable : entidades.values()) { //Para simplificar los chequeos, todas las Entidades son colisionables
			Rectangle areaColisionable = ((Entidad) colisionable).getBounds();

			for (Colisionador colisionador : colisionadores.values()) {
				Rectangle areaColisionador = ((Entidad) colisionador).getBounds();

				if (areaColisionable.intersects(areaColisionador)) {
					colisionable.aceptarColision(colisionador);
				}
			}
		}
	}

	/**
	 * Detiene el thread por el tiempo necesario para obtener el framerate deseado
	 */
	private void vSync(long elapsedTime) {
		long sleepTime = (TIEMPO_POR_FRAME - elapsedTime) / NANOSEGUNDOS_EN_UN_MILISEGUNDO;
		if (sleepTime < 0)
			sleepTime = 0;
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Realiza todas las actividades que son requeridas dentro del loop del juego
	 */
	private void update() {
		// Actualizamos las colisionadores pasando como parámetro el porcentaje de U
		// Entonces, al mover una entidad que tiene velocidad 5px por U
		// supongamos que solo transcurrió medio U, deltaTime sería 0.5
		// Multiplicamos la velocidad por deltaTime y obtenemos 2.5px,
		// Osea, el movimiento correspondiente a su velocidad en el tiempo transcurrido

		// De esta forma las colisionadores no saltan
		// y su velocidad no cambia si cambiamos el frameRate
		for(Entidad ent : entidades.values()){
			ent.update(deltaTime);
		}
		chequearVidaPlayer();
		interfaz.updateBarraVida(jugador.getPorcentajeVida());
	}

	/**
	 * Se encarga de pasar de una oleada a otra o de un nivel a otro.
	 */
	public void administrarNiveles() {
		if (nivelActual.quedanInfectadosEnLaOleada() == false) {
			if (nivelActual.termino() == false) {
				cargarOleada();
				interfaz.setCartelSuperiorIzquierdo(nivelActual.getNombre());
			} else {
				if (niveles.quedanNiveles()) {
					cargarNivel();
					cargarOleada();
					interfaz.setCartelSuperiorIzquierdo(nivelActual.getNombre());
				} else {
					terminarJuego();
					mostrarCartelGanar();
				}
			}
		}
	}

	private void mostrarCartelGanar() {
		screen = new SplashScreen(3000);
		interfaz.setVisible(false);
		screen.mostrarPantallaGanar();
		System.exit(-1);
	}

	/**
	 * Analiza si el jugador sigue vivo y si no es asi procede a realizar la
	 * finalizacion del juego.
	 */
	private void chequearVidaPlayer() {
		if (jugador.getCargaViral() <= 0) {
			terminarJuego();
			mostrarCartelLose();
		}
	}

	private void mostrarCartelLose() {
		screen = new SplashScreen(3000);
		interfaz.setVisible(false);
		screen.mostrarPantallaPerder();
		System.exit(-1);
	}

	/*
	 * Actualiza el nivel al siguiente;
	 */
	private void cargarNivel() {
		nivelActual = niveles.getSiguienteNivel();
	}

	/*
	 * carga una nueva oleada.
	 */
	private void cargarOleada() {
		Infectado[] oleada = nivelActual.getOleada();

		// inserto infectados en gameController
		for (int i = 0; i < oleada.length; i++) {
			oleada[i].setMediador(this);
			addColisionable(oleada[i]);
			addColisionador(oleada[i]);
		}
	}

	/**
	 * Le indica a la interfaz que agregue un cartel con el texto del parametro, el
	 * cartel se mostrara por un periodo limitado de tiempo.
	 * 
	 * @param msj
	 */
	public void mostrarCartel(String msj) {
		JLabel cartel = interfaz.mostrarCartel(msj);
		interfaz.repaint();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		interfaz.removeEntidad(cartel);
		interfaz.repaint();
	}

	@Override
	public void decrementarInfectados() {
		nivelActual.decrementarOleada();
	}

	@Override
	public Jugador getPlayer() {
		return jugador;
	}

	@Override
	public void addColisionador(Colisionador colisionador) {
		colisionadores.put(colisionador.hashCode(), colisionador);
		addEntidad((Entidad) colisionador);
	}

	@Override
	public void addColisionable(Colisionable colisionable) {
		colisionables.put(colisionable.hashCode(), colisionable);
		addEntidad((Entidad) colisionable);
	}

	@Override
	public void addEntidad(Entidad entidad) {
		//entidadController.insertarEntidad(entidad);
		entidades.putIfAbsent(entidad.hashCode(), entidad);
		interfaz.addEntidad(entidad);
		interfaz.repaint();
	}

	@Override
	public void removeEntidad(Entidad entidad) {
		colisionadores.remove(entidad.hashCode());
		colisionables.remove(entidad.hashCode());
		entidades.remove(entidad.hashCode());
		interfaz.removeEntidad(entidad);
		interfaz.repaint();
	}

	public double getDeltaTime() {
		return deltaTime;
	}

	@Override
	public void relentizarInfectados(int tiempo) {
		nivelActual.relentizarOleada(tiempo);
	}
}
