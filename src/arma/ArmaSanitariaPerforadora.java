package arma;

import juego.Vector;

public class ArmaSanitariaPerforadora implements Arma{

	@Override
	public Proyectil disparar(Vector posicion) {
		// TODO Auto-generated method stub
		System.out.println("shot");
		Proyectil p = new Proyectil_sanitario_perforador(new Vector((int)posicion.getX(),(int)posicion.getY()));
		return p;
	}

}