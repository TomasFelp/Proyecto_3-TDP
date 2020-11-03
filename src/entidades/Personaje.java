package entidades;

import javax.swing.JLabel;
import colisiones.*;

public abstract class Personaje extends Entidad_colisionable{
	
//Attributes
	protected int saludActual;
	protected int velocidad;
	
//Methods
	public int getVelocidad() {
		return velocidad;
	}
	
	public ZonaColision getZonaColision() {
		int centroX=(int) (this.getLocation().x-(this.getSize().getWidth())/2);
		int centroY=(int) (this.getLocation().y-(this.getSize().getHeight())/2);
		int radio=(int)(this.getSize().getHeight()/2);
		return new ZonaColision(centroX,centroY,radio);
	}
	

	
}
