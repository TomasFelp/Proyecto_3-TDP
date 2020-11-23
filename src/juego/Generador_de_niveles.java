package juego;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Gurda una cola de niveles.
 * @author Tomás 
 */
public class Generador_de_niveles {

//Attributes
	protected Queue<Nivel> niveles; 
	
//Builder
	public Generador_de_niveles() {
		niveles=new LinkedList<Nivel>();
		niveles.add(new Nivel1());
		niveles.add(new Nivel2());
	}
	
//Methods
	/**
	 * Consulta si quedan niveles
	 * @return True si queda algun nivel, False en caso contrario.
	 */
	public boolean quedanNiveles() {
		return !niveles.isEmpty();
	}
	
	public Nivel getSiguienteNivel() {
		return niveles.remove();
	}

}