package proyectil;

import javax.swing.JLabel;

import GUI.ImageProvider;
import GUI.Vector2;

public abstract class Proyectil extends JLabel{
    protected int daño;
    protected Vector2 posicion;
    protected Vector2 velocidad;

    public Proyectil(Vector2 posicion, Vector2 velocidad, int daño) {
        this.daño = daño;
        this.posicion = posicion;
        this.velocidad = velocidad;
        this.setIcon(ImageProvider.getInstancia().getSpriteProyectil());
    }

    public void update() {
        posicion.add(velocidad);
        this.setLocation(posicion);
    }

    public int getDaño() {
        return daño;
    }

    public Vector2 getPosicion(){
        return posicion;
    }
}
