package juego;

import java.awt.Point;

/**
 * Modela un vector en R^2
 */
public class Vector extends Point {
    public Vector(int x, int y) {
        super(x, y);
    }

    /**
     * Suma las componentes x e y de dos vectores
     */
    public void add(Vector v) {
        double x = this.getX() + v.getX();
        double y = this.getY() + v.getY();
        this.setLocation(x, y);
    }
}
