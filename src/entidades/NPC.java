package entidades;

import javax.swing.JLabel;
import colisiones.*;
import juego.Vector;

public abstract class NPC extends Entidad {
	protected int saludActual;
	protected Vector velocidad;

	public NPC(Vector posicion) {
		super(posicion);
	}

	public Vector getVelocidad() {
		return new Vector(velocidad.x, velocidad.y);
	}

	@Override
	public void update() {
		int x = this.getLocation().x;
		int y = this.getLocation().y;

		this.setLocation(x + velocidad.x, y + velocidad.y);
	}

	public ZonaColision getZonaColision() {
		int centroX = (int) (this.getLocation().x - (this.getSize().getWidth()) / 2);
		int centroY = (int) (this.getLocation().y - (this.getSize().getHeight()) / 2);
		int radio = (int) (this.getSize().getHeight() / 2);
		return new ZonaColision(centroX, centroY, radio);
	}
}
