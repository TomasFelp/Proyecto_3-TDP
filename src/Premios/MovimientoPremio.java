package Premios;

import java.util.Random;

import entidades.Movimiento;
import juego.Vector;

public class MovimientoPremio implements Movimiento {

	@Override
	public Vector calcularMovimiento(float posX, float posY) {
		Random r = new Random();
		int movX = 0;
		int movY = (r.nextInt(3) + 1);
		Vector movimiento = new Vector(movX, movY);

		return movimiento;
	}

}
