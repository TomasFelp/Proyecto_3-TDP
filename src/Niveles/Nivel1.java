package Niveles;

import java.util.Random;

import entidades.*;
import infectado.InfectadoAlfa;
import infectado.InfectadoAlfaFactory;
import infectado.InfectadoBeta;
import infectado.InfectadoBetaFactory;
import infectado.InfectadoRandomFactory;
import juego.Vector;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Nivel concreto de digicultad facil, los infectados se encuentran esparcidos en forma aleatoria. contiene 2 oleadas.
 *
 */
public class Nivel1 extends NivelBase{

//Builder
	public Nivel1() {
		
		oleadas=new LinkedList<Infectado[]>();
		
		fabricaInfectados=new InfectadoRandomFactory(4);
		oleadas.add(armarOleada(10));
		
		fabricaInfectados=new InfectadoRandomFactory(3);
		oleadas.add(armarOleada(20));
		
		numOleadaActual=0;
	}

//Methods
	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return "Nivel 1 - oleada "+numOleadaActual;
	}
}








