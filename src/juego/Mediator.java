package juego;

import entidades.Entidad;
import entidades.Jugador;

public abstract class Mediator {

	/**
	 * Elimina una entidad que requiere verificar sus colisiones
	 * 
	 * @param entidad
	 */
	public abstract void removeEntidad(Entidad entidad);

	/**
	 * Agrega una entidad que requiere verificar sus colisiones
	 * 
	 * @param entidad
	 */
	public abstract void addEntidad(Entidad entidad);

	
	/**
	 * Decrementa en uno la cantidad de infectados
	 */
	public abstract void decrementarInfectados();
	
	/**
	 * Devuelve el player.
	 */
	public abstract Jugador getPlayer();
	
	/**
	 * Relentiza la oleada actual de infectados
	 * @param i tiempo a relentizar la oleada.
	 */
	public abstract void relentizarInfectados(int i);

}
