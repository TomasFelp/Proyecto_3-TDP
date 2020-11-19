package arma;

import java.awt.Color;
import java.util.List;

import entidades.Entidad;
import juego.Vector;

public class Proyectil_sanitario extends Proyectil {
    private static final int defaultDaño = 100;

    public Proyectil_sanitario(Vector posicion, Vector velocidad) {
        super(posicion, velocidad, defaultDaño);
    }

	@Override
	public void accionar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enColision(List<Entidad> colisiones) {
		// TODO Auto-generated method stub
		/*
		for(Entidad a: colisiones) {
			a.setOpaque(true);
			a.setBackground(Color.BLUE);
		}*/
		colisiones.get(0).setOpaque(true);
		colisiones.get(0).setBackground(Color.GREEN);
	}
}
