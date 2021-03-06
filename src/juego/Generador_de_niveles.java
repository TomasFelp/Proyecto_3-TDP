package juego;

import java.util.LinkedList;
import java.util.Queue;

import Niveles.Nivel;
import Niveles.Nivel1;
import Niveles.Nivel2;
import Niveles.Nivel3;

/**
 * Gurda una cola de niveles.
 */
public class Generador_de_niveles {

//Attributes
	protected Queue<Nivel> niveles; 
	
//Builder
	public Generador_de_niveles() {
		niveles=new LinkedList<Nivel>();

		niveles.add(new Nivel1());
		niveles.add(new Nivel2());
		niveles.add(new Nivel3());
	}
	
//Methods
	/**
	 * Consulta si quedan niveles
	 * @return True si queda algun nivel, False en caso contrario.
	 */
	public boolean quedanNiveles() {
		return !niveles.isEmpty();
	}
	
	/**
	 * Devuelve el siguiente nivel de la cola y lo remueve de la misma.
	 * @return siguiente nivel.
	 */
	public Nivel getSiguienteNivel() {
		return niveles.remove();
	}

}
