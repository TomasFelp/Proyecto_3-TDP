package juego;

import cerebros.ComandoPlayer;
import cerebros.GameController;
import colisiones.CollisionManager;
import entidades.Entidad;
import entidades.Infectado;
import entidades.Jugador;

public class Juego extends Mediator {
	private static final int UNIDAD_DE_TIEMPO_EN_NANOSEGUNDOS = 10000000;
	private static final int NANOSEGUNDOS_EN_UN_SEGUNDO = 1000000000;
	private static final int FRAMERATE_DESEADO = 60;
	private static final int TIEMPO_POR_FRAME = NANOSEGUNDOS_EN_UN_SEGUNDO / FRAMERATE_DESEADO;
	private static final long NANOSEGUNDOS_EN_UN_MILISEGUNDO = 1000000;

	protected GUI_juego interfaz;
	protected Jugador jugador;
	protected Nivel nivel;
	protected ComandoPlayer controlesPlayer;
	protected GameController entidadController;
	protected CollisionManager colManager;
	private float deltaTime;

	public Juego(GUI_juego inter) {
		interfaz = inter;
		entidadController = new GameController();
		colManager = new CollisionManager();

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

		colManager.putEntidadVerificable(jugador);
	}

	@Override
	public void run() {
		long frameStart;
		long frameEnd;
		long elapsedTime;

		configurarNivel();

		// Las entidades se tienen que mover en una unidad fija de tiempo
		// por ej: 10 px por segundo
		// El problema es que no podemos asegurar que cada update ocurra cada un
		// segundo.
		// Denotemos a esta unidad de tiempo elegida como U

		// Para solucionar esto, calculamos lo que falta para alcanzar U.
		// Guardamos el tiempo cuando empezó el loop del update
		frameStart = System.nanoTime();
		deltaTime = 1;

		while (!Thread.currentThread().isInterrupted()) {
			update();

			// Guardamos el tiempo cuando termino el loop del update
			frameEnd = System.nanoTime();

			// Encontramos el tiempo que pasó entre inicio y fin del update
			elapsedTime = frameEnd - frameStart;

			vSync(elapsedTime);

			// Calculamos el porcentaje de U transcurrido
			deltaTime = elapsedTime / (float) UNIDAD_DE_TIEMPO_EN_NANOSEGUNDOS;
			frameStart = frameEnd;
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
			System.out.println("st: " + sleepTime);

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
		entidadController.updateEntidades(deltaTime);
		System.out.println("dt: " + deltaTime);
		colManager.updateColisiones();
	}

	private void configurarNivel() {
		// TODO: Pasamos interfaz.getAlto() de forma provisoria
		nivel = new Nivel(50, interfaz.getAlto());
		Infectado[] primerOleada = nivel.getPrimerOleada();

		// inserto infectados en gameController
		for (int i = 0; i < primerOleada.length; i++) {
			primerOleada[i].setMediador(this);
			addEntidadSecundaria(primerOleada[i]);
		}
	}

	public Jugador getJugador() {
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
	}

	public double getDeltaTime() {
		return deltaTime;
	}

}
