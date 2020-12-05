package entidades;

import java.awt.Color;
import java.awt.Point;
import java.util.*;

import arma.Arma;
import arma.ArmaFactory;
import arma.Proyectil;
import juego.Vector;

public class Jugador extends Personaje implements Colisionable{
	// Obtengo los segundos en nanosegundos
	protected static final long SEGUNDOS_INVENCIBLE = 2 * 1000000000;
	protected static final long SEGUNDOS_PREMIO = 1000000000;
	
	private boolean invencible;
	private boolean premioActivado;
	private long segundosInvencible;
	private long segundosPremio;
	private Arma arma;
	private int velocidad;

	public Jugador() {
		super();
		setSize(30, 30);
		setVisible(true);

		
		this.velocidad = 10;
		this.setIcon(GUI.ImageProvider.getInstancia().getSpritePlayer());
		this.arma = ArmaFactory.getDefaultArma();
		invencible = false;
		this.setBackground(Color.BLUE);
		cargaViral=maxVida;
	}


	public void accionar() {

	}

	/**
	 * Decrementa la carga viral del Jugador con el valor pasado por parametro.
	 * Lleva la carga viral a 0 si el valor es mayor a la carga viral actual.
	 * @param dano carga viral a decrementarle al Jugador
	 */
	public void recibirDano(int dano){
		if(!invencible) {
			cargaViral-=dano;
			hacerInvencible(SEGUNDOS_INVENCIBLE);
		}
	}

	public void setArma(Arma a) {
		this.arma = a;
	}
	
	public void premioTemporal(int seg) {
		premioActivado=true;
		segundosPremio=System.nanoTime() + SEGUNDOS_PREMIO * seg;
		this.setOpaque(true);
		this.setBackground(Color.YELLOW);
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
	public void update(float deltaTime) {
		if (invencible && segundosInvencible <= System.nanoTime())
			deshacerInvencible();
		
		if (premioActivado && segundosPremio <= System.nanoTime())
			quitarPremio();
	}
	
	private void quitarPremio() {
		System.out.println("quitar premio");
		arma=ArmaFactory.getDefaultArma();
		premioActivado=false;
		this.setOpaque(false);
	}

	public double getVelocidadY() {
		return velocidad;
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

	public void aceptarColision(Colisionador colisionador) {
		colisionador.chocarConJugador(this);
	}
}
