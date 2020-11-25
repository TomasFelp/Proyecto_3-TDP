package Premios;

import arma.ArmaSanitariaPerforadora;
import arma.ArmaSanitariaPower;
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

	
	protected void activarPoder(Jugador player) {
		player.setArma(new ArmaSanitariaPerforadora());
	}


	@Override
	public void accionar() {
		// TODO Auto-generated method stub
		
	}
	
}
