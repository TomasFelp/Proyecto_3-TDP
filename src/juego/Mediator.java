package juego;

import entidades.Colisionable;
import entidades.Colisionador;
import entidades.Entidad;
import entidades.Jugador;

public abstract class Mediator {

	/**
	 * Añade una referencia a un colisionador del juego
	 * @param colisionador entidad que puede impactar en una entidad colisionable
	 */
	public abstract void addColisionador(Colisionador colisionador);

	/**
	 * Añade una referencia a un colisionable del juego
	 * @param colisionable entidad que puede ser impactada por una entidad colisionadora
	 */
	public abstract void addColisionable(Colisionable colisionable);

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
