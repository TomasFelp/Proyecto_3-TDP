package entidades;

import javax.swing.ImageIcon;

public class Player extends Personaje{
	private final int saludMax = 100;
	private final int saludMin = 0;

	public Player(ImageIcon sprite){
		saludActual=100;
		velocidad=10;
		grafico=new EntidadGrafica(sprite);
		this.setIcon(grafico.getGrafico());
	}
}
