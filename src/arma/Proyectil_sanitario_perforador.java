package arma;

import Colisionadores.ColisionadorPremio;
import Colisionadores.ColisionadorProyectilSanitario;
import Colisionadores.ColisionadorProyectilSanitarioPerforador;
import GUI.ImageProvider;
import Colisionadores.Colisionador;
import entidades.Infectado;
import juego.Vector;

/**
 * Hace mas dano que el proyectil normal y ademas atraviesa multiples infectados.
 *
 */
public class Proyectil_sanitario_perforador extends Proyectil_sanitario{

	private static final int DANO_PROYECTIL_PERF = 100;

	public Proyectil_sanitario_perforador(Vector posicion) {
		super(posicion);
		this.dano = DANO_PROYECTIL_PERF;
		this.colisionador = new ColisionadorProyectilSanitarioPerforador(this);
		this.setIcon(ImageProvider.getInstancia().getSpriteProyectilSanitarioPerforador());
		velocidad.y=-10;
	}

	public void recibirColision(Colisionador colisionador) {
		colisionador.chocar(this);
	}
}

