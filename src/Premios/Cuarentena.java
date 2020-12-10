package Premios;

import Colisionadores.Colisionador;
import Colisionadores.ColisionadorPremio;
import entidades.Jugador;

/**
 * 
 * Premio que congela infectados de la oleada actual.
 *
 */
public class Cuarentena extends Premio{

	public Cuarentena() {
		// TODO Auto-generated constructor stub
		super();
		this.colisionador = new ColisionadorPremio(this);
		this.setIcon(GUI.ImageProvider.getInstancia().getSpritePremioCuarentena());
	}
	
	@Override
	public Premio clone() {
		// TODO Auto-generated method stub
		return new Cuarentena();
	}

	public void ralentizarInfectados(){
		mediadorJuego.relentizarInfectados(4);
	}

	public void activar(Jugador jugador) {
		mediadorJuego.relentizarInfectados(4);
		mediadorJuego.removeEntidad(this);
	}

	public void recibirColision(Colisionador colisionador) {
		//No hacer nada
	}
}
