package infectado;

import java.util.List;

import entidades.Entidad;
import entidades.Infectado;
import juego.Vector;

public class InfectadoBeta extends Infectado{

	public InfectadoBeta(Vector posicion) {
		super(posicion);
		this.velocidad = new Vector(0, 1);
		this.setIcon(juego.ImageProvider.getInstancia().getSpriteInfectadoBeta());
		velocidadDefault=1;
		cargaViral=(int) (cargaViral*1.5);
	}

	@Override
	public void enColision(List<Entidad> colisiones) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void accionar() {
		// TODO Auto-generated method stub
		
		estaVivo();
	}

}
