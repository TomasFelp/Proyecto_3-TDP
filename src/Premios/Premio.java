package Premios;

import java.awt.Color;
import java.awt.Point;
import java.util.List;
import java.util.Random;

import arma.ArmaSanitariaPower;
import entidades.Colisionador;
import entidades.Entidad;
import entidades.Jugador;
import juego.Vector;

/**
 * Modela el comportamiento general de un premio.
 *
 */
public abstract class Premio extends Entidad implements Colisionador {
//Attributes
	protected Vector velocidad;
	
//Builder
	public Premio() {
		setSize(20, 20);

		Random r=new Random();
		velocidad=new Vector(0,r.nextInt(5)+1);
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
		// TODO Auto-generated method stub
		Point posicion = this.getLocation();

		mover(velocidad.x * deltaTime, velocidad.y * deltaTime);

		if (posicion.getY() < 0 || posicion.getY() > 650)
			mediadorJuego.removeEntidad(this);
	}
	
}
