package Premios;

import Colisionadores.ColisionadorPremio;
import arma.ArmaFactory;
import Colisionadores.Colisionador;
import entidades.Infectado;
import entidades.Jugador;

/**
 * 
 * Premio temporal que le asigna un arma power al jugador.
 *
 */
public class Super_arma extends Premio{

	public Super_arma() {
		// TODO Auto-generated constructor stub
		super();
		this.colisionador = new ColisionadorPremio(this);
		this.setIcon(GUI.ImageProvider.getInstancia().getSpritePremioSuperArma());
	}

	@Override
	public Premio clone() {
		// TODO Auto-generated method stub
		return new Super_arma();
	}

	public void activar(Jugador jugador) {
		
		jugador.setArma(ArmaFactory.getArmaFactory().getArmaPower());
		jugador.premioTemporal(10);
		mediadorJuego.removeEntidad(this);
		
	}

	@Override
	public void recibirColision(Colisionador colisionador) {
		//No hacer nada
	}
}
