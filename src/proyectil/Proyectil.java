package proyectil;

import GUI.Vector2;

public abstract class Proyectil {
    protected int daño;
    protected Vector2 posicion;
    protected Vector2 velocidad;

    public Proyectil(Vector2 posicion, Vector2 velocidad, int daño) {
        this.daño = daño;
        this.posicion = posicion;
        this.velocidad = velocidad;
    }

    public void update() {
        posicion.add(velocidad);
    }

    public int getDaño() {
        return daño;
    }
}
