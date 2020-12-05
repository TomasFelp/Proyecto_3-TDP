package Niveles;

import java.util.Random;

import entidades.*;
import infectado.InfectadoAlfa;
import infectado.InfectadoBeta;
import juego.Vector;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Almacena un coleccion de collecciones de infectados
 * @author Tomás
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








