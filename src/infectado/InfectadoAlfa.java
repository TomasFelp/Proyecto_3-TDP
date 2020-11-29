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
		this.setIcon(juego.ImageProvider.getInstancia().getSpriteInfectadoAlfa());
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

	@Override
	public void enColision(List<Entidad> colisiones) {
		// TODO Auto-generated method stub
		
	}

	//Metodos patron visitor

	public void chocarConJugador(Jugador jugador) {
		System.out.print(" chocó con un ALPHA, su salud pasó de " + jugador.getCargaViral());
		if(inofensivo==false)
			jugador.recibirDano(daño);
		System.out.println(" a " + jugador.getCargaViral());
		hacerInofensivo(SEGUNDOS_INOFENSIVO);
	}

	public void chocarConInfectado(Infectado infectado) {
		//No hacer nada
	}

	public void aceptarColision(Colisionador colisionador) {
		colisionador.chocarConInfectado(this);
	}
	
	/*
	private boolean colisionConPlayer() {
		ZonaColision z_player = mapa.getJugador().getZonaColision();
		ZonaColision z_this = this.getZonaColision();

		return Evaluador_de_colisiones.estanEnContacto(z_player, z_this);
	}
	*/

}
