package Premios;

import entidades.Infectado;
import entidades.Jugador;

/**
 * 
 * Premio que congela infectados de la oleada actual.
 *
 */
public class Cuarentena extends Premio{

	public Cuarentena() {
		// TODO Auto-generated constructor stub
		super();
		this.setIcon(GUI.ImageProvider.getInstancia().getSpritePremioCuarentena());
	}
	
	@Override
	public Premio clone() {
		// TODO Auto-generated method stub
		return new Cuarentena();
	}

	public void chocarConJugador(Jugador jugador) {
		mediadorJuego.relentizarInfectados(4);
		mediadorJuego.removeEntidad(this);
	}

	public void chocarConInfectado(Infectado infectado) {
		//hacer nada
	}
}
