package cerebros;

import java.awt.Point;
import entidades.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import juego.*;

public class ComandoPlayer extends Thread implements KeyListener{
	protected Player player;
	protected boolean ejecucion=true;
	protected int recorrido;
	
	public ComandoPlayer(Player p,int r) {
		player=p;
		recorrido=r;
	}

	public Player getPlayer() {
		return player;
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
		Point posicion=this.player.getLocation();

		if(teclaPresionada==KeyEvent.VK_A || teclaPresionada==KeyEvent.VK_LEFT) {
			if(posicion.x>0)
				posicion.setLocation(posicion.x-player.getVelocidad(),posicion.y);
		}

		if(teclaPresionada==KeyEvent.VK_D || teclaPresionada==KeyEvent.VK_RIGHT) {
			if(posicion.x<recorrido)
				posicion.setLocation(posicion.x+player.getVelocidad(),posicion.y);
		}

	  if(teclaPresionada == KeyEvent.VK_W || teclaPresionada==KeyEvent.VK_UP) {
		  this.player.disparar();
	  }

		player.setLocation(posicion);
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void setPlayer(Player p) {
		player=p;
	}

}
















