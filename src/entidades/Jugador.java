package entidades;

import arma.Arma;
import arma.ArmaFactory;
import colisiones.ZonaColision;

public class Player extends Entidad{
    private Arma arma;
    private final int saludMax = 100;
    private final int saludMin = 0;
	private int velocidad;
	private int saludActual;

    public Player() {
        saludActual = 100;
        velocidad = 10;
        this.setIcon(juego.ImageProvider.getInstancia().getSpritePlayer());
        this.arma = ArmaFactory.getDefaultArma();
    }
    
    public void setArma(Arma a) {
        this.arma = a;
    }
    public void disparar(){
        arma.disparar(this.getLocation());
    }

	@Override
	public void update() {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean itsAlive() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getVelocidad() {
    	return velocidad;
	}
}
