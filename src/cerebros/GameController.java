package cerebros;

import java.util.*;
import java.util.Map.*;

import colisiones.CollisionManager;
import entidades.NPC;
import juego.Mapa;

/**
 * Modela un Singleton que controla los NPC del juego
 */
public class GameController extends Thread {
	private static GameController instancia;
	private CollisionManager colManager;
	private Mapa mapa;
	private Map<Integer, NPC> entidades;
	private int sleepTime;

	private GameController() {
		entidades = new HashMap<Integer, NPC>();
		sleepTime = 1000;
		colManager = new CollisionManager();
	}
	
	public void setMapa(Mapa m) {
		mapa = m;
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
	 * @param entidad NPC a agregar
	 */
	public void insertarNPC(NPC entidad) {
		entidades.putIfAbsent(entidad.hashCode(), entidad);
		actualizarSleepTime();
	}

	/**
	 * Agrega una coleccion de entidades al hilo.
	 * 
	 * @param ent coleccion a agregar.
	 */
	public void insertarColeccionNPC(NPC[] ent) {
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
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Recorre todas las entidades almacenadas y llama su funcion update()
	 */
	private void updateEntidades() {
		for (Entry<Integer, NPC> e : entidades.entrySet()) {
			e.getValue().update();
		}
	}
}
