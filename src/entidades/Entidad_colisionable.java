package entidades;

import javax.swing.JLabel;

import colisiones.ZonaColision;

public abstract class Entidad_colisionable extends JLabel{
//Attributes
	protected EntidadGrafica grafico;
	
//Methods
	public abstract ZonaColision getZonaColision();
	
}
