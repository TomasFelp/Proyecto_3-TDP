package infectado;

import entidades.NPC;
import juego.Vector;

/**
 * Modela la clase base de todos los infectados del juego.
 */
public abstract class Infectado extends NPC {
	//Si queremos cambiar la velocidad de todos los infectados, cambiamos
	//esta variable
	private static int rapidezGlobalInfectados = 1;
	
	public Infectado(Vector posicion) {
		super(posicion);
		saludActual = 100;
	}
	
	public void disparar() {
		// TODO El infectado puede disparar proyectiles

	}

	public static void setRapidezGlobalInfectados(int v) {
		rapidezGlobalInfectados = v;
	}

	@Override
	public boolean itsAlive() {
		return saludActual > 0;
	}
}