package entidades;

import arma.Arma;
import arma.ArmaFactory;
import arma.Proyectil;
import juego.Vector;

/**
 * 
 * Modela el protagonista del juego.
 *
 */
public class Jugador extends Personaje implements Colisionable{
	// Obtengo los segundos en nanosegundos
	protected static final long SEGUNDOS_INVENCIBLE = 2 * 1000000000;
	protected static final long SEGUNDOS_PREMIO = 1000000000;
	
	protected static int maxVida=500;
	
	
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
		this.arma = ArmaFactory.getArmaFactory().getArmaDefault();
		invencible = false;
		
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
		}
	}
	
	/**
	 * Setea un arma al jugador.
	 * @param a nueva arma del jugador.
	 */
	public void setArma(Arma a) {
		this.arma = a;
	}
	
	/**
	 * Cambia el estado del jugador indicando que esta en posesion de un premio temporal.
	 * @param seg tiempo de duracion del premio.
	 */
	public void premioTemporal(int seg) {
		premioActivado=true;
		segundosPremio=System.nanoTime() + SEGUNDOS_PREMIO * seg;
	}
	
	/**
	 * Dispara un proyectil del tipo correspondeinte al arma que tenga asignada.
	 * @return
	 */
	public Proyectil disparar() {

		//Tomamos la posicion del jugador para efectuar el disparo
		Vector posicion = this.getVectorPosicion();

		return arma.disparar(posicion);
	}

	@Override
	public void update(float deltaTime) {
		
		if (premioActivado && segundosPremio <= System.nanoTime())
			quitarPremio();
	}
	
	/**
	 * Quita todos los premios temporales que pueda poseer el jugador y cambia su estado indicando que no posee ningun premio.
	 */
	private void quitarPremio() {
		arma=ArmaFactory.getArmaFactory().getArmaDefault();
		premioActivado=false;
	}

	/**
	 * devuelve la velocidad de desplazamiento.
	 * @return velocidad de desplazamieno.
	 */
	public double getVelocidadY() {
		return velocidad;
	}


	public void aceptarColision(Colisionador colisionador) {
		colisionador.chocarConJugador(this);
	}
	
	public void restaurarVida() {
		cargaViral=maxVida;
	}
}
