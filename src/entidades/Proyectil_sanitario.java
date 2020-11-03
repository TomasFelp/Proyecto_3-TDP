package entidades;

import java.awt.Point;

public abstract class Proyectil_sanitario extends Entidad_colisionable{

//Attributes
	protected int damage;
	protected Point origen;
	
//Builder
	
//Methods	
	public abstract int getDamage();

}
