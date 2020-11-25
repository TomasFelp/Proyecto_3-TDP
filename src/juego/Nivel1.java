package juego;

import java.util.Random;

import entidades.*;
import infectado.InfectadoAlfa;
import infectado.InfectadoBeta;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Almacena un coleccion de collecciones de infectados
 * @author Tomás
 *
 */
public class Nivel1 implements Nivel{

//Attributes
	protected Queue<Infectado[]> oleadas;
	protected int cantInfectados;
	protected Infectado[] oleadaActual;

//Builder
	public Nivel1() {
		oleadas=new LinkedList<Infectado[]>();
		oleadas.add(armarOleada(10,5));
		oleadas.add(armarOleada(12,15));
	}

//Methods
	@Override
	public Infectado[] getOleada() {
		// TODO Auto-generated method stub
		oleadaActual=oleadas.remove();
		cantInfectados=oleadaActual.length;
		return oleadaActual;
	}

	@Override
	public boolean termino() {
		// TODO Auto-generated method stub
		return oleadas.isEmpty();
	}
	
	/**
	 * Retorna un arreglo de infectados.
	 * @param alfas cantidad de infectados alfa en el arreglo.
	 * @param betas cantidad de infectados beta en arreglo.
	 * @return arreglo de infectados-
	 */
	protected Infectado[] armarOleada(int alfas,int betas) {
		int pos=0;
		Vector vectorPosicion;
		Infectado[] inf=new Infectado[alfas+betas];
		
		while(alfas!=0) {
			
			vectorPosicion=generarPosicionaleatoria();
		
			inf[pos]=new InfectadoAlfa(vectorPosicion);
			pos++;
			alfas--;
		}
		
		while(betas!=0) {
			
			vectorPosicion=generarPosicionaleatoria();
		
			inf[pos]=new InfectadoBeta(vectorPosicion);
			pos++;
			betas--;
		}
		
		return inf;
	}
	
	private Vector generarPosicionaleatoria() {
		Random r = new Random();
		int x,y;
		
		y = r.nextInt(30) * -20;
		//Ajustar valores para que no se salga de la pantalla
		x = r.nextInt(24) * 20;
		
		return new Vector(x, y);
	}

	@Override
	public boolean quedanInfectadosEnLaOleada() {
		// TODO Auto-generated method stub
		return cantInfectados>0;
	}

	@Override
	public void decrementarOleada() {
		// TODO Auto-generated method stub
		cantInfectados--;
	}

	@Override
	public void relentizarOleada() {
		// TODO Auto-generated method stub
		for(int i=0;i<oleadaActual.length;i++) {
			oleadaActual[i].ralentizar();
		}
	}
}








