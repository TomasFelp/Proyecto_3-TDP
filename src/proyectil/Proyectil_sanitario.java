package proyectil;

import GUI.Vector2;

public class Proyectil_sanitario extends Proyectil {
    private static final int defaultDaño = 100;

    public Proyectil_sanitario(Vector2 posicion, Vector2 velocidad) {
        super(posicion, velocidad, defaultDaño);
    }
}
