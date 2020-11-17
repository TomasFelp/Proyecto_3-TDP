package entidades;

import javax.swing.JLabel;
import colisiones.*;
import juego.Vector;

public abstract class NPC extends Entidad {
	protected Vector velocidad;

	public NPC(Vector posicion) {
		super(posicion);
	}

	public Vector getVelocidad() {
		return new Vector(velocidad.x, velocidad.y);
	}

	
	/**
     * Se llama en cada secuencia de actualizacion del GameController
     */
    public abstract void update();
 

	public ZonaColision getZonaColision() {
		int centroX = (int) (this.getLocation().x - (this.getSize().getWidth()) / 2);
		int centroY = (int) (this.getLocation().y - (this.getSize().getHeight()) / 2);
		int radio = (int) (this.getSize().getHeight() / 2);
		return new ZonaColision(centroX, centroY, radio);
	}
}
