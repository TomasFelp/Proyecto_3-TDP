package arma;

import juego.Vector;

/**
 * Este arma dispara proyectiles sanitarios perforadores.
 *
 */
class ArmaSanitariaPerforadora implements Arma{

	@Override
	public Proyectil disparar(Vector posicion) {
		// TODO Auto-generated method stub
		Proyectil p = new Proyectil_sanitario_perforador(new Vector((int)posicion.getX(),(int)posicion.getY()));
		return p;
	}

}
