package cerebros;

import java.util.*;
import java.util.Map.*;
import java.util.concurrent.ConcurrentHashMap;

import entidades.Entidad;
import entidades.Infectado;

/**
 * Modela un Singleton que controla los NPC del juego
 */
public class GameController {
	
	private Map<Integer, Entidad> entidades;
	private int sleepTime;

	public GameController() {
		entidades = new ConcurrentHashMap<Integer, Entidad>();
	}

	/**
	 * Agrega una entidad al controlador.
	 * 
	 * @param inf Infectado a agregar
	 */
	public void insertarEntidad(Entidad inf) {
		entidades.putIfAbsent(inf.hashCode(), inf);
	}

	/**
	 * Agrega una coleccion de entidades al controlador.
	 * 
	 * @param ent coleccion a agregar.
	 */
	public void insertarColeccionNPC(Infectado[] ent) {
		for (int i = 0; i < ent.length; i++) {
			entidades.put(ent[i].hashCode(), ent[i]);
		}
	}

	/**
	 * Recorre todas las entidades almacenadas y llama su funcion update()
	 */
	public void updateEntidades(float deltaTime) {
		for (Entry<Integer, Entidad> e : entidades.entrySet()) {
			e.getValue().update(deltaTime);
		}
	}

	/**
	 * Remueve una entidad de la coleccion de entidades.
	 * 
	 * @param e Entidad a borrar.
	 */
	public void removeEntidad(Entidad e) {
		entidades.remove(e.hashCode());
	}

	/**
	 * Devuelve la cantidad de entidades almacenadas.
	 * 
	 * @return Cantidad de entidades en la estructura.
	 */
	public int size() {
		return entidades.size();
	}
}
