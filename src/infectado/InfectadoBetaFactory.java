package infectado;

import entidades.Infectado;
import juego.Vector;

/**
 * Esta fabrica solo crea infectados Beta.
 *
 */
public class InfectadoBetaFactory implements InfectadoFactory{

	@Override
	public Infectado crearInfectado(Vector posicion) {
		// TODO Auto-generated method stub
		return new InfectadoBeta(posicion);
	}

}
