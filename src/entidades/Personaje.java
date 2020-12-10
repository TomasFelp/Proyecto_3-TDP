package entidades;

import juego.Vector;

/**
 * 
 * Factoriza comportamiento comun a todo tipo de enticad que tenga una carga viral y desplazamiento.
 *
 */
public abstract class Personaje extends Entidad {
	protected int cargaViral;
	protected int velocidadDefault;


	public Personaje(Vector posicion) {
		super(posicion);
	}

	public Personaje() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Actualiza la cargaViral del Personaje con el dano pasado por parametro
	 * @param dano dano recibido
	 */
	public abstract void recibirDano(int dano);

	/**
	 * Consulta la carga viral actual.
	 * @return carga viral del personaje.
	 */
	public int getCargaViral() {
		return cargaViral;
	}
}
