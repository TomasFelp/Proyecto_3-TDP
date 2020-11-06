package arma;

import juego.Vector;

public class Proyectil_sanitario extends Proyectil {
    private static final int defaultDaño = 100;

    public Proyectil_sanitario(Vector posicion, Vector velocidad) {
        super(posicion, velocidad, defaultDaño);
    }
}
