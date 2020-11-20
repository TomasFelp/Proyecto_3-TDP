package juego;

import entidades.Entidad;

public abstract class Mediator extends Thread {

	/**
	 * Elimina una entidad que requiere verificar sus colisiones
	 * 
	 * @param entidad
	 */
	public abstract void removeEntidad(Entidad entidad);

	/**
	 * Elimina una entidad que No requiere verificar sus colisiones
	 * 
	 * @param entidad
	 */
	public abstract void removeEntidadSecundaria(Entidad entidad);

	/**
	 * Agrega una entidad que requiere verificar sus colisiones
	 * 
	 * @param entidad
	 */
	public abstract void addEntidad(Entidad entidad);

	/**
	 * Agrega una entidad que No requiere verificar sus colisiones
	 * 
	 * @param entidad
	 */
	public abstract void addEntidadSecundaria(Entidad entidad);

	// Pendiente los metodos para agregar las entidades no verificables (respecto
	// del collisionManager)
}
