package arma;

import java.awt.Color;
import java.util.List;

import entidades.Entidad;
import entidades.Personaje;
import juego.ImageProvider;
import juego.Vector;

public class Proyectil_sanitario extends Proyectil {

	public Proyectil_sanitario(Vector posicion) {
		super(posicion);
		daño=50;
		velocidad.y=-10;
	}

	@Override
	public void accionar() {

	}

	@Override
	public void enColision(List<Entidad> colisiones) {
		// <<<<--------Redefiniendo esta metodo para que haga lo mismo pero en toda la
		// lista ya podira ser un power up extra
		Personaje entidadImpactada = (Personaje) colisiones.get(0);
        
		if(entidadImpactada!=mediadorJuego.getPlayer()) {
			entidadImpactada.setOpaque(true);
			entidadImpactada.setBackground(Color.BLUE);
	
			entidadImpactada.setDamage(daño);
			entidadImpactada.accionar();
	
			mediadorJuego.removeEntidad(this);
		}

	}
}
