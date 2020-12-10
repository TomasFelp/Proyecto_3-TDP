package Colisionadores;

import Premios.Premio;
import arma.Proyectil;
import arma.Proyectil_sanitario;
import entidades.Infectado;
import entidades.Jugador;

public class ColisionadorProyectilSanitario extends ColisionadorProyectil {

    public ColisionadorProyectilSanitario(Proyectil_sanitario proyectil) {
        super(proyectil);
    }

    public void chocar(Infectado infectado) {
        infectado.recibirDano(dano);
        proyectilAsociado.removeDelJuego();
    }

    public void chocar(Premio premio) {}

    public void chocar(Jugador jugador) {}



    public void chocar(Proyectil proyectil) {}
}
