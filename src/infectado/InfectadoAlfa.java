package infectado;

import java.awt.Point;

import colisiones.Evaluador_de_colisiones;
import colisiones.ZonaColision;
import entidades.Player;
import juego.*;

public class InfectadoAlfa extends Infectado {

	public InfectadoAlfa(Vector posicion,int recorrido) {
		super(posicion,recorrido);
		this.velocidad = new Vector(0, 1);
		this.setIcon(juego.ImageProvider.getInstancia().getSpriteInfectadoAlfa());
	}
	
	/*
	private boolean colisionConPlayer() {
		ZonaColision z_player = mapa.getPlayer().getZonaColision();
		ZonaColision z_this = this.getZonaColision();

		return Evaluador_de_colisiones.estanEnContacto(z_player, z_this);
	}
	*/

}
