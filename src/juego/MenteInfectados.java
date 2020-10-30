package juego;

import java.awt.Point;

public class MenteInfectados extends Thread{
//Attributes
	JFrameJuego jfJuego;
	private InfectadoBase infectado;
	
//Builder
	/*
	 * Recibe un solo infectado para testear el comportamiento, 
	 * despues deberia recibir el nivel o la coleccion de infectados
	 */
	public MenteInfectados(InfectadoBase inf,JFrameJuego j) {
		infectado=inf;
		jfJuego=j;
	}
	
//Methods
	public void run() {
		boolean condicionCorte=false;
		Point pos=infectado.getLocation();
		int i=0;
		while(condicionCorte==false) {
			try {
				this.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(pos.y>jfJuego.getAlto()) {
				pos.setLocation(pos.x,-jfJuego.getAlto()-40);
			}else {
				pos.setLocation(pos.x,pos.y+infectado.getVelocidad());
			}
				
			
			infectado.setLocation(pos);
			jfJuego.repaint();
		}
	}
}
