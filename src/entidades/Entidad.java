package entidades;

import java.util.List;
import java.util.Random;

import javax.swing.JLabel;

import cerebros.GameController;
import colisiones.ZonaColision;
import juego.Mapa;
import juego.Vector;

public abstract class Entidad extends JLabel {
    private int ID;

    public Entidad() {
        Random rnd = new Random();
        ID = rnd.nextInt();
    }

    public Entidad(Vector posicion) {
        this();
        this.setLocation(posicion);
    }

    

    @Override
    public int hashCode() {
        return ID;
    }

    public ZonaColision getZonaColision() {
        int x = this.getX() - this.getWidth() / 2;
        int y = this.getY();
        int height = this.getHeight();
        return new ZonaColision(x, y, height);
    }

    /**
     * Determina si el objeto esta en su ciclo de vida para ver si vale la pena o no
     * almacenarlo.
     * 
     * @return true si esta en su ciclo de vida, false de lo contrario.
     */
    public abstract boolean itsAlive();

    public void mover(Vector velocidad) {
        int x = this.getX() + velocidad.x;
        int y = this.getY() + velocidad.y;
        this.setLocation(x, y);
    }

    public void enColision(List<Entidad> colisiones) {

    }
}
