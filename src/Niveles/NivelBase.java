package Niveles;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import entidades.Infectado;
import infectado.InfectadoAlfa;
import infectado.InfectadoBeta;
import juego.Vector;

public abstract class NivelBase implements Nivel{
	//Attributes
		protected Queue<Infectado[]> oleadas;
		protected int cantInfectados;
		protected Infectado[] oleadaActual;
		protected int numOleadaActual;


	//Methods
		@Override
		public Infectado[] getOleada() {
			// TODO Auto-generated method stub
			oleadaActual=oleadas.remove();
			cantInfectados=oleadaActual.length;
			numOleadaActual++;
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
			
			y = r.nextInt(30) * -30;
			
			x = r.nextInt(16) * 30;//16*30=500 == ancho del frame
			
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
