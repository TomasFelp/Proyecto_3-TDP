package entidades;

import juego.Vector;

public abstract class Personaje extends Entidad{

    protected int cargaViral;
    protected Vector velocidad;

    public Personaje(int cargaViral, Vector velocidad){
        this.cargaViral = cargaViral;
        this.velocidad = velocidad;
    }

    public Personaje(Vector posicion){
        super(posicion);
    }

    public Personaje(){

    }

    public int getCargaViral(){
        return cargaViral;
    }

    protected void setCargaViral(int cargaViral){
        this.cargaViral = cargaViral;
    }

    public Vector getVelocidad() {
        return new Vector(velocidad.x, velocidad.y);
    }
}
