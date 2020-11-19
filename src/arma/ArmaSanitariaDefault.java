package arma;

import java.awt.Point;

import juego.Vector;

class ArmaSanitariaDefault implements Arma{

	@Override
	public Proyectil disparar(Vector posicion) {
		System.out.println("shot");
		Proyectil p=new Proyectil_sanitario(posicion,new Vector(0,-5));
		return p;
	}

}
