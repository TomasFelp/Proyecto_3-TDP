package infectado;

import java.awt.Point;

import colisiones.Evaluador_de_colisiones;
import colisiones.ZonaColision;
import entidades.Player;
import juego.*;

public class InfectadoAlfa extends Infectado {
	public InfectadoAlfa() {
		this(new Vector(0, 0));
	}

	public InfectadoAlfa(Vector posicion) {
		super(posicion);
		this.velocidad = new Vector(0, 2);
		this.setIcon(juego.ImageProvider.getInstancia().getSpriteInfectadoAlfa());
	}

	@Override
	public void update() {
		if (estaEnAreaPlayer() && colisionConPlayer())
			System.out.println("player muerto");

		if (estaEnBorde()) {
			this.setLocation(this.getX(), 0);
		} else {
			super.update();
		}
	}

	private boolean estaEnAreaPlayer() {
		Point pos = this.getLocation();
		Player player = mapa.getPlayer();
		int posYPlayer = player.getLocation().y;

		return pos.y > mapa.getHeight() - (posYPlayer + player.getHeight());
	}

	private boolean colisionConPlayer() {
		ZonaColision z_player = mapa.getPlayer().getZonaColision();
		ZonaColision z_this = this.getZonaColision();

		return Evaluador_de_colisiones.estanEnContacto(z_player, z_this);
	}

	private boolean estaEnBorde() {
		return this.getY() > mapa.getHeight();
	}
}
