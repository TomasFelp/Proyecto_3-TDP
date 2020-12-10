package infectado;

import Colisionadores.Colisionador;
import Colisionadores.ColisionadorInfectado;
import entidades.Infectado;
import entidades.Jugador;
import juego.Vector;


/**
 * 
 * Modela un infectado Beta este tipo de infectados posee una mayor resistencia y produce un mayor dano.
 *
 */
public class InfectadoBeta extends Infectado{

	private final int DANO_INFECTADO_BETA = 50;

	public InfectadoBeta(Vector posicion) {
		super(posicion);
		this.dano = DANO_INFECTADO_BETA;
		this.colisionador = new ColisionadorInfectado(this);
		velocidadDefault=1;
		cargaViral=(int) (cargaViral*1.5);
		this.setIcon(GUI.ImageProvider.getInstancia().getSpriteInfectadoBeta());
	}

	public void recibirDano(int dano) {
		if(cargaViral - dano > 0){
			this.cargaViral -= dano; //recibe el dano
		} else{
			this.declararRecuperado();
		}
	}

	public void recibirColision(Colisionador colisionador) {
		colisionador.chocar(this);
	}
}
