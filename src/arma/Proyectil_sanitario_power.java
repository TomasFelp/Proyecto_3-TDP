package arma;

import java.awt.Color;
import java.util.List;

import GUI.ImageProvider;
import entidades.Entidad;
import entidades.Infectado;
import entidades.Personaje;
import juego.Vector;

/**
 * Causa el más daño que el proyectil normal
 * 
 *
 */
public class Proyectil_sanitario_power extends Proyectil_sanitario{
	
//Builder
	public Proyectil_sanitario_power(Vector posicion) {
		super(posicion);
		this.setIcon(ImageProvider.getInstancia().getSpriteProyectilSanitarioPower());
		daño=100;
		velocidad.y=-10;
	}

	public void chocarConInfectado(Infectado infectado) {
		System.out.println("Chocó con un proyectil sanitario.");

		infectado.setOpaque(true);
		infectado.setBackground(Color.BLUE);
		infectado.recibirDano(daño);

		mediadorJuego.removeEntidad(this);
	}
	
//Methods
	
}















