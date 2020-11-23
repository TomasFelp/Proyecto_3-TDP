package arma;

import juego.Vector;

public class ArmaSanitariaPower implements Arma{

	public Proyectil disparar(Vector posicion) {
		System.out.println("shot");
		Proyectil p = new Proyectil_sanitario_power(new Vector((int)posicion.getX(),(int)posicion.getY()));
		return p;
	}
}
