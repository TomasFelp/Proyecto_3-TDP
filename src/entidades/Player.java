package entidades;

import javax.swing.ImageIcon;

import proyectil.Proyectil_sanitario;

public class Player extends Personaje{
	private final int saludMax = 100;
	private final int saludMin = 0;

    private Proyectil_sanitario proyectil;
    public Player(ImageIcon sprite){
		saludActual=100;
		velocidad=10;
		grafico=new EntidadGrafica(sprite);
		this.setIcon(grafico.getGrafico());
	}

    public void setProyectil(Proyectil_sanitario p) {
        proyectil = p;
    }
}
