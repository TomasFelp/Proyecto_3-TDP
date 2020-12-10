package arma;

import Colisionadores.Colisionador;
import Colisionadores.ColisionadorProyectilViral;

import GUI.ImageProvider;
import juego.Vector;

/**
 * 
 * Proyectil que afecta al jugador, causandole un dano moderado.
 *
 */
public class ProyectilViral extends Proyectil {

//Attributes	
	protected int posY_inicial;
	protected int alcance;

	// Builder
	public ProyectilViral(Vector posicion) {
		super(posicion);
		setMovimiento(new MovimientoProyectilViral());
		alcance = 200;
		posY_inicial = (int) posicion.getY();
		this.colisionador = new ColisionadorProyectilViral(this);
		this.setIcon(ImageProvider.getInstancia().getSpriteProyectilViral());
	}

	public void update(float deltaTime) {
		super.update(deltaTime);

		if (yReal > 650 || (yReal - posY_inicial) >= alcance)
			mediadorJuego.removeEntidad(this);

	}

	public void recibirColision(Colisionador colisionador) {
		colisionador.chocar(this);
	}
}
