package Premios;

import java.util.List;

import arma.ArmaSanitariaPower;
import entidades.Jugador;
import juego.Vector;

public class Super_arma extends Premio{

	public Super_arma() {
		// TODO Auto-generated constructor stub
		super();
		this.setIcon(juego.ImageProvider.getInstancia().getSpritePremioSuperArma());
	}
	
	@Override
	public void accionar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Premio clone() {
		// TODO Auto-generated method stub
		return new Super_arma();
	}

	
	protected void activarPoder(Jugador player) {
		player.setArma(new ArmaSanitariaPower());
	}
}
