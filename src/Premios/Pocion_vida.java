package Premios;

import entidades.Colisionador;
import entidades.Infectado;
import entidades.Jugador;

/**
 * 
 * Premio que restaura la vida del jugador.
 */
public class Pocion_vida extends Premio{

	public Pocion_vida() {
		// TODO Auto-generated constructor stub
		super();
		this.setIcon(GUI.ImageProvider.getInstancia().getSpritePremioPocionVida());
	}
	
	@Override
	public Premio clone() {
		// TODO Auto-generated method stub
		return new Pocion_vida();
	}

	@Override
	public void chocarConJugador(Jugador jugador) {
		jugador.restaurarVida();
		mediadorJuego.removeEntidad(this);
	}

	@Override
	public void chocarConInfectado(Infectado infectado) {
		//hacer
	}

	@Override
	public void aceptarColision(Colisionador colisionador) {
		//No hacer nada
	}
}
