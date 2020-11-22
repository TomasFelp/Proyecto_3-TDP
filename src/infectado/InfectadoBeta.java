package infectado;

import java.util.List;

import entidades.Entidad;
import entidades.Infectado;
import juego.Vector;

public class InfectadoBeta extends Infectado{

	public InfectadoBeta(Vector posicion,int recorrido) {
		super(posicion,recorrido);
		this.velocidad = new Vector(0, 1);
		this.setIcon(juego.ImageProvider.getInstancia().getSpriteInfectadoBeta());
	}

	@Override
	public void enColision(List<Entidad> colisiones) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void accionar() {
		// TODO Auto-generated method stub
		cargaViral-=34;
		
		if(cargaViral<=0) {
			mediadorJuego.removeEntidadSecundaria(this);
		}
	}

}
