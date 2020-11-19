package infectado;

import java.awt.Color;
import java.util.List;

import entidades.Entidad;
import entidades.Infectado;
import juego.*;

public class InfectadoAlfa extends Infectado {

	public InfectadoAlfa(Vector posicion,int recorrido) {
		super(posicion,recorrido);
		this.velocidad = new Vector(0, 1);
		this.setIcon(juego.ImageProvider.getInstancia().getSpriteInfectadoAlfa());
	}

	/**
	 * Use el accionar para que reciba el daño cuando le impacta un proyectil
	 */
	public void accionar() {
		cargaViral-=50;
		
		if(cargaViral<=0) {
			mediadorJuego.removeEntidadSecundaria(this);
		}
	}

	@Override
	public void enColision(List<Entidad> colisiones) {
		// TODO Auto-generated method stub
		for(Entidad a: colisiones) {
			this.setOpaque(true);
			this.setBackground(Color.BLUE);
		}
	}
	
	/*
	private boolean colisionConPlayer() {
		ZonaColision z_player = mapa.getJugador().getZonaColision();
		ZonaColision z_this = this.getZonaColision();

		return Evaluador_de_colisiones.estanEnContacto(z_player, z_this);
	}
	*/

}
