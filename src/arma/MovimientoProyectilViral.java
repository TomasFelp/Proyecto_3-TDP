package arma;

import entidades.Movimiento;
import juego.Vector;

public class MovimientoProyectilViral implements Movimiento {

	@Override
	public Vector calcularMovimiento(float posX, float posY) {
		return new Vector(0,1);
	}

}
