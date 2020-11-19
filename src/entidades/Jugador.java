package entidades;

import java.awt.Color;
import java.awt.Point;
import java.util.List;

import arma.Arma;
import arma.ArmaFactory;
import arma.Proyectil;
import juego.Vector;

public class Jugador extends Personaje{

    private Arma arma;
    private int velocidad;

    public Jugador() {
        super();
        this.velocidad = 10;
        this.setIcon(juego.ImageProvider.getInstancia().getSpritePlayer());
        this.arma = ArmaFactory.getDefaultArma();
    }

    public void accionar() {

    }
    
    public void setArma(Arma a) {
        this.arma = a;
    }
    public Proyectil disparar(){
    	
    	Point pos=this.getLocation();
    	int x,y;
    	x=(int) pos.getX();
    	y=(int) pos.getY();
    	Vector posicion=new Vector(x,y);
    	
        return arma.disparar(posicion);
    }

	@Override
	public void update() {
		// TODO Auto-generated method stub
	}

    public double getVelocidadY() {
        return velocidad;
    }

	@Override
	public void enColision(List<Entidad> colisiones) {
		// TODO Auto-generated method stub
		for(Entidad a: colisiones) {
			this.setOpaque(true);
			this.setBackground(Color.BLUE);
		}
	}
}
