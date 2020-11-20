package colisiones;

import java.util.*;
import java.util.Map.*;
import java.util.concurrent.ConcurrentHashMap;

import entidades.Entidad;

/**
 * Mantiene referencia a todas las entidades que requieran verificar algun tipo de colision.
 */
public class CollisionManager {
	private Map<Integer, Entidad> entidades;
	private Map<Integer, Entidad> entidadesParaVerificar;

	public CollisionManager() {
		entidades=new ConcurrentHashMap<Integer, Entidad>();
		entidadesParaVerificar=new ConcurrentHashMap<Integer, Entidad>();
	}
	
	/**
	 * Determina se dos zonas de colision circulares estan en contacto
	 * 
	 * @param za zona de colision 1.
	 * @param zb zona de colision 2.
	 * @return True si estan en contacto, false en caso contrario.
	 */
	static public boolean estanEnContacto(ZonaColision za, ZonaColision zb) {
		double distancia = distanciaCentros(za, zb);
		/*
		 * Dos zonas de colision circulares estan en contacto si la suma de sus radios
		 * es menor a la distancia entre sus centros.
		 */

		return (za.getRadio() + zb.getRadio()) > distancia;
	}

	/**
	 * Calcula la distancia entre los centros de dos zonas de colision.
	 */
	static private double distanciaCentros(ZonaColision za, ZonaColision zb) {
		double distanciaX = Math.abs(za.getCentroX() - zb.getCentroX());
		double distanciaY = Math.abs(za.getCentroY() - zb.getCentroY());

		return Math.sqrt(Math.pow(distanciaX, 2) + Math.pow(distanciaY, 2));
	}

	/**
	 * Para cada entidad a verificar, obtiene una lista de las entidades con las que esta
	 * colisionando y, si esta no es vacía, se la pasa como parametro de la funcion enColision.
	 */
	public void updateColisiones() {
		List<Entidad> colisiones;
	
		for (Entry<Integer, Entidad> e : entidadesParaVerificar.entrySet()) {
			colisiones = obtenerColisiones(e.getValue());
			if (!colisiones.isEmpty())
				e.getValue().enColision(colisiones);
		}
	}

	/**
	 * Dado una entidad, obtiene una lista de todas las entidades con las que esta colisionando.
	 * @param entA Entidad a la que se verifican las colisiones.
	 * @return Lista de colisiones de entA.
	 */
	public List<Entidad> obtenerColisiones(Entidad entA) {
		Entidad entB;
		List<Entidad> colisiones = new ArrayList<>();
		ZonaColision zonaColisionA = entA.getZonaColision();
		ZonaColision zonaColisionB;

		for (Entry<Integer, Entidad> e : entidades.entrySet()) {
			entB = e.getValue();
			zonaColisionB = entB.getZonaColision();
			if (entB != entA && estanEnContacto(zonaColisionA, zonaColisionB)) {
				colisiones.add(entB);
			}
		}

		return colisiones;
	}
	
	/**
	 * Inserta una entidad en la lista de entidades con las que se pude colisionar.
	 * @param entidad entidad que se va a agregar.
	 */
	public void putEntidad(Entidad entidad) {
		entidades.put(entidad.hashCode(), entidad);
	}
	
	/**
	 * Remueve una entidad en la lista de entidades con las que se pude colisionar.
	 * @param entidad entidad que se va a remover.
	 */
	public void removeEntidad(Entidad entidad) {
		entidades.remove(entidad.hashCode());
	}
	
	/**
	 * Inserta una entidad en la lista de entidades para las que se va a verificar colision.
	 * @param entidad entidad que se va a agregar.
	 */
	public void putEntidadVerificable(Entidad entidad) {
		entidadesParaVerificar.put(entidad.hashCode(), entidad);
	}
	
	/**
	 * Remueve una entidad en la lista de entidades para las que se va a verificar colision.
	 * @param entidad entidad que se va a agregar.
	 */
	public void removeEntidadVerificable(Entidad entidad) {
		entidadesParaVerificar.remove(entidad.hashCode());
	}
}
