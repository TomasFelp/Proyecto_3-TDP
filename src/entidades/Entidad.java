package entidades;

import java.awt.Point;
import java.util.List;
import java.util.Random;

import javax.swing.JLabel;

import cerebros.GameController;
import colisiones.ZonaColision;
import juego.Mediator;
import juego.Vector;

public abstract class Entidad extends JLabel {
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

	}

	/**
	 * Se llama en cada secuencia de actualizacion del GameController
	 * 
	 * @param deltaTime tiempo en nanosegundos, entre un ciclo y otro
	 */
	public abstract void update(float deltaTime);

	/**
	 * Acciona el comportamiento que tiene al colisionar
	 */
	public abstract void accionar();

	@Override
	public int hashCode() {
		return ID;
	}

	public void setMediador(Mediator m) {
		mediadorJuego = m;
	}

	public ZonaColision getZonaColision() {
		int x = this.getX() - this.getWidth() / 2;
		int y = this.getY();
		int height = this.getHeight();
		return new ZonaColision(x, y, height);
	}

	public void mover(float vx, float vy) {
		xReal += vx;
		yReal += vy;

		this.setLocation((int) (xReal), (int) (yReal));
	}

	@Override
	public void setLocation(int x, int y) {
		// Cuando movemos las entidades, necesitamos convertir la posición de estas a
		// enteros.
		// Esto hace que se pierda precisión, y puede hacer que elementos no se muevan.

		// Para evitarlo, guardo una referencia a la posición en float, que se usa
		// siempre como referencia.
		xReal = x;
		yReal = y;
		super.setLocation(x, y);
	}

	public void enColision(List<Entidad> colisiones) {

	}
}
