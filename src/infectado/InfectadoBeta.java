package infectado;

import java.util.List;

import entidades.Colisionador;
import entidades.Entidad;
import entidades.Infectado;
import entidades.Jugador;
import juego.Vector;


/**
 * 
 * Modela un infectado Beta este tipo de infectados posee una mayor resistencia y produce un mayor daño.
 *
 */
public class InfectadoBeta extends Infectado{

	private int daño = 50;

	public InfectadoBeta(Vector posicion) {
		super(posicion);
		this.setIcon(GUI.ImageProvider.getInstancia().getSpriteInfectadoBeta());
		velocidadDefault=1;
		cargaViral=(int) (cargaViral*1.5);
	}

	public void recibirDano(int dano) {
		if(cargaViral - dano > 0){
			this.cargaViral -= dano; //recibe el daño
		} else{
			this.declararRecuperado();
		}
	}

	public void chocarConJugador(Jugador jugador) {
		
		if(inofensivo==false) {
			jugador.recibirDano(daño);
			hacerInofensivo(SEGUNDOS_INOFENSIVO);
		}
		
	}

	public void chocarConInfectado(Infectado infectado) {
		//No hacer nada
	}

	public void aceptarColision(Colisionador colisionador) {
		colisionador.chocarConInfectado(this);
	}
}
