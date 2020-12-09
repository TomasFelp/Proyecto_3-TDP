package Premios;

import arma.ArmaFactory;
import entidades.Infectado;
import entidades.Jugador;

/**
 * 
 * Premio temporal que le asigna un arma perforadora al jugador.
 *
 */
public class Super_arma_perforadora extends Premio{

	public Super_arma_perforadora() {
		// TODO Auto-generated constructor stub
		super();
		this.setIcon(GUI.ImageProvider.getInstancia().getSpritePremioSuperArmaPerforadora());
	}
	
	@Override
	public Premio clone() {
		// TODO Auto-generated method stub
		return new Super_arma_perforadora();
	}

	@Override
	public void chocarConJugador(Jugador jugador) {
		jugador.setArma(ArmaFactory.getArmaFactory().getArmaPerforadora());
		jugador.premioTemporal(5);
		mediadorJuego.removeEntidad(this);
	}

	@Override
	public void chocarConInfectado(Infectado infectado) {
		//hacer nada
	}
}
