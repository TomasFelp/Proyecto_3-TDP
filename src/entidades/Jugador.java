package entidades;

import arma.Arma;
import arma.ArmaFactory;

public class Jugador extends Personaje{

    private Arma arma;

    public Jugador() {
        super();
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

    public double getVelocidadY() {
        return super.getVelocidad().getY();
    }
}
