package Colisionadores;

import Premios.Premio;
import arma.Proyectil;
import entidades.Infectado;
import entidades.Jugador;

public class ColisionadorInfectado extends  ColisionadorBase{

    protected Infectado infectadoAsociado;

    public ColisionadorInfectado(Infectado infectado){
        this.infectadoAsociado = infectado;
    }

    public void chocar(Jugador jugador) {
        if(!infectadoAsociado.estaInofensivo()){
            jugador.recibirDano(infectadoAsociado.getDano());
            infectadoAsociado.hacerInofensivoTemporalmente();
        }
    }

}
