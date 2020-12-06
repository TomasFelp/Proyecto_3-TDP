package infectado;

import java.util.List;

import entidades.Colisionador;
import entidades.Entidad;
import entidades.Infectado;
import entidades.Jugador;
import juego.*;

public class InfectadoAlfa extends Infectado {

	private int daño = 34;

	public InfectadoAlfa(Vector posicion) {
		super(posicion);
		this.velocidad = new Vector(0, 1);
		this.setIcon(GUI.ImageProvider.getInstancia().getSpriteInfectadoAlfa());
		this.setVisible(true);
		velocidadDefault=1;
	}

	public void accionar() {

	}

	public void recibirDano(int dano) {
		if(cargaViral - dano > 0){
			this.cargaViral -= dano; //recibe el dano
			if(cargaViral<50) //Si el infectado alfa tiene un nivel de vida critico duplica su velocidad
				velocidad.y=velocidad.y*2;
		} else{
			//morido
			this.declararRecuperado();
		}
	}

	//Metodos patron visitor

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
