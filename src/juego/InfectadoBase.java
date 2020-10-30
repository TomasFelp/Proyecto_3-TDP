package juego;

import javax.swing.JFrame;

public class InfectadoBase extends Personaje{
//Attributes
	
//Builder
	public InfectadoBase(){
		saludActual=100;
		velocidad=5;
		grafico=new EntidadGrafica("/ImagenesPlayer/player.png");
		this.setIcon(grafico.getGrafico());
	}
//Methods
}
