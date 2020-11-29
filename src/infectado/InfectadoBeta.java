package infectado;

import java.util.List;

import entidades.Colisionador;
import entidades.Entidad;
import entidades.Infectado;
import entidades.Jugador;
import juego.Vector;

public class InfectadoBeta extends Infectado{

	private int daño = 50;

	public InfectadoBeta(Vector posicion) {
		super(posicion);
		this.velocidad = new Vector(0, 1);
		this.setIcon(GUI.ImageProvider.getInstancia().getSpriteInfectadoBeta());
		velocidadDefault=1;
		cargaViral=(int) (cargaViral*1.5);
	}

	public void recibirDano(int dano) {
		if(cargaViral - dano > 0){
			this.cargaViral -= dano; //recibe el dano
		} else{
			//morido
			this.declararRecuperado();
		}
	}

	@Override
	public void enColision(List<Entidad> colisiones) {
		// TODO Auto-generated method stub
		
	}

	public void chocarConJugador(Jugador jugador) {
		
		if(inofensivo==false) {
			System.out.print(" chocó con un BETA, su salud pasó de " + jugador.getCargaViral());
			jugador.recibirDano(daño);
			System.out.println(" a " + jugador.getCargaViral());
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
