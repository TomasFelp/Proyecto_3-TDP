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

	/**
	 * Actualiza la cargaViral del Personaje con el dano pasado por parametro
	 * @param dano dano recibido
	 */
	public abstract void recibirDano(int dano);

	public int getCargaViral() {
		return cargaViral;
	}

	public void restaurarVida() {
		this.cargaViral = maxVida;
	}

	public Vector getVelocidad() {
		return new Vector(velocidad.x, velocidad.y);
	}
}
