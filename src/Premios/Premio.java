package Premios;

import java.awt.Color;
import java.awt.Point;
import java.util.List;
import java.util.Random;

import arma.ArmaSanitariaPower;
import entidades.Entidad;
import entidades.Jugador;
import juego.Vector;

public abstract class Premio extends Entidad{
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
	
	public abstract Premio clone();
	
	@Override
	public void update(float deltaTime) {
		// TODO Auto-generated method stub
		Point posicion = this.getLocation();

		mover(velocidad.x * deltaTime, velocidad.y * deltaTime);

		if (posicion.getY() < 0 || posicion.getY() > 650)
			mediadorJuego.removeEntidad(this);
	}
	
	public void enColision(List<Entidad> colisiones) {
		Jugador player=mediadorJuego.getPlayer();
		for(Entidad ent:colisiones) {
			if(ent==player) {
				activarPoder(player);
				mediadorJuego.removeEntidad(this);
			}
		}
	}
	
	/**
	 * Metodo que establece el comportamiento especifico del premio
	 * >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Este es el metodo que hay que redefinir para cada premio
	 * @param player
	 */
	protected abstract void activarPoder(Jugador player);
	
}
