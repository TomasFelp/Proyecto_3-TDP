package Premios;

import Colisionadores.ColisionadorPremio;
import arma.ArmaFactory;
import Colisionadores.Colisionador;
import entidades.Infectado;
import entidades.Jugador;

/**
 * 
 * Premio temporal que le asigna un arma perforadora al jugador.
 *
 */
public class Super_arma_perforadora extends Premio{

	public Super_arma_perforadora() {
		// TODO Auto-generated constructor stub
		super();
		this.colisionador = new ColisionadorPremio(this);
		this.setIcon(GUI.ImageProvider.getInstancia().getSpritePremioSuperArmaPerforadora());
	}
	
	@Override
	public Premio clone() {
		// TODO Auto-generated method stub
		return new Super_arma_perforadora();
	}

	@Override
	public void activar(Jugador jugador) {
		jugador.setArma(ArmaFactory.getArmaFactory().getArmaPerforadora());
		jugador.premioTemporal(5);
		mediadorJuego.removeEntidad(this);
	}

	public void recibirColision(Colisionador colisionador) {
		//No hacer nada
	}
}
