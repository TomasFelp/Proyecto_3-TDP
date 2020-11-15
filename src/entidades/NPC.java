package entidades;

import javax.swing.JLabel;
import colisiones.*;
import juego.Vector;

public abstract class NPC extends Entidad {
	protected int saludActual;
	protected Vector velocidad;

	@Override
	public void update() {
		int x = this.getLocation().x;
		int y = this.getLocation().y;

		this.setLocation(x + velocidad.x, y + velocidad.y);
	}


}
