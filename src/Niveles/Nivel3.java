package Niveles;

import java.util.LinkedList;

import entidades.Infectado;
import infectado.InfectadoAlfa;
import infectado.InfectadoBeta;
import juego.Vector;

public class Nivel3 extends Nivel1{

	
	public Nivel3() {
		oleadas=new LinkedList<Infectado[]>();
		oleadas.add(armarOleada(200,0));
		oleadas.add(armarOleada(58,75));
	}
	
	protected Infectado[] armarOleada(int alfas,int betas) {
		int betasTotales=betas;
		int pos=0;
		int x=0,y=-100;
		Vector vectorPosicion;
		Infectado[] inf=new Infectado[alfas+betas];
		
		while(alfas!=0) {
			
			vectorPosicion=new Vector(x, y);
		
			if(x+40<465) {
				x+=40;	
			}else{
				x=0;
				y-=20;
			}
			
			inf[pos]=new InfectadoAlfa(vectorPosicion);
			pos++;
			alfas--;
		}
		x=20;
		y=20;
		while(betas!=betasTotales/3) {
			
			vectorPosicion=new Vector(x, y);
		

			if(x+40<480) {
				x+=40;	
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
	
	public String getNombre() {
		// TODO Auto-generated method stub
		return "Nivel 3 - oleada: "+numOleadaActual;
	}
}
