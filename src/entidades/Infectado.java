package entidades;

import colisiones.ZonaColision;
import juego.Vector;

public abstract class Infectado extends Personaje {

	protected int recorrido;

	public Infectado(Vector posicion, int r) {
		super(posicion);
		cargaViral = 100;
		recorrido = r;
		this.setSize(20, 20);
	}

	public void PropagarVirus() {

	}

	@Override
	public void update(float deltaTime) {
		mover(velocidad.x * deltaTime, velocidad.y * deltaTime);

		if (this.yReal > 600)// <----Para que vuelva a aparecer arriba. Analizar si es más conveniente usar
			// un valor fijo o hacer que conosca la ventana o su tamaño
			this.setLocation(this.getLocation().x, 0);
	}

	// TODO: ver si funciona sin redefinirlo de Entidad
	public ZonaColision getZonaColision() {
		int centroX = (int) (this.getLocation().x - (this.getSize().getWidth()) / 2);
		int centroY = (int) (this.getLocation().y - (this.getSize().getHeight()) / 2);
		int radio = (int) (this.getSize().getHeight() / 2);
		return new ZonaColision(centroX, centroY, radio);
	}
}
