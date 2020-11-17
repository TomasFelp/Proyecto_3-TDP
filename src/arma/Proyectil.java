package arma;

import javax.swing.JLabel;

import colisiones.ZonaColision;
import entidades.NPC;
import juego.ImageProvider;
import juego.Vector;

public abstract class Proyectil extends NPC {
    private static final int radioColision = 1;

    protected int daño;
    protected ZonaColision zonaColision;
    protected Vector posicion;
    protected Vector velocidad;

    public Proyectil(Vector posicion, Vector velocidad, int daño) {
    	super(posicion);
        this.daño = daño;
        this.posicion = posicion;
        this.velocidad = velocidad;
        this.setIcon(ImageProvider.getInstancia().getSpriteProyectil());
        zonaColision = new ZonaColision(posicion, radioColision);
    }

    public void update() {
        posicion.add(velocidad);
        this.setLocation(posicion);
    }

    public int getDaño() {
        return daño;
    }

    public Vector getPosicion() {
        return posicion;
    }

    public void destruir() {
    }
    
	@Override
	public boolean itsAlive() {
		// TODO Auto-generated method stub
		return false;
	}
}
