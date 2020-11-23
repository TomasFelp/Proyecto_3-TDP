package arma;

import java.awt.Color;
import java.util.List;

import entidades.Entidad;
import entidades.Personaje;
import juego.Vector;

/**
 * Hace mas daño que el proyectil normal y ademas atraviesa multiples infectados.
 * @author tommy
 *
 */
public class Proyectil_sanitario_perforador extends Proyectil_sanitario_power{

	public Proyectil_sanitario_perforador(Vector posicion) {
		super(posicion);
	}

	@Override
	public void accionar() {

	}

	@Override
	public void enColision(List<Entidad> colisiones) {

		Personaje entidadImpactada;
		
		for(Entidad ent:colisiones) {
			entidadImpactada = (Personaje) ent;
			
			if(entidadImpactada!=mediadorJuego.getPlayer()) {
				entidadImpactada.setOpaque(true);
				entidadImpactada.setBackground(Color.BLUE);
		
				entidadImpactada.setDamage(daño);
				entidadImpactada.accionar();
		}
        
	
		}
	}

}
