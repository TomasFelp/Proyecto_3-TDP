package Niveles;


import java.util.Queue;
import java.util.Random;

import entidades.Infectado;
import infectado.InfectadoFactory;
import juego.Vector;

/**
 * Factoriza comportamiento comun a los niveles concretos
 *
 */
public abstract class NivelBase implements Nivel{
	//Attributes
		protected Queue<Infectado[]> oleadas;
		protected int cantInfectados;
		protected Infectado[] oleadaActual;
		protected int numOleadaActual;
		protected InfectadoFactory fabricaInfectados;


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

		protected Infectado[] armarOleada(int cant) {

			int pos=0;
			Vector vectorPosicion;
			Infectado[] inf=new Infectado[cant];
			
			while(cant!=0) {
				
				vectorPosicion=generarPosicion();
			

				inf[pos]=fabricaInfectados.crearInfectado(vectorPosicion);
				pos++;
				cant--;
			}
			
			return inf;
		}
		
		
		/**
		 * Genera un vector representando una posicion aleatoria, dentro de los limites del juego.
		 * @return
		 */
		protected Vector generarPosicion() {
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
		public void relentizarOleada(int tiempo) {
			// TODO Auto-generated method stub
			for(int i=0;i<oleadaActual.length;i++) {
				oleadaActual[i].ralentizar(tiempo);
			}
		}
}
