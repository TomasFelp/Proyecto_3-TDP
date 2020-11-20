package juego;

import cerebros.ComandoPlayer;
import cerebros.GameController;
import colisiones.CollisionManager;
import entidades.Entidad;
import entidades.Infectado;
import entidades.Jugador;

public class Juego extends Mediator {
	protected GUI_juego interfaz;
	protected Jugador jugador;
	protected Nivel nivel;
	protected ComandoPlayer controlesPlayer;
	protected GameController entidadController;
	protected CollisionManager colManager;
	private int sleepTime;

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

		colManager.putEntidadVerificable(jugador);
	}

	@Override
	public void run() {
		configurarNivel();
		actualizarSleepTime();
		
		while (!Thread.currentThread().isInterrupted()) {
			try {
				Thread.sleep(sleepTime);
				entidadController.updateEntidades();
				colManager.updateColisiones();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void configurarNivel() {
		nivel = new Nivel(50, interfaz.getAlto());// <------------------------------------------provisorio
		Infectado[] primerOleada = nivel.getPrimerOleada();

		// inserto infectados en gameController
		for (int i = 0; i < primerOleada.length; i++) {
			primerOleada[i].setMediador(this);
			addEntidadSecundaria(primerOleada[i]);
		}
	}

	/**
	 * Permite regular la velocidad del tiempo de sleep del run, para que sin
	 * importar la cantidad de NPC se desplacen a la misma velocidad.
	 * 
	 * (Mejoro pero no es constante, hay que perfeccionarlo.)
	 */
	private void actualizarSleepTime() {
		sleepTime = 1000 / entidadController.size();
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

}
