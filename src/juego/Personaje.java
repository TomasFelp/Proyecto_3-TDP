package juego;

import javax.swing.JLabel;

public abstract class Personaje extends JLabel{
	
//Attributes
	protected int saludActual;
	protected int velocidad;
	protected EntidadGrafica grafico;
	
//Methods
	public int getVelocidad() {
		return velocidad;
	}
	
	public ZonaColision getZonaColision() {
		int centro=(int) (this.getLocation().x-(this.getSize().getWidth())/2);
		int radio=(int)(this.getSize().getHeight()/2);
		return new ZonaColision(centro,radio);
	}
	

	
}
