package Premios;

import entidades.Jugador;

public class Cuarentena extends Premio{

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
