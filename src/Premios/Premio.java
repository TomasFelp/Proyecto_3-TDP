package Premios;

import java.util.Random;

import entidades.Colisionador;
import entidades.Entidad;
import juego.Vector;

/**
 * Modela el comportamiento general de un premio.
 *
 */
public abstract class Premio extends Entidad implements Colisionador {
//Builder
	public Premio() {
		setSize(20, 20);

		setMovimiento(new MovimientoPremio());
	}
	
//Methods
	public void setPosicion(Vector posicion) {
		this.setLocation(posicion);
		this.setPosicionReal(posicion.x, posicion.y);
	}
	
	@Override 
	public abstract Premio clone();
	
	@Override
	public void update(float deltaTime) {
		Vector velocidad = movimiento.calcularMovimiento(xReal, yReal);

		mover(velocidad.x * deltaTime, velocidad.y * deltaTime);

		if (yReal < 0 || yReal > 650)
			mediadorJuego.removeEntidad(this);
	}
	
}
