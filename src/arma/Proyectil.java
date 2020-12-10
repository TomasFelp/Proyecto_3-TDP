package arma;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JLabel;

import GUI.ImageProvider;
import entidades.Colisionador;
import entidades.Entidad;
import juego.Vector;

/**
 * 
 * Clase base proyectil, factoriza las cualidades comunes a los distintos tipos
 * de proyectiles.
 *
 */
public abstract class Proyectil extends Entidad implements Colisionador {

	protected int daño;

	public Proyectil(Vector posicion) {
		xReal = posicion.x;
		yReal = posicion.y;

		this.daño = 50;

		this.setVisible(true);
		this.setLocation(posicion.x, posicion.y);
		this.setSize(15, 15);
	}

	public void update(float deltaTime) {
		Vector desplazamiento = movimiento.calcularMovimiento(xReal, yReal);

		mover(desplazamiento.x * deltaTime, desplazamiento.y * deltaTime);

		if (xReal < 0 || yReal > 650)
			mediadorJuego.removeEntidad(this);
	}

}
