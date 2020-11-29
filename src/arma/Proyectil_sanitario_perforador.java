package arma;

import java.awt.Color;
import java.util.List;

import entidades.Entidad;
import entidades.Infectado;
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

	public void chocarConInfectado(Infectado infectado) {
		System.out.println("Chocó con un proyectil sanitario.");

		infectado.setOpaque(true);
		infectado.setBackground(Color.BLUE);
		infectado.recibirDano(daño);
		
	}

}
