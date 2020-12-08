package Niveles;

import java.util.Random;

import entidades.*;
import infectado.InfectadoAlfa;
import infectado.InfectadoBeta;
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
		oleadas.add(armarOleada(10,5));
		oleadas.add(armarOleada(12,15));
		numOleadaActual=0;
	}

//Methods
	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return "Nivel 1 - oleada "+numOleadaActual;
	}
}








