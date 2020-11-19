package juego;

import entidades.Entidad;

public interface Mediator {
	
	/**
	 * Elimina una entidad que requiere verificar sus colisiones
	 * @param entidad
	 */
	public void removeEntidad(Entidad entidad);
	
	/**
	 * Elimina una entidad que No requiere verificar sus colisiones
	 * @param entidad
	 */
	public void removeEntidadSecundaria(Entidad entidad);
	
	/**
	 * Agrega una entidad que requiere verificar sus colisiones
	 * @param entidad
	 */
	public void addEntidad(Entidad entidad);
	
	/**
	 * Agrega una entidad que No requiere verificar sus colisiones
	 * @param entidad
	 */
	public void addEntidadSecundaria(Entidad entidad);
	
	
	//Pendiente los metodos para agregar las entidades no verificables (respecto del collisionManager)
}
