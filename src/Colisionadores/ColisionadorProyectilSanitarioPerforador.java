package Colisionadores;

import arma.Proyectil_sanitario;
import entidades.Infectado;

public class ColisionadorProyectilSanitarioPerforador extends ColisionadorProyectilSanitario{

	public ColisionadorProyectilSanitarioPerforador(Proyectil_sanitario proyectil) {
        super(proyectil);
    }

    public void chocar(Infectado infectado) {
        infectado.recibirDano(dano);
    }
	
}
