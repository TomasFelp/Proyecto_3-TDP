package arma;

import java.awt.Color;
import java.util.List;

import GUI.ImageProvider;
import entidades.Entidad;
import entidades.Infectado;
import entidades.Jugador;
import entidades.Personaje;
import juego.Vector;

public class Proyectil_sanitario extends Proyectil {

	public Proyectil_sanitario(Vector posicion) {
		super(posicion);
		this.setIcon(ImageProvider.getInstancia().getSpriteProyectilSanitario());
		daño=25;
		velocidad.y=-10;
	}

	public void chocarConJugador(Jugador jugador) {

	}

	public void chocarConInfectado(Infectado infectado) {

		infectado.recibirDano(daño);
		
		mediadorJuego.removeEntidad(this);
	}
}
