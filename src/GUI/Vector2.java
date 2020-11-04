package GUI;

import java.awt.Point;

/**
 * Modela un vector en R^2
 */
public class Vector2 extends Point {
    public Vector2(int x, int y) {
        super(x, y);
    }

    /**
     * Suma las componentes x e y de dos vectores
     */
    public void add(Vector2 v) {
        double x = this.getX() + v.getX();
        double y = this.getY() + v.getY();
        this.setLocation(x, y);
    }
}
