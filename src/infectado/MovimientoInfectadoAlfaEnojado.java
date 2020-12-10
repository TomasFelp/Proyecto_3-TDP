package infectado;

import entidades.Movimiento;
import juego.PosicionReal;
import juego.Vector;

public class MovimientoInfectadoAlfaEnojado implements Movimiento {
	private static final int multiplicadorVelocidad = 2;
	private Movimiento movimientoDefaultInfectado;
	
	public MovimientoInfectadoAlfaEnojado() {
		movimientoDefaultInfectado = new MovimientoInfectado();
	}
	
	@Override
	public Vector calcularMovimiento(float posX, float posY) {
		Vector desplazamiento = movimientoDefaultInfectado.calcularMovimiento(posX, posY);
		desplazamiento.multiplicar(multiplicadorVelocidad);
		
		return desplazamiento; 
	}

}
