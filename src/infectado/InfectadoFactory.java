package infectado;

import entidades.Infectado;
import juego.Vector;

/**
 * 
 * Define todos los metodos que debe tener una fabrica de infectados.
 *
 */
public interface InfectadoFactory {

	/**
	 * Retorna un infectado
	 * @param Posicion posicion del infectado.
	 * @return nuevo infectado.
	 */
	public Infectado crearInfectado(Vector posicion);

}
