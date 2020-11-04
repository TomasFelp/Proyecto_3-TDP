package proyectil;

import java.awt.Point;

import entidades.Entidad_colisionable;

public abstract class Proyectil_sanitario extends Entidad_colisionable{
	protected int damage;
	protected Point origen;

	public abstract int getDamage();

}
