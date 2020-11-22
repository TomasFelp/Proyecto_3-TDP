package juego;

import java.util.LinkedList;

import entidades.Infectado;

public class Nivel2 extends Nivel1{

//Builder
	public Nivel2() {
		oleadas=new LinkedList<Infectado[]>();
		oleadas.add(armarOleada(10,10));
		oleadas.add(armarOleada(15,10));
	}
}
