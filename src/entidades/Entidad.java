package entidades;

import java.util.Random;

import javax.swing.JLabel;

import cerebros.GameController;
import colisiones.ZonaColision;
import juego.Mapa;
import juego.Vector;

public abstract class Entidad extends JLabel {
	private int ID;
	protected Mapa mapa;
	
	public Entidad() {
		Random rnd = new Random();
		ID = rnd.nextInt();
        mapa = GameController.getInstancia().getMapa();
	}
	
    public Entidad(Vector posicion) {
    	this();
    	this.setLocation(posicion);
    }

    /**
     * Se llama en cada secuencia de actualizacion del
     * GameController
     */
    public abstract void update();

	@Override
	public int hashCode() {
		return ID;
	}
	
    public ZonaColision getZonaColision() {
    	return new ZonaColision(this.getX(), this.getY(), this.getHeight());
    }
	
	/**
	 * Determina si el objeto esta en su ciclo de vida para ver si vale la pena o no
	 * almacenarlo.
	 * @return true si esta en su ciclo de vida, false de lo contrario.
	 */
	public abstract boolean itsAlive();
    
    public void mover(Vector velocidad) {
        int x = this.getX() + velocidad.x;
        int y = this.getY() + velocidad.y;
        this.setLocation(x,y);
    }
    
}