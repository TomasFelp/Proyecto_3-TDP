package arma;

import java.awt.Point;
import java.util.List;

import GUI.ImageProvider;
import entidades.Entidad;
import entidades.Infectado;
import entidades.Jugador;
import entidades.Personaje;
import juego.Vector;

public class ProyectilViral extends Proyectil{

//Attributes	
	protected int posY_inicial;
	protected int alcance;

	//Builder 
	public ProyectilViral(Vector posicion) {
		super(posicion);
		this.velocidad=new Vector(0,1);
		alcance=200;
		posY_inicial=(int) posicion.getY();
		this.setIcon(ImageProvider.getInstancia().getSpriteProyectilViral());
	}
	
	public void update(float deltaTime) {
		Point posicion = this.getLocation();

		mover(velocidad.x * deltaTime, velocidad.y * deltaTime);

		if (posicion.getY() > 650 || (posicion.getY()-posY_inicial)>=alcance)
				mediadorJuego.removeEntidad(this);

	}

	//TODO: Revisar
	public void chocarConJugador(Jugador jugador) {
		jugador.recibirDano(daño);
		mediadorJuego.removeEntidad(this);
	}

	public void chocarConInfectado(Infectado infectado) {

	}
}
