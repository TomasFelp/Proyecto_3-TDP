package Colisionadores;

import Premios.Premio;
import arma.Proyectil;
import entidades.Infectado;
import entidades.Jugador;

public class ColisionadorInfectado implements Colisionador{

    protected Infectado infectadoAsociado;

    public ColisionadorInfectado(Infectado infectado){
        this.infectadoAsociado = infectado;
    }

    public void chocar(Jugador jugador) {
        if(!infectadoAsociado.estaInofensivo()){
            System.out.println("El jugador deberia recibir " + infectadoAsociado.getDano() + " de daño.");
            jugador.recibirDano(infectadoAsociado.getDano());
            infectadoAsociado.hacerInofensivoTemporalmente();
        }
    }

    public void chocar(Infectado infectado) {

    }

    public void chocar(Premio premio) {

    }

    public void chocar(Proyectil proyectil) {

    }

}
