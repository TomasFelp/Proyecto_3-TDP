package colisiones;

import java.awt.Point;

/**
 * Modela un circulo
 * 
 * @author Tomás
 */
public class ZonaColision {
    private Point centro;
    private double radio;

    public ZonaColision(Point centro, int r) {
        this.centro = centro;
        radio = r;
    }

    public ZonaColision(int cx, int cy, int r) {
        centro = new Point(cx, cy);
        radio = r;
    }

    public void setCentro(int cx, int cy) {
        centro = new Point(cx, cy);
    }

    public void setRadio(int r) {
        radio = r;
    }

    public Point getCentro() {
        return centro;
    }

    public double getCentroX() {
        return centro.getX();
    }

    public double getCentroY() {
        return centro.getY();
    }

    public double getRadio() {
        return radio;
    }
}
