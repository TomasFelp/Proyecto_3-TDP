package infectado;

import entidades.Infectado;
import juego.Vector;
import java.util.Random;

/**
 * 
 * Esta fabrica crea infectados Alfa y Beta en forma aleatoria.
 *
 */
public class InfectadoRandomFactory implements InfectadoFactory{

	private int alfas;
	
	/**
	 * Inicializa la fabrica indicando la relacion entre las cantidades de los tipos de infectados que construira.
	 * @param alfas cantidad de alfas que construira por cada Beta.
	 */
	public InfectadoRandomFactory(int alfas) {
		this.alfas=alfas;
	}
	
	@Override
	public Infectado crearInfectado(Vector posicion) {
		// TODO Auto-generated method stub
		Infectado inf;
		Random r=new Random();
		
		if(r.nextInt(alfas)!=0)
			inf=new InfectadoAlfa(posicion);
		else
			inf=new InfectadoBeta(posicion);
		
		return inf;
	}

}
