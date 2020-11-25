package juego;

import java.awt.Toolkit;

import javax.swing.JLabel;

import cerebros.ComandoPlayer;
import cerebros.GameController;
import colisiones.CollisionManager;
import entidades.Entidad;
import entidades.Infectado;
import entidades.Jugador;

public class Juego extends Mediator {
	private static final int UNIDAD_DE_TIEMPO_EN_NANOSEGUNDOS = 10000000;
	private static final int NANOSEGUNDOS_EN_UN_SEGUNDO = 1000000000;
	private static final int FRAMERATE_DESEADO = 120;
	private static final int TIEMPO_POR_FRAME = NANOSEGUNDOS_EN_UN_SEGUNDO / FRAMERATE_DESEADO;
	private static final long NANOSEGUNDOS_EN_UN_MILISEGUNDO = 1000000;

	protected GUI_juego interfaz;
	protected Jugador jugador;
	protected Generador_de_niveles niveles;
	protected Nivel nivelActual;
	protected ComandoPlayer controlesPlayer;
	protected GameController entidadController;
	protected CollisionManager colManager;
	private float deltaTime;

	public Juego(GUI_juego inter) {
		interfaz = inter;
		entidadController = new GameController();
		colManager = new CollisionManager();
		
		niveles=new Generador_de_niveles();
		
		this.setPriority(Thread.MAX_PRIORITY);
		configurarJugador();
	}

	private void configurarJugador() {
		jugador = new Jugador();
		interfaz.addEntidad(jugador);
		int x = interfaz.getAncho() / 2 - jugador.getWidth() / 2;
		int y = interfaz.getAlto() - jugador.getHeight();
		jugador.setLocation(x, y);

		controlesPlayer = new ComandoPlayer(jugador, interfaz.getAncho() - 20);
		controlesPlayer.setJuego(this);
		interfaz.addKeyListener(controlesPlayer);

		entidadController.insertarEntidad(jugador);

		colManager.putEntidad(jugador);
		colManager.putEntidadVerificable(jugador);
	}

	@Override
	public void run() {
		long frameStart;
		long frameEnd;
		long elapsedTime;

		cargarNivel();
		cargarOleada();

		// Las entidades se tienen que mover en una unidad fija de tiempo
		// por ej: 10 px por segundo
		// El problema es que no podemos asegurar que cada update ocurra cada un
		// segundo.
		// Denotemos a esta unidad de tiempo elegida como U

		// Para solucionar esto, calculamos lo que falta para alcanzar U.
		// Guardamos el tiempo cuando empezó el loop del update
		frameStart = System.nanoTime();
		deltaTime = 1;

		while (!Thread.currentThread().isInterrupted() && (niveles.quedanNiveles() || nivelActual.quedanInfectadosEnLaOleada())) {
			administrarNiveles();
			
			update();
			
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
		mostrarCartel("GAME OVER");
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
		// Actualizamos las entidades pasando como parámetro el porcentaje de U
		// Entonces, al mover una entidad que tiene velocidad 5px por U
		// supongamos que solo transcurrió medio U, deltaTime sería 0.5
		// Multiplicamos la velocidad por deltaTime y obtenemos 2.5px,
		// Osea, el movimiento correspondiente a su velocidad en el tiempo transcurrido

		// De esta forma las entidades no saltan
		// y su velocidad no cambia si cambiamos el frameRate
		entidadController.updateEntidades(deltaTime);
		colManager.updateColisiones();
	}
	
	/**
	 * Se encrga de pasar de una oleada a otra o de un nivel a otro.
	 */
	public void administrarNiveles() {
		if(nivelActual.quedanInfectadosEnLaOleada()==false) {
			if(nivelActual.termino()==false) {
				mostrarCartel("OLEADA COMPLETADA");
				cargarOleada();
			}else {
				mostrarCartel("NIVEL COMPLETADO");
				if(niveles.quedanNiveles()) {
					cargarNivel();
					cargarOleada();
				}
			}	
		}
	}

	/*
	 * Actualiza el nivel al siguiente;
	 */
	private void cargarNivel() {
		// TODO: Pasamos interfaz.getAlto() de forma provisoria
		nivelActual = niveles.getSiguienteNivel();
	}
	/*
	 * carga una nueva oleada.
	 */
	private void cargarOleada() {
		// TODO Auto-generated method stub
		Infectado[] oleada = nivelActual.getOleada();

		// inserto infectados en gameController
		for (int i = 0; i < oleada.length; i++) {
			oleada[i].setMediador(this);
			addEntidadSecundaria(oleada[i]);
		}
	}
	
	/**
	 * Le indica a la interfaz que agregue un cartel con el texto del parametro.
	 * 
	 * >>>>>>>>>>>>>>>>>>>>>>Solucionar que los infectados se siguen desplazando mientras esta el cartel<<<<<<<<<<<<<<<<<<<<<<<<<
	 * 
	 * @param msj
	 */
	public void mostrarCartel(String msj) {
		JLabel cartel=interfaz.mostrarCartel(msj);
		interfaz.repaint();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		interfaz.removeEntidad(cartel);
		interfaz.repaint();
	}
	
	public void decrementarInfectados() {
		nivelActual.decrementarOleada();
	}

	public Jugador getPlayer() {
		return jugador;
	}

	@Override
	public void addEntidad(Entidad entidad) {
		addGeneral(entidad);
		colManager.putEntidadVerificable(entidad);
	}

	@Override
	public void addEntidadSecundaria(Entidad entidad) {
		addGeneral(entidad);
		colManager.putEntidad(entidad);
	}

	public void addGeneral(Entidad entidad) {
		entidadController.insertarEntidad(entidad);
		interfaz.addEntidad(entidad);
		interfaz.repaint();
	}

	@Override
	public void removeEntidad(Entidad entidad) {
		removeGeneral(entidad);
		colManager.removeEntidadVerificable(entidad);
	}

	@Override
	public void removeEntidadSecundaria(Entidad entidad) {
		removeGeneral(entidad);
		colManager.removeEntidad(entidad);
	}

	private void removeGeneral(Entidad entidad) {
		entidadController.removeEntidad(entidad);
		interfaz.removeEntidad(entidad);
		interfaz.repaint();
	}

	public double getDeltaTime() {
		return deltaTime;
	}

	@Override
	public void relentizarInfectados() {
		// TODO Auto-generated method stub
		nivelActual.relentizarOleada();
	}

}
