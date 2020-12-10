package arma;

import GUI.ImageProvider;
import entidades.*;
import juego.Vector;

/**
 * 
 * Proyectil que afecta al jugador, causandole un daño moderado.
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
		this.setIcon(ImageProvider.getInstancia().getSpriteProyectilViral());
	}

	public void update(float deltaTime) {
		super.update(deltaTime);

		if (yReal > 650 || (yReal - posY_inicial) >= alcance)
			mediadorJuego.removeEntidad(this);

	}

	@Override
	public void chocarConJugador(Jugador jugador) {
		jugador.recibirDano(daño);
		mediadorJuego.removeEntidad(this);
	}

	@Override
	public void chocarConInfectado(Infectado infectado) {

	}

	@Override
	public void aceptarColision(Colisionador colisionador) {
		// No hacer nada
	}
}
