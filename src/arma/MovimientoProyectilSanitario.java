package arma;

import entidades.Movimiento;
import juego.Vector;

public class MovimientoProyectilSanitario implements Movimiento {

	@Override
	public Vector calcularMovimiento(float posX, float posY) {
		return new Vector(0,-10);
	}

}
