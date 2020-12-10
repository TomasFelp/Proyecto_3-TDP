package Colisionadores;

import Premios.Premio;
import arma.Proyectil;
import arma.ProyectilViral;
import entidades.Infectado;
import entidades.Jugador;

public class ColisionadorProyectilViral extends ColisionadorProyectil{

    public ColisionadorProyectilViral(ProyectilViral proyectil){
        super(proyectil);
    }

    public void chocar(Jugador jugador) {
        jugador.recibirDano(dano);
        proyectilAsociado.removeDelJuego();
    }

}
