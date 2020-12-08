package arma;

import java.awt.Point;

import juego.Vector;

/**
 * Modela el arma que porta el player.
 *
 */
public interface Arma {
	/**
	 * Retorna un nuevo proyectil con la posicion recibida por parametro.
	 * @param posicion de partida del proyectil disparado.
	 * @return proyectil a disparar.
	 */
    public Proyectil disparar(Vector posicion);
}
