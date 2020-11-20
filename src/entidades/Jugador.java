package entidades;

import java.awt.Color;
import java.awt.Point;
import java.util.*;

import arma.Arma;
import arma.ArmaFactory;
import arma.Proyectil;
import juego.Vector;

public class Jugador extends Personaje {
	// Obtengo los segundos en nanosegundos
	protected static final long SEGUNDOS_INVENCIBLE = 2 * 1000000000;
	private Timer timerInvencible;
	private boolean invencible;
	private long segundosInvencible;
	private Arma arma;
	private int velocidad;

	public Jugador() {
		super();
		// tamaño genericos solo para prueba.
		setSize(20, 20);
		setVisible(true);

		timerInvencible = new Timer();
		this.velocidad = 10;
		this.setIcon(juego.ImageProvider.getInstancia().getSpritePlayer());
		this.arma = ArmaFactory.getDefaultArma();
		invencible = false;
		this.setBackground(Color.BLUE);
	}

	public void accionar() {

	}

	public void setArma(Arma a) {
		this.arma = a;
	}

	public Proyectil disparar() {

		Point pos = this.getLocation();
		int x, y;
		x = (int) pos.getX();
		y = (int) pos.getY();
		Vector posicion = new Vector(x, y);

		return arma.disparar(posicion);
	}

	@Override
	public void update() {
		if (invencible && segundosInvencible <= System.nanoTime())
			deshacerInvencible();
	}

	public double getVelocidadY() {
		return velocidad;
	}

	@Override
	public void enColision(List<Entidad> colisiones) {
		for (Entidad a : colisiones) {
			if (!invencible)
				manageColisionInfectado(a);
		}
	}

	private void manageColisionInfectado(Entidad entidad) {
		Infectado infectado;

		try {
			infectado = (Infectado) entidad;
			cargaViral--;

			if (cargaViral <= 0)
				this.setOpaque(true);

			hacerInvencible(SEGUNDOS_INVENCIBLE);
		} catch (ClassCastException e) {

		}
	}

	private void hacerInvencible(long nanoSegundos) {
		System.out.println("Player es invencible");
		invencible = true;
		segundosInvencible = System.nanoTime() + nanoSegundos;
		this.setOpaque(true);
	}

	private void deshacerInvencible() {
		System.out.println("Player no es invencible");
		invencible = false;
		segundosInvencible = 0;
		this.setOpaque(false);
	}
}
