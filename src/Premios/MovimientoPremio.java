package Premios;

import java.util.Random;

import entidades.Movimiento;
import juego.Vector;

public class MovimientoPremio implements Movimiento {

	@Override
	public Vector calcularMovimiento(float posX, float posY) {
		Random r = new Random();
		int movX = (r.nextInt(11) - 5);
		int movY = (r.nextInt(7) - 2);
		Vector movimiento = new Vector(movX, movY);

		return movimiento;
	}

}
