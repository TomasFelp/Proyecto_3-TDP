package cerebros;

import java.awt.Point;
import entidades.*;
import juego.Juego;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ComandoPlayer extends Thread implements KeyListener{
	protected Jugador jugador;
	protected boolean ejecucion=true;
	protected int recorrido;
	protected GameController npcController;
	protected Juego juego;
	
	public ComandoPlayer(Jugador p, int r) {
		jugador =p;
		recorrido=r;
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
			if(posicion.x<recorrido)
				posicion.setLocation(posicion.x+ jugador.getVelocidadY(),posicion.y);
		}

	  if(teclaPresionada == KeyEvent.VK_W || teclaPresionada==KeyEvent.VK_UP) {
		  juego.addEntidad(this.jugador.disparar());
		  
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
















