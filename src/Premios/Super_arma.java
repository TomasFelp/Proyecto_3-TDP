package Premios;

import java.util.List;

import arma.ArmaSanitariaPower;
import entidades.Infectado;
import entidades.Jugador;
import juego.Vector;

/**
 * 
 * Premio temporal que le asigna un arma power al jugador.
 *
 */
public class Super_arma extends Premio{

	public Super_arma() {
		// TODO Auto-generated constructor stub
		super();
		this.setIcon(GUI.ImageProvider.getInstancia().getSpritePremioSuperArma());
	}

	@Override
	public Premio clone() {
		// TODO Auto-generated method stub
		return new Super_arma();
	}


	@Override
	public void chocarConJugador(Jugador jugador) {
		jugador.setArma(new ArmaSanitariaPower());
		jugador.premioTemporal(10);
		mediadorJuego.removeEntidad(this);
	}

	@Override
	public void chocarConInfectado(Infectado infectado) {
		//hacer nada
	}
}
