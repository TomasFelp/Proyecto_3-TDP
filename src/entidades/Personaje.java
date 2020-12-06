package entidades;

import juego.Vector;

public abstract class Personaje extends Entidad {

	
	protected int cargaViral;
	protected Vector velocidad;
	protected int velocidadDefault;


	public Personaje(Vector posicion) {
		super(posicion);
	}

	public Personaje() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Actualiza la cargaViral del Personaje con el daño pasado por parametro
	 * @param dano dano recibido
	 */
	public abstract void recibirDano(int dano);

	public int getCargaViral() {
		return cargaViral;
	}

	public Vector getVelocidad() {
		return new Vector(velocidad.x, velocidad.y);
	}
}
