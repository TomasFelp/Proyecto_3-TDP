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
	
	
	

	
}
