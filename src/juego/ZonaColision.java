package juego;

/**
 * Modela un circulo
 * @author Tomás
 */
public class ZonaColision {
//Attributes	
	private int centro;
	private int radio;

//Builder
	public ZonaColision(int c,int r) {
		centro = c;
		radio = r;
	}
	
//Methods
	public void setCentro(int c) {
		centro=c;
	}
	
	public void setRadio(int r) {
		radio=r;
	}
	
	public int getCentro() {
		return centro;
	}
	
	public int getRadio(){
		return radio;
	}
}
