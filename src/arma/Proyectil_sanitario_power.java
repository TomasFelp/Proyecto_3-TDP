package arma;

import java.awt.Color;
import java.util.List;

import entidades.Entidad;
import entidades.Personaje;
import juego.Vector;

/**
 * Causa el doble deño que el proyectil normal
 * @author tommy
 *
 */
public class Proyectil_sanitario_power extends Proyectil_sanitario{
	
//Builder
	public Proyectil_sanitario_power(Vector posicion) {
		super(posicion);
		// TODO Auto-generated constructor stub
		daño=(int) (daño*3);
		velocidad.y=-15;
	}
	
//Methods
	
}














