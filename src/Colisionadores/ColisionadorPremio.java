package Colisionadores;

import Premios.Premio;
import arma.Proyectil;
import entidades.Infectado;
import entidades.Jugador;

public class ColisionadorPremio implements Colisionador{

    protected Premio premioAsociado;

    public ColisionadorPremio(Premio premio){
        this.premioAsociado = premio;
    }

    public void chocar(Jugador jugador) {
        premioAsociado.activar(jugador);
    }

    public void chocar(Infectado infectado) {}

    public void chocar(Premio premio) {}

    public void chocar(Proyectil proyectil) {}
}
