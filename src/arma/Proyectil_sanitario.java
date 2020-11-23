package arma;

import java.awt.Color;
import java.util.List;

import entidades.Entidad;
import juego.ImageProvider;
import juego.Vector;

public class Proyectil_sanitario extends Proyectil {
	private static final int defaultDaño = 100;

	public Proyectil_sanitario(Vector posicion, Vector velocidad) {
		super(posicion, velocidad, defaultDaño);
	}

	@Override
	public void accionar() {

	}

	@Override
	public void enColision(List<Entidad> colisiones) {
		// <<<<--------Redefiniendo esta metodo para que haga lo mismo pero en toda la
		// lista ya podira ser un power up extra
		Entidad entidadImpactada = colisiones.get(0);
        
		if(entidadImpactada!=mediadorJuego.getPlayer()) {
			entidadImpactada.setOpaque(true);
			entidadImpactada.setBackground(Color.BLUE);
	
			entidadImpactada.accionar();
	
			mediadorJuego.removeEntidad(this);
		}

	}
}
