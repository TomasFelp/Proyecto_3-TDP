package arma;

import Colisionadores.Colisionador;
import Colisionadores.ColisionadorPremio;
import Colisionadores.ColisionadorProyectilSanitario;
import GUI.ImageProvider;
import juego.Vector;

/**
 * 
 * Proyectil que solo daña a los infectados, causa dano moderado.
 *
 */
public class Proyectil_sanitario extends Proyectil {

	private static final int DANO_PROYECTIL_SANITARIO = 25;

	public Proyectil_sanitario(Vector posicion) {
		super(posicion);
		this.dano = DANO_PROYECTIL_SANITARIO;
		this.colisionador = new ColisionadorProyectilSanitario(this);
		this.setIcon(ImageProvider.getInstancia().getSpriteProyectilSanitario());
		movimiento = new MovimientoProyectilSanitario();
	}

	public void recibirColision(Colisionador colisionador) {
		colisionador.chocar(this);
	}
}
