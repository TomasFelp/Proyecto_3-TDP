package arma;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JLabel;

import GUI.ImageProvider;
import entidades.Colisionador;
import entidades.Entidad;
import juego.Vector;

public abstract class Proyectil extends Entidad implements Colisionador {
	private static final int radioColision = 1;

	protected int daño;
	protected Vector velocidad;

	public Proyectil(Vector posicion) {
		xReal = posicion.x;
		yReal = posicion.y;

		this.daño = 50;
		this.velocidad=new Vector(0,10);

		this.setVisible(true);
		this.setLocation(posicion.x, posicion.y);
		this.setSize(15, 15);
	}

	public void update(float deltaTime) {
		Point posicion = this.getLocation();

		mover(velocidad.x * deltaTime, velocidad.y * deltaTime);

		if (posicion.getY() < 0 || posicion.getY() > 650)
			mediadorJuego.removeEntidad(this);
	}

	public int getDaño() {
		return daño;
	}

	public void destruir() {
	}
}
