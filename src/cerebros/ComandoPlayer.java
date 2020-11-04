package cerebros;

import java.awt.Point;
import entidades.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import juego.*;

public class ComandoPlayer extends Thread implements KeyListener{
	protected Player player;
	protected JFrameJuego jfJuego;
	protected boolean ejecucion=true;

	public ComandoPlayer(Player p,JFrameJuego j) {
		player=p;
		jfJuego=j;
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

	if(teclaPresionada==KeyEvent.VK_A) {
		if(posicion.x>0)
			posicion.setLocation(posicion.x-player.getVelocidad(),posicion.y);
	}

	if(teclaPresionada==KeyEvent.VK_D) {
		if(posicion.x<jfJuego.getAncho()-30)
			posicion.setLocation(posicion.x+player.getVelocidad(),posicion.y);
	}

  if(teclaPresionada == KeyEvent.VK_W) {
      this.player.disparar();
  }

	player.setLocation(posicion);
	jfJuego.repaint();
}


@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

public void setPlayer(Player p) {
	player=p;
}

public void setJFrameJuego(JFrameJuego j) {
	jfJuego=j;
}


}
















