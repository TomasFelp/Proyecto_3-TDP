package Colisionadores;

import Premios.Premio;
import arma.Proyectil;
import entidades.Infectado;
import entidades.Jugador;

/**
 * Define todos los metodos de la interface para poder extender esta clase y de esa forma evitar definir metodos vacios en
 * cada Colisionador concreto.
 * 
 */
public abstract class ColisionadorBase implements Colisionador{

	public void chocar(Jugador jugador) {}

    public void chocar(Infectado infectado) {}

    public void chocar(Premio premio) {}

    public void chocar(Proyectil proyectil) {}
	
}
