package entidades;

/**
 * Clase Colisionable. Un colisionador impacto en un colisionable.
 * Por ejemplo: El jugador recibe el impacto de un premio.
 */
public interface Colisionador {

    public void chocarConJugador(Jugador jugador);

    public void chocarConInfectado(Infectado infectado);
}
