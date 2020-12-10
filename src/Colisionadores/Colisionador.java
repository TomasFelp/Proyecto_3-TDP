package Colisionadores;

import Premios.Premio;
import arma.Proyectil;
import entidades.Infectado;
import entidades.Jugador;

/**
 * Clase Colisionable. Un colisionador impacto en un colisionable.
 * Por ejemplo: El jugador recibe el impacto de un premio.
 */
public interface Colisionador {

    public void chocar(Jugador jugador);

    public void chocar(Infectado infectado);

    public void chocar(Premio premio);

    public void chocar(Proyectil proyectil);
}
