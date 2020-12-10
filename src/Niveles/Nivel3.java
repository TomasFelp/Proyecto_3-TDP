package Niveles;

import java.util.LinkedList;

import entidades.Infectado;
import infectado.InfectadoAlfa;
import infectado.InfectadoBeta;
import juego.Vector;

/**
 * Nivel concreto de digicultad media, los infectados se encuentran esparcidos siguiendo un patron especifico, contiene 2 oleadas.
 *
 */
public class Nivel3 extends NivelBase{

	
	public Nivel3() {
		oleadas=new LinkedList<Infectado[]>();
		oleadas.add(armarOleada(200,0));
		oleadas.add(armarOleada(58,75));
	}
	
	/**
	 * Arma una oleada asignando a los infectados posiciones especificas.
	 */
	protected Infectado[] armarOleada(int alfas, int betas) {
		int betasTotales=betas;
		int pos=0;
		int x=5,y=-100;
		Vector vectorPosicion;
		Infectado[] inf=new Infectado[alfas+betas];
		
		while(alfas!=0) {
			
			vectorPosicion=new Vector(x, y);
		
			if(x+60<500) {
				x+=50;	
			}else{
				x=5;
				y-=20;
			}
			
			inf[pos]=new InfectadoAlfa(vectorPosicion);
			pos++;
			alfas--;
		}
		x=5;
		y=20;
		while(betas!=betasTotales/3) {
			
			vectorPosicion=new Vector(x, y);
		

			if(x+60<500) {
				x+=50;	
			}else{
				x=0;
				y-=20;
			}
			
			inf[pos]=new InfectadoBeta(vectorPosicion);
			pos++;
			betas--;
		}
		x=0;
		y=-40;
		while(betas!=0) {
			
			vectorPosicion=new Vector(x, y);
		
			if(x<460) {
				x+=20;	
			}else{
				x=0;
				y-=20;
			}
			
			inf[pos]=new InfectadoBeta(vectorPosicion);
			pos++;
			betas--;
		}
		
		return inf;
	}
	
	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return "Nivel 3 - oleada: "+numOleadaActual;
	}
}
