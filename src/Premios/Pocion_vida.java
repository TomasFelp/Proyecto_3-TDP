package Premios;

import entidades.Jugador;

public class Pocion_vida extends Premio{

	@Override
	public Premio clone() {
		// TODO Auto-generated method stub
		return new Pocion_vida();
	}

	@Override
	public void accionar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void activarPoder(Jugador player) {
		// TODO Auto-generated method stub
		player.restaurarVida();
	}

}
