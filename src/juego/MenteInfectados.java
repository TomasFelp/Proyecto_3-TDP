package juego;

import java.awt.Point;

public class MenteInfectados extends Thread{
//Attributes
	JFrameJuego jfJuego;
	private InfectadoBase[] infectado;
	
//Builder
	/*
	 * Recibe un solo infectado para testear el comportamiento, 
	 * despues deberia recibir el nivel o la coleccion de infectados
	 */
	public MenteInfectados(Nivel nivel,JFrameJuego j) {
		infectado=nivel.getPrimerOleada();
		jfJuego=j;
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
				if(pos.y>jfJuego.getAlto()-40) {
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
