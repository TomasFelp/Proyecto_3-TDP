package infectado;

import entidades.Infectado;
import juego.Vector;

/**
 * Los primeros 50 infectados que crea seran Betas, los restantes seran Alfas
 *
 */
public class InfectadoBetaFactory50 implements InfectadoFactory{
	private int contador;
	
	public InfectadoBetaFactory50() {
		// TODO Auto-generated constructor stub
		contador=0;
	}
	
	@Override
	public Infectado crearInfectado(Vector posicion) {
		// TODO Auto-generated method stub
		Infectado inf;
		
		if(contador<=50) {
			inf=new InfectadoBeta(posicion);
			contador++;
		}else {
			inf=new InfectadoAlfa(posicion);
		}
		
		return inf;
	}
	
}
