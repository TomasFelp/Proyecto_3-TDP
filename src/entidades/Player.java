package entidades;

import javax.swing.ImageIcon;

import arma.Arma;
import arma.ArmaFactory;

public class Player extends Personaje {
    private Arma arma;
    private final int saludMax = 100;
    private final int saludMin = 0;

    public Player(ImageIcon sprite) {
        saludActual = 100;
        velocidad = 10;
        grafico = new EntidadGrafica(sprite);
        this.setIcon(grafico.getGrafico());
        this.arma = ArmaFactory.getDefaultArma();
    }

    public void setArma(Arma a) {
        this.arma = a;
    }
    public void disparar(){
        arma.disparar(this.getLocation());
    }
}
