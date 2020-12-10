package infectado;

import entidades.Infectado;
import juego.Vector;

/**
 * 
 * Esta fabrica solo crea infectados alfa.
 *
 */
public class InfectadoAlfaFactory implements InfectadoFactory{

	@Override
	public Infectado crearInfectado(Vector posicion) {
		// TODO Auto-generated method stub
		return new InfectadoAlfa(posicion);
	}

}
