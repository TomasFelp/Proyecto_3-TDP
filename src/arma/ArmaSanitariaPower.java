package arma;

import juego.Vector;

public class ArmaSanitariaPower implements Arma{

	public Proyectil disparar(Vector posicion) {
		System.out.println("shot");
		Proyectil p = new Proyectil_sanitario(posicion,new Vector(0,-20));
		return p;
	}
}
