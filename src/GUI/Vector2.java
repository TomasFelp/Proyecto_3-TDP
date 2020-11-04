package GUI;

/**
 * Modela un vector en R^2
 */
public class Vector2 {
    private double vectorX;
    private double vectorY;

    public Vector2(double x, double y) {
        vectorX = x;
        vectorY = y;
    }

    public double getX() {
        return vectorX;
    }

    public double getY() {
        return vectorY;
    }

    public void setX(double x) {
        vectorX = x;
    }

    public void setY(double y) {
        vectorY = y;
    }

    /**
     * Suma las componentes x e y de dos vectores
     */
    public void add(Vector2 v) {
        vectorX += v.getX();
        vectorY += v.getY();
    }
}
