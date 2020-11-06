package arma;

import javax.swing.JLabel;

import colisiones.ZonaColision;
import juego.ImageProvider;
import juego.Vector;

public abstract class Proyectil extends JLabel {
    private static final int radioColision = 1;

    protected int daño;
    protected ZonaColision zonaColision;
    protected Vector posicion;
    protected Vector velocidad;

    public Proyectil(Vector posicion, Vector velocidad, int daño) {
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
}
