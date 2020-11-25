package Premios;

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
	public void accionar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void activarPoder(Jugador player) {
		// TODO Auto-generated method stub
		player.restaurarVida();
	}

}
