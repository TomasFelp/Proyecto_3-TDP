package infectado;

import entidades.Movimiento;
import juego.Vector;

public class MovimientoInfectado implements Movimiento {

	@Override
	public Vector calcularMovimiento(float posX, float posY) {
		return new Vector(0, 1);
	}

}
