package entidades;

/**
 * Clase Colisionable. Un colisionable recibe el impacto de un Colisionador.
 * Por ejemplo: Un Infectado recibe el impacto de un Proyectil
 */
public interface Colisionable {

    public void aceptarColision(Colisionador colisionador);

}
