package arma;

import Colisionadores.Colisionador;
import Colisionadores.ColisionadorProyectilSanitario;
import GUI.ImageProvider;
import juego.Vector;

/**
 * Causa  más dano que el proyectil sanitario normal
 *
 */
public class Proyectil_sanitario_power extends Proyectil_sanitario{

	protected static final int DANO_PROYECTIL_SANITARIO_POWER = 100;
	
//Builder
	public Proyectil_sanitario_power(Vector posicion) {
		super(posicion);
		this.dano = DANO_PROYECTIL_SANITARIO_POWER;
		this.setIcon(ImageProvider.getInstancia().getSpriteProyectilSanitarioPower());
		this.colisionador = new ColisionadorProyectilSanitario(this);
	}

	public void recibirColision(Colisionador colisionador) {
		colisionador.chocar(this);
	}
}















