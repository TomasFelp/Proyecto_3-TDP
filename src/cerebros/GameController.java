package cerebros;

import java.awt.*;
import java.util.*;
import java.util.Map.*;
import java.util.concurrent.ConcurrentHashMap;

import entidades.Entidad;
import entidades.Infectado;
import colisiones.CollisionManager;
import entidades.Jugador;
import juego.Juego;

/**
 * Modela un Singleton que controla los NPC del juego
 */
public class GameController extends Thread {
	
//Attributes
	private static GameController instancia;
	private CollisionManager colManager;
	private Map<Integer, Entidad> entidades;
	private int sleepTime;

//Builder
	private GameController() {
		entidades = new ConcurrentHashMap<Integer, Entidad>();
		sleepTime = 1000;
	}

//Methods
	
	/**
	 * Le asigna un collisionManager.
	 * 
	 * 
	 * >>>>>>>>>>>>>>>>>>>>>>>esto es con la idea de que la clase juego sea la encargada de agregar los infectados al collisionManager<<<----------------- 
	 * >>>>>>>>>>>>>>>>>>>>>>>En todo caso se puee volver a crear en el constructor y que los agregue al collisionManager cuando agrega las entidades a la lista, pero la idea es que gameController no tiene acceso al player directamente<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	 * @param c
	 */
	public void setCollisionManager(CollisionManager c) {
		colManager = c;
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
	public void insertarEntidad(Entidad inf) {
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
				try {
				updateEntidades();
				}catch(Exception e) {
					System.out.println("Error en updateEntidades");
				}
				colManager.updateColisiones();
				//chequearColosiones();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
/* Lo comente nada más para que no haya confuciones, ya que actualmente las colisiones se estan evaluando con CollisionManager
 * 
 * 
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
*/
	/**
	 * Recorre todas las entidades almacenadas y llama su funcion update()
	 */
	private void updateEntidades() {
		for (Entry<Integer, Entidad> e : entidades.entrySet()) {
			e.getValue().update();
		}
	}
	
	public void removeEntidad(Entidad e) {
		entidades.remove(e.hashCode());
	}
}
