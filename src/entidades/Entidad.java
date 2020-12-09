package entidades;

import java.awt.*;
import java.util.Random;

import javax.swing.JLabel;

import juego.Mediator;
import juego.Vector;

public abstract class Entidad extends JLabel implements Colisionable {
	protected Mediator mediadorJuego;
	protected float xReal;
	protected float yReal;
	private int ID;

	public Entidad() {
		Random rnd = new Random();
		ID = rnd.nextInt();
	}

	public Entidad(Vector posicion) {
		this();
		this.setLocation(posicion);
		this.setPosicionReal(posicion.x, posicion.y);
	}

	/**
	 * Se llama en cada secuencia de actualizacion del GameController
	 * 
	 * @param deltaTime tiempo en nanosegundos, entre un ciclo y otro
	 */
	public abstract void update(float deltaTime);

	@Override
	public int hashCode() {
		return ID;
	}
	
	/**
	 * Le asigna un mediador a la entidad, el cual sera el encargado de comunicar las interacciones entre la entidad y el resto del juego.
	 * @param m mediador a asignar.
	 */
	public void setMediador(Mediator m) {
		mediadorJuego = m;
	}

	/**
	 * Actualiza la posicion de la entidad sumandole las cordenadas recibidas por parametro.
	 * @param vx valor a sumar en el eje X.
	 * @param vy valor a sumar en el eje Y.
	 */
	public void mover(float vx, float vy) {
		// Cuando movemos las entidades, necesitamos convertir la posición de estas a
		// enteros.
		// Esto hace que se pierda precisión, y puede hacer que elementos no se muevan.

		// Para evitarlo, guardo una referencia a la posición en float, que se usa
		// siempre como referencia.

		xReal += vx;
		yReal += vy;

		this.setLocation((int) (xReal), (int) (yReal));
	}
	
	/**
	 * Actualiza las cordenadas de la posicion de la entidad, sin desplazarla.
	 * @param x cordenada en el eje X.
	 * @param y cordenada en el eje Y.
	 */
	public void setPosicionReal(float x, float y) {
		xReal = x;
		yReal = y;
	}

	public Vector getVectorPosicion(){
		Point pos = this.getLocation();
		int x = (int) pos.getX();
		int y = (int) pos.getY();
		return new Vector(x, y);
	}

}
