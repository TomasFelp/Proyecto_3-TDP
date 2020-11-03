package entidades;

import javax.swing.JFrame;
import java.util.Random;

public class InfectadoBase extends Personaje{
//Attributes
	private int posX,posY;
//Builder
	public InfectadoBase(){
		saludActual=100;
		velocidad=2;
		grafico=new EntidadGrafica("/ImagenesPlayer/player.png");
		this.setIcon(grafico.getGrafico());
		
		Random rnd=new Random();
		
		posY=rnd.nextInt(15)*-20;//<--------------------Para que no esten todos en la misma fila
		posX=rnd.nextInt(25)*20;//<---------------------Ajustar valores para que no se salga de la pantalla (20 porque es el tamaño de lavel provisorio que defini en el mapeo)
	}
//Methods
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
}