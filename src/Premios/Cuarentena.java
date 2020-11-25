package Premios;

import entidades.Jugador;

public class Cuarentena extends Premio{

	public Cuarentena() {
		// TODO Auto-generated constructor stub
		super();
		this.setIcon(juego.ImageProvider.getInstancia().getSpritePremioCuarentena());
	}
	
	@Override
	public Premio clone() {
		// TODO Auto-generated method stub
		return new Cuarentena();
	}

	@Override
	protected void activarPoder(Jugador player) {
		// TODO Auto-generated method stub
		mediadorJuego.relentizarInfectados();;
	}

	@Override
	public void accionar() {
		// TODO Auto-generated method stub
		
	}

}
