package Niveles;

import entidades.Infectado;

/**
 * 
 * Interfaz general con todos los metodos que debe tener un nivel.
 *
 */
public interface Nivel {
	
	/**
	 * Retorna la siguiente oleada de infectados
	 * @return oleada de infectados.
	 */
	public Infectado[] getOleada();
	
	/**
	 * Consulta si al nivel le quedan oleadas.
	 * @return True si termino, false en caso contrario
	 */
	public boolean termino();
	
	/**
	 * Determina si la oleada actual aun tiene infectados.
	 * @return true si si tiene, false de lo contrario.
	 */
	public boolean quedanInfectadosEnLaOleada();
	
	/**
	 * Decrementa la cantidad de infectados de la oleada actual.
	 */
	public void decrementarOleada();
	
	/**
	 * Relentiza la oleada actual
	 * @param tiempo a relentizar la oleada
	 */
	public void relentizarOleada(int tiempo);
	
	/**
	 * Devuelve el nombre o numero de nivel seguido de la oleada actual.
	 */
	public String getNombre(); 
}
