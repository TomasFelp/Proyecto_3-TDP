package arma;

import java.awt.Color;
import java.awt.Point;
import java.util.List;

import entidades.Entidad;
import entidades.Jugador;
import entidades.Personaje;
import juego.ImageProvider;
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

	
//Methods	
	@Override
	public void accionar() {
		// TODO Auto-generated method stub
		
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
				objetivo.setDamage(daño);
				System.out.println("Player impactado");
			}
		}
		
		

	}

}
