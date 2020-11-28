package Premios;

import entidades.Infectado;
import entidades.Jugador;

public class Pocion_vida extends Premio{

	public Pocion_vida() {
		// TODO Auto-generated constructor stub
		super();
		this.setIcon(juego.ImageProvider.getInstancia().getSpritePremioPocionVida());
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
}
