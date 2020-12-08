package arma;

import java.awt.Color;
import java.util.List;

import GUI.ImageProvider;
import entidades.Entidad;
import entidades.Infectado;
import entidades.Personaje;
import juego.Vector;

/**
 * Hace mas daño que el proyectil normal y ademas atraviesa multiples infectados.
 *
 */
public class Proyectil_sanitario_perforador extends Proyectil_sanitario{

	public Proyectil_sanitario_perforador(Vector posicion) {
		super(posicion);
		this.setIcon(ImageProvider.getInstancia().getSpriteProyectilSanitarioPerforador());
		daño=25;
		velocidad.y=-10;
	}

	public void chocarConInfectado(Infectado infectado) {

		infectado.recibirDano(daño);
		
	}

}

