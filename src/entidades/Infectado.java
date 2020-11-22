package entidades;

import java.awt.Point;

import colisiones.ZonaColision;
import juego.Vector;

public abstract class Infectado extends Personaje {

	public Infectado(Vector posicion) {
		super(posicion);
		cargaViral = 100;
		this.setSize(20, 20);
	}

	public void PropagarVirus() {

	}

	@Override
	public void update(float deltaTime) {
		Point location = this.getLocation();

		mover(velocidad.x * deltaTime, (velocidad.y * deltaTime)/3);

		if (location.y > 600) {
			// <----Para que vuelva a aparecer arriba. Analizar si es más conveniente usar
			// un valor fijo o hacer que conosca la ventana o su tamaño
			this.setLocation(this.getLocation().x, 0);
			this.setPosicionReal(xReal, 0);
		}
	}

	
	// TODO: ver si funciona sin redefinirlo de Entidad
	public ZonaColision getZonaColision() {
		int centroX = (int) (this.getLocation().x - (this.getSize().getWidth()) / 2);
		int centroY = (int) (this.getLocation().y - (this.getSize().getHeight()) / 2);
		int radio = (int) (this.getSize().getHeight() / 2);
		return new ZonaColision(centroX, centroY, radio);
	}
	
	/**
	 * Determina si el infectado esta vivo, si no es asi le informa al juego que hacer.
	 */
	protected void estaVivo() {
		if(cargaViral<=0) {
			mediadorJuego.removeEntidadSecundaria(this);
			mediadorJuego.decrementarInfectados();
		}
	}
	
}







