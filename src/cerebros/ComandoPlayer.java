package cerebros;

import java.awt.Point;
import entidades.*;
import juego.Juego;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import arma.Proyectil;

/**
 * Hilo que controla las acciones del jugador
 *
 */
public class ComandoPlayer extends Thread implements KeyListener{
	/*
	* Si no limitamos el tiempo entre disparos, la GUI (AWT) lanza una excepción.
	* Para evitarlo, seteamos un tiempo mímimo entre disparos.
	*/
	private static final int TIEMPO_MIN_ENTRE_DISPAROS_EN_MILLIS = 250;

	protected Jugador jugador;
	protected boolean ejecucion=true;
	protected int anchoPantalla;
	protected Juego juego;

	private long tiempoUltimoDisparo = 0;
	
	public ComandoPlayer(Jugador p, int anchoPantalla) {
		jugador =p;
		this.anchoPantalla=anchoPantalla;
	}

	public Jugador getJugador() {
		return jugador;
	}
	
	public void setJuego(Juego j) {
		juego=j;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	/**
	 * Controla la direccion en la que se mueve el personaje.
	 */
	public void keyPressed(KeyEvent e) {
		int teclaPresionada=e.getKeyCode();
		Point posicion=this.jugador.getLocation();

		if(teclaPresionada==KeyEvent.VK_A || teclaPresionada==KeyEvent.VK_LEFT) {
			if(posicion.x>0)
				posicion.setLocation(posicion.x- jugador.getVelocidadY(),posicion.y);
		}

		if(teclaPresionada==KeyEvent.VK_D || teclaPresionada==KeyEvent.VK_RIGHT) {
			if(posicion.x<anchoPantalla)
				posicion.setLocation(posicion.x+ jugador.getVelocidadY(),posicion.y);
		}

	  if(teclaPresionada == KeyEvent.VK_W || teclaPresionada==KeyEvent.VK_UP) {
	  	//Solo se ejecutará el disparo si ha pasado el tiempo minimo en milisegundos desde el ultimo disparo.
		  if(System.currentTimeMillis() - tiempoUltimoDisparo > TIEMPO_MIN_ENTRE_DISPAROS_EN_MILLIS) {

			  Proyectil proyectil = this.jugador.disparar();
			  proyectil.setMediador(juego);
			  juego.addEntidad(proyectil);

			  tiempoUltimoDisparo = System.currentTimeMillis();
		  }
	  }

		jugador.setLocation(posicion);
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void setJugador(Jugador p) {
		jugador =p;
	}

}
















