package entidades;

import java.awt.Point;
import java.util.Random;

import Premios.Premio;
import arma.Proyectil;
import arma.ProyectilViral;
import arma.Proyectil_sanitario;
import juego.Vector;

/**
 * 
 * Clase base infectado, factoriza el comportamiento comun a todos los infectados.
 *
 */
public abstract class Infectado extends Personaje implements Colisionador {

//Attributes
	protected static final long SEGUNDOS_RALENTIZADO = 1000000000;
	protected static final long SEGUNDOS_INOFENSIVO= 2 * 1000000000;
	protected boolean ralentizado;
	protected boolean inofensivo;
	protected long tiempoRelentizado;
	protected long tiempoInofensivo;
	
//Builder
	public Infectado(Vector posicion) {
		super(posicion);
		cargaViral = 100;
		this.setSize(30, 30);
	}



//Methods
	/**
	 * Dispara un proyectil viral.
	 */
	private void dispararProyectilViral() {

		//Tomamos la posicion actual del infectado para efectuar el disparo
		Vector posicion = this.getVectorPosicion();

		//Efectuamos el disparo
		Proyectil p = new ProyectilViral(posicion);
		p.setMediador(mediadorJuego);
		
		mediadorJuego.addColisionador(p);
	}

	@Override
	public void update(float deltaTime) {
		Point location = this.getLocation();
		Random r = new Random();

		/*Chequea si el infectado ya cumplió el tiempo de alguna penalización
		* (ralentización o inofensividad)*/
		if (ralentizado && tiempoRelentizado <= System.nanoTime()) {
			desRalentizar();
		}
		
		if (inofensivo && tiempoInofensivo <= System.nanoTime()) {
			inofensivo=false;
			tiempoInofensivo=0;
		}

		mover(velocidad.x * deltaTime, (velocidad.y * deltaTime) / 3);

		if (location.y > 600) {//Si pasa el limite de la pantalla vuelve a aparecer arriba
			this.setLocation(this.getLocation().x, 0);
			this.setPosicionReal(xReal, -this.getHeight());
		}

		if (r.nextInt(2500) == 0 && ralentizado==false) {
			dispararProyectilViral();
		}

	}

	
	/**
	 * Realiza las acciones correspondienes a la muerte de un infectado.
	 */
	protected void declararRecuperado() {
		Random r =new Random();
		boolean tocaLanzarPremio = (r.nextInt(5) == 0);

		mediadorJuego.removeEntidad(this);
		mediadorJuego.decrementarInfectados();

		if(tocaLanzarPremio)
			lanzarPremio();
	}
	
	/**
	 * Deja caer un premio desde la posicion actual del infectado.
	 */
	protected void lanzarPremio() {

		Vector posicion = this.getVectorPosicion();
		Premio premio=juego.Generador_de_premios.getInstancia().getPremio();

		premio.setPosicion(posicion);
		premio.setMediador(mediadorJuego);

		mediadorJuego.addColisionador(premio);
	}
	
	/**
	 * Congela el movimiento del infectado durante el tiempo determinado por el parametro.
	 */
	public void ralentizar(int tiempo) {
		velocidad.y=0;
		ralentizado=true;
		
		tiempoRelentizado=System.nanoTime() + tiempo * SEGUNDOS_RALENTIZADO;
	}
	
	/**
	 * Descongela el movimento del infectado.
	 */
	public void desRalentizar() {
		ralentizado=false;
		velocidad.y=velocidadDefault;
	}
	
	/**
	 * Cambia el estado del infectado a inofensivo, en este estado el infectado no causara daño alguno al jugador.
	 * @param nanoSegundos
	 */
	protected void hacerInofensivo(long nanoSegundos) {
		inofensivo=true;
		tiempoInofensivo= System.nanoTime() + nanoSegundos;
	}
	
}







