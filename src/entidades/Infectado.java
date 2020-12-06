package entidades;

import java.awt.Point;
import java.util.Random;

import Premios.Premio;
import arma.Proyectil;
import arma.ProyectilViral;
import arma.Proyectil_sanitario;
import juego.Vector;

public abstract class Infectado extends Personaje implements Colisionador, Colisionable {

//Attributes
	protected static final long SEGUNDOS_RALENTIZADO = 1000000000;
	protected static final long SEGUNDOS_INOFENSIVO= 2 * 1000000000;
	protected boolean relentizado;
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
	public void PropagarVirus() {
		
		Point pos = this.getLocation();
		int x, y;
		x = (int) pos.getX();
		y = (int) pos.getY();
		Vector posicion = new Vector(x, y);
		
		Proyectil p = new ProyectilViral(posicion);
		p.setMediador(mediadorJuego);
		
		mediadorJuego.addColisionador(p);
	}

	@Override
	public void update(float deltaTime) {
		Point location = this.getLocation();
		Random r = new Random();

		if (relentizado && tiempoRelentizado <= System.nanoTime()) {
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

		if (r.nextInt(2500) == 0 && relentizado==false) {
			PropagarVirus();
		}

	}

	
	/**
	 * Determina si el infectado esta vivo, si no es asi le informa al juego que hacer.
	 */
	protected void declararRecuperado() {
		Random r =new Random();

		mediadorJuego.removeEntidad(this);
		mediadorJuego.decrementarInfectados();

		if(r.nextInt(5)==0)
			lanzarPremio();
	}
	
	protected void lanzarPremio() {
		int x=this.getX();
		int y=this.getY();

		Vector posicion=new Vector(x, y);
		Premio premio=juego.Generador_de_premios.getInstancia().getPremio();

		premio.setPosicion(posicion);
		premio.setMediador(mediadorJuego);

		mediadorJuego.addColisionador(premio);
	}
	
	public void ralentizar() {
		velocidad.y=0;
		relentizado=true;
		
		tiempoRelentizado=System.nanoTime() + 4 * SEGUNDOS_RALENTIZADO;
	}
	
	public void desRalentizar() {
		relentizado=false;
		velocidad.y=velocidadDefault;
	}
	
	/**
	 * Setea el estado del infectado en inofensivo para que este no pueda causarle daño al player.
	 * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Esta echo con el fin de remplazar el hacer invencible del player ya que ahora lo colision se esta viendo desde el lado del infectado>>>>>>>>>>>>>>>>>>>>>>>
	 * 
	 * @param nanoSegundos
	 */
	protected void hacerInofensivo(long nanoSegundos) {
		inofensivo=true;
		tiempoInofensivo= System.nanoTime() + nanoSegundos;
	}
	
}







