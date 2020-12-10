package entidades;

import Premios.Premio;
import arma.Proyectil;

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
