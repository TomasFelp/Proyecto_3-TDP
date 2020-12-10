package arma;

import java.awt.Point;

import entidades.Entidad;
import juego.Vector;

/**
 * 
 * Clase base proyectil, factoriza las cualidades comunes a los distintos tipos
 * de proyectiles.
 *
 */
public abstract class Proyectil extends Entidad{
	private static final int radioColision = 1;

	protected int dano;
	protected Vector velocidad;

	public Proyectil(Vector posicion) {
		xReal = posicion.x;
		yReal = posicion.y;

		this.velocidad=new Vector(0,10);

		this.setVisible(true);
		this.setLocation(posicion.x, posicion.y);
		this.setSize(15, 15);
		
		dano=50;
	}

	public void update(float deltaTime) {
		Vector desplazamiento = movimiento.calcularMovimiento(xReal, yReal);

		mover(desplazamiento.x * deltaTime, desplazamiento.y * deltaTime);

		if (xReal < 0 || yReal > 650)
			mediadorJuego.removeEntidad(this);
	}

	public int getDano(){
		return dano;
	}

}
