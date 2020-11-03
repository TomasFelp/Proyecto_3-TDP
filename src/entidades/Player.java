package entidades;

import javax.swing.JLabel;

public class Player extends Personaje{

//Attributes
	private final int saludMax = 100;
	private final int saludMin = 0;
	
//Builder
	public Player(){
		saludActual=100;
		velocidad=10;
		grafico=new EntidadGrafica("/ImagenesPlayer/player.png");
		this.setIcon(grafico.getGrafico());
	}
	
//Methods
	
}
