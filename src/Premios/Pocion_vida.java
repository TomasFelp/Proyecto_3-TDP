package Premios;

import Colisionadores.Colisionador;
import Colisionadores.ColisionadorPremio;
import entidades.Infectado;
import entidades.Jugador;

/**
 * 
 * Premio que restaura la vida del jugador.
 */
public class Pocion_vida extends Premio{

	public Pocion_vida() {
		// TODO Auto-generated constructor stub
		super();
		this.colisionador = new ColisionadorPremio(this);
		this.setIcon(GUI.ImageProvider.getInstancia().getSpritePremioPocionVida());
	}
	
	@Override
	public Premio clone() {
		// TODO Auto-generated method stub
		return new Pocion_vida();
	}

	public void activar(Jugador jugador) {
		jugador.restaurarVida();
		mediadorJuego.removeEntidad(this);
	}

	public void recibirColision(Colisionador colisionador) {
		//No hacer nada
	}
}
