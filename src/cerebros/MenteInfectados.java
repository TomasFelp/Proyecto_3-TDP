package cerebros;

import java.awt.Point;
import colisiones.*;
import entidades.*;
import juego.*;
import entidades.*;
public class MenteInfectados extends Thread{
//Attributes
	private JFrameJuego jfJuego;
	private InfectadoBase[] infectado;
	private Player player;
	private Evaluador_de_colisiones evaluadorColision;
//Builder
	/*
	 * Recibe un solo infectado para testear el comportamiento, 
	 * despues deberia recibir el nivel o la coleccion de infectados
	 */
	public MenteInfectados(Player p,InfectadoBase[] in,JFrameJuego j) {
		infectado=in;
		jfJuego=j;
		player=p;
		evaluadorColision=new Evaluador_de_colisiones();
	}
	
//Methods
	public void run() {
		boolean condicionCorte=false;
		while(condicionCorte==false) {
		for(int i=0;i<infectado.length;i++) {
			Point pos=infectado[i].getLocation();
			
				try {
					this.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//Si llego a la zona en la cual se desplaza el player.
				if(pos.y>jfJuego.getAlto()-80) {
					//obtengo sus zonas de colision y las comparo
					ZonaColision zonaPlayer,zonaInfectado;
					zonaPlayer=player.getZonaColision();
					zonaInfectado=infectado[i].getZonaColision();
					
					if(evaluadorColision.estanEnContacto(zonaPlayer,zonaInfectado)==true) {
						System.out.println("player muerto");
					}
				}
				if(pos.y>jfJuego.getAlto()-60) {
					pos.setLocation(pos.x,0);
				}else {
					pos.setLocation(pos.x,pos.y+infectado[i].getVelocidad());
				}
					
				
				infectado[i].setLocation(pos);
				jfJuego.repaint();
		}
		}
	}
}
