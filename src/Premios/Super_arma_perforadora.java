package Premios;

import arma.ArmaSanitariaPerforadora;
import arma.ArmaSanitariaPower;
import entidades.Infectado;
import entidades.Jugador;

public class Super_arma_perforadora extends Premio{

	public Super_arma_perforadora() {
		// TODO Auto-generated constructor stub
		super();
		this.setIcon(juego.ImageProvider.getInstancia().getSpritePremioSuperArmaPerforadora());
	}
	
	@Override
	public Premio clone() {
		// TODO Auto-generated method stub
		return new Super_arma_perforadora();
	}

	@Override
	public void chocarConJugador(Jugador jugador) {
		jugador.setArma(new ArmaSanitariaPerforadora());
		mediadorJuego.removeEntidad(this);
	}

	@Override
	public void chocarConInfectado(Infectado infectado) {
		//hacer nada
	}
}
