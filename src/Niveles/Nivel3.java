package Niveles;

import java.util.LinkedList;

import entidades.Infectado;
import infectado.InfectadoAlfaFactory;
import infectado.InfectadoBetaFactoryCant;
import juego.Vector;

/**
 * Nivel concreto de digicultad media, los infectados se encuentran esparcidos siguiendo un patron especifico, contiene 2 oleadas.
 *
 */
public class Nivel3 extends NivelBase{

	protected int posX,posY;
	
	public Nivel3() {
		posX=5;
		posY=-30;
		oleadas=new LinkedList<Infectado[]>();
		
		fabricaInfectados=new InfectadoAlfaFactory();
		oleadas.add(armarOleada(200));
		fabricaInfectados=new InfectadoBetaFactoryCant(50);
		oleadas.add(armarOleada(200));
	}
	

	protected Vector generarPosicion() {

		Vector pos=new Vector(posX,posY);
		
		if(posX+50<500) {
			posX+=50;
		}else {
			posX=5;
			posY-=20;
		}
		
		return pos;
	}
	
	
	
	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return "Nivel 3 - oleada: "+numOleadaActual;
	}
}
