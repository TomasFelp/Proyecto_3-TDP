package entidades;

import juego.Mapa;

public interface NPC {
	
	public int getID();
	
	public void update(Mapa mapa);
	
	/**
	 * Determina si el objeto esta en su ciclo de vida para ver si vale la pena o no
	 * almacenarlo.
	 * @return true si esta en su ciclo de vida, false de lo contrario. 
	 */
	public boolean itsAlive();
}
