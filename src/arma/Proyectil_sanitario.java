package arma;

import java.awt.Color;
import java.util.List;

import GUI.ImageProvider;
import entidades.*;
import juego.Vector;

/**
 * 
 * Proyectil que solo daña a los infectados, causa daño moderado.
 *
 */
public class Proyectil_sanitario extends Proyectil {

	public Proyectil_sanitario(Vector posicion) {
		super(posicion);
		this.setIcon(ImageProvider.getInstancia().getSpriteProyectilSanitario());
		daño=25;
		velocidad.y=-10;
	}

	@Override
	public void aceptarColision(Colisionador colisionador) {
		//No hacer nada
	}

	@Override
	public void chocarConJugador(Jugador jugador) {
		//No hacer nada
	}

	@Override
	public void chocarConInfectado(Infectado infectado) {

		infectado.recibirDano(daño);
		
		mediadorJuego.removeEntidad(this);
	}
}
