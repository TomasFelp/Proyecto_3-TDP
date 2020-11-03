package entidades;

import javax.swing.JLabel;

import colisiones.ZonaColision;

public abstract class Entidad_colisionable extends JLabel{
	
	public abstract ZonaColision getZonaColision();
	
}
