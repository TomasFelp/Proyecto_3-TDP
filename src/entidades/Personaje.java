package entidades;

import juego.Vector;

public abstract class Personaje extends Entidad {

	protected static int maxVida;
	protected int cargaViral;
	protected Vector velocidad;
	protected int velocidadDefault;

	public Personaje(int cargaViral, Vector velocidad) {
		this.cargaViral = cargaViral;
		this.velocidad = velocidad;
		velocidadDefault=(int) velocidad.getY();
	}

	public Personaje(Vector posicion) {
		super(posicion);
	}

	public Personaje() {

	}

	public int getCargaViral() {
		return cargaViral;
	}

	public void restaurarVida() {
		this.cargaViral = maxVida;
	}
	
	public void setDamage(int d) {
		this.cargaViral -= d;
	}

	public Vector getVelocidad() {
		return new Vector(velocidad.x, velocidad.y);
	}
}
