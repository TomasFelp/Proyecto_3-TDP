package Niveles;

import java.util.LinkedList;

import entidades.Infectado;
import infectado.InfectadoAlfaFactory;
import infectado.InfectadoRandomFactory;

/**
 * Nivel concreto de digicultad media, los infectados se encuentran esparcidos en forma aleatoria. contiene 2 oleadas.
 *
 */
public class Nivel2 extends NivelBase{

//Builder
	public Nivel2() {
		oleadas=new LinkedList<Infectado[]>();
		
		fabricaInfectados=new InfectadoRandomFactory(2);
		
		oleadas.add(armarOleada(25));
		oleadas.add(armarOleada(50));
	}
	
//Methods
	public String getNombre() {
		// TODO Auto-generated method stub
		return "Nivel 2 - oleada "+numOleadaActual;
	}
}
