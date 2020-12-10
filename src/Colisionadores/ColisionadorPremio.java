package Colisionadores;

import Premios.Premio;
import arma.Proyectil;
import entidades.Infectado;
import entidades.Jugador;

public class ColisionadorPremio extends ColisionadorBase{

    protected Premio premioAsociado;

    public ColisionadorPremio(Premio premio){
        this.premioAsociado = premio;
    }

    public void chocar(Jugador jugador) {
        premioAsociado.activar(jugador);
    }

}
