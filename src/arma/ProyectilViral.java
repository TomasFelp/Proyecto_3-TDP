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
	
	@Override
	public void enColision(List<Entidad> colisiones) {
		Jugador objetivo= mediadorJuego.getPlayer();
		Personaje entidadImpactada;
		
		for(Entidad ent:colisiones) {
			
			entidadImpactada = (Personaje) colisiones.get(0);
			
			if(entidadImpactada==objetivo) {
				mediadorJuego.removeEntidad(this);
				objetivo.recibirDano(daño);
				System.out.println("Player impactado");
			}
		}
		
		

	}

	//TODO: Revisar
	public void chocarConJugador(Jugador jugador) {
		System.out.print(" chocó con un proyecti VIRAL, su salud pasó de " + jugador.getCargaViral());
		jugador.recibirDano(daño);
		System.out.println(" a " + jugador.getCargaViral());
		mediadorJuego.removeEntidad(this);
	}

	public void chocarConInfectado(Infectado infectado) {

	}
}
