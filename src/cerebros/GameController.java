package cerebros;

import java.awt.*;
import java.util.*;
import java.util.Map.*;

import entidades.Entidad;
import entidades.Infectado;
import colisiones.CollisionManager;
import entidades.Jugador;
import juego.Juego;
import juego.Mapa;

/**
 * Modela un Singleton que controla los NPC del juego
 */
public class GameController extends Thread {
	private static GameController instancia;
	private CollisionManager colManager;
	private Mapa mapa;

	private Juego juego;

	private Jugador jugador;
	private Map<Integer, Infectado> entidades;
	private int sleepTime;

	public GameController() {
		entidades = new HashMap<Integer, Infectado>();
		sleepTime = 1000;
	}

	public void setCollisionManager(CollisionManager c) {
		colManager = c;
	}

	public void setMapa(Mapa m) {
		mapa = m;
	}

	public void setJuego(Juego juego){
		this.juego = juego;

		//Aprovecha para incluir una referencia al jugador
		jugador = juego.getJugador();
	}
	
	public Mapa getMapa() {
		return mapa;
	}


	/**
	 * Devuelve la instancia de GameController.
	 */
	public static GameController getInstancia() {
		if (instancia == null) {
			instancia = new GameController();
		}
		return instancia;
	}

	/**
	 * Agrega un NPC al hilo.
	 * 
	 * @param inf Infectado a agregar
	 */
	public void insertarInfectado(Infectado inf) {
		entidades.putIfAbsent(inf.hashCode(), inf);
		actualizarSleepTime();
	}

	/**
	 * Agrega una coleccion de entidades al hilo.
	 * 
	 * @param ent coleccion a agregar.
	 */
	public void insertarColeccionNPC(Infectado[] ent) {
		for (int i = 0; i < ent.length; i++) {
			entidades.put(ent[i].hashCode(), ent[i]);
		}
		actualizarSleepTime();
	}

	/**
	 * Permite regular la velocidad del tiempo de sleep del run, para que sin
	 * importar la cantidad de NPC se desplacen a la misma velocidad.
	 * 
	 * (Mejoro pero no es constante, hay que perfeccionarlo.)
	 */
	private void actualizarSleepTime() {
		sleepTime = 1000 / entidades.size();
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			try {
				Thread.sleep(sleepTime);
				updateEntidades();

				colManager.updateColisiones();
				//chequearColosiones();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void chequearColosiones(){
		Rectangle areaJugador = jugador.getBounds();

		for(Entry<Integer, Infectado> e : entidades.entrySet()){ //Para cada infectado
			Rectangle areaInfectado = e.getValue().getBounds();

			if(areaJugador.intersects(areaInfectado)){
				jugador.accionar();
			}
		}

		//Mi idea es despues hacer: "para cada premio que cae"
	}

	/**
	 * Recorre todas las entidades almacenadas y llama su funcion update()
	 */
	private void updateEntidades() {
		for (Entry<Integer, Infectado> e : entidades.entrySet()) {
			e.getValue().update();
		}
	}
}
