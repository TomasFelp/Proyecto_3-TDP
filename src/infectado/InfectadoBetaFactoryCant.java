package infectado;

import entidades.Infectado;
import juego.Vector;

/**
 * Los primeros 50 infectados que crea seran Betas, los restantes seran Alfas
 *
 */
public class InfectadoBetaFactoryCant implements InfectadoFactory{
	private int contador;
	
	public InfectadoBetaFactoryCant(int c) {
		// TODO Auto-generated constructor stub
		contador=c;
	}
	
	@Override
	public Infectado crearInfectado(Vector posicion) {
		// TODO Auto-generated method stub
		Infectado inf;
		
		if(contador>=0) {
			inf=new InfectadoBeta(posicion);
			contador--;
		}else {
			inf=new InfectadoAlfa(posicion);
		}
		
		return inf;
	}
	
}
