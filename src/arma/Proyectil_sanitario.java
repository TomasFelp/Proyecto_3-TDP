package arma;

import java.awt.Color;
import java.util.List;

import entidades.Entidad;
import entidades.Infectado;
import entidades.Jugador;
import entidades.Personaje;
import juego.Vector;

public class Proyectil_sanitario extends Proyectil {

	public Proyectil_sanitario(Vector posicion) {
		super(posicion);
		daño=25;
		velocidad.y=-10;
	}

	public void chocarConJugador(Jugador jugador) {

	}

	public void chocarConInfectado(Infectado infectado) {
		System.out.println("Chocó con un proyectil sanitario.");

		infectado.setOpaque(true);
		infectado.setBackground(Color.BLUE);
		infectado.recibirDano(daño);
		
		mediadorJuego.removeEntidad(this);
	}
}
