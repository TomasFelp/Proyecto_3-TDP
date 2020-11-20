package arma;

import java.awt.Color;

import javax.swing.JLabel;

import colisiones.ZonaColision;
import entidades.Entidad;
import juego.ImageProvider;
import juego.Vector;

public abstract class Proyectil extends Entidad {
    private static final int radioColision = 1;

    protected int daño;
    protected ZonaColision zonaColision;
    protected Vector posicion;
    protected Vector velocidad;

    public Proyectil(Vector posicion, Vector velocidad, int daño) {
        this.daño = daño;
        this.posicion = posicion;
        this.velocidad = velocidad;
        zonaColision = new ZonaColision(posicion, radioColision);
		// Por alguna razon no toma la imagen por eso despues
		this.setIcon(ImageProvider.getInstancia().getSpriteProyectilSanitario());
		
        this.setVisible(true);
    	this.setLocation((int)posicion.getX(),(int)posicion.getY());
		this.setSize(15,15);
    }

    public void update() {
        posicion.add(velocidad);
        this.setLocation(posicion);
        if(posicion.getY()<0 || posicion.getY()>650)
        	mediadorJuego.removeEntidad(this);
    }

    public int getDaño() {
        return daño;
    }

    public Vector getPosicion() {
        return posicion;
    }

    public void destruir() {
    }
}
