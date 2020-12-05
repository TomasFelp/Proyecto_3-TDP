package Niveles;

import java.util.LinkedList;

import entidades.Infectado;

public class Nivel2 extends Nivel1{

//Builder
	public Nivel2() {
		oleadas=new LinkedList<Infectado[]>();
		oleadas.add(armarOleada(20,15));
		oleadas.add(armarOleada(50,20));
	}
	
//Methods
	public String getNombre() {
		// TODO Auto-generated method stub
		return "Nivel 2 - oleada "+numOleadaActual;
	}
}
