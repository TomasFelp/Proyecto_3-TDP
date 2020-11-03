package colisiones;

/**
 * Modela un circulo
 * @author Tomás
 */
public class ZonaColision {
//Attributes	
	private int centroX;
	private int centroY;
	private int radio;

//Builder
	public ZonaColision(int cx,int cy,int r) {
		centroX = cx;
		centroY = cy;
		radio = r;
	}
	
//Methods
	public void setCentro(int cx,int cy) {
		centroX = cx;
		centroY = cy;
	}
	
	public void setRadio(int r) {
		radio=r;
	}
	
	public int getCentroX() {
		return centroX;
	}
	
	public int getCentroY() {
		return centroY;
	}
	
	public int getRadio(){
		return radio;
	}
}
