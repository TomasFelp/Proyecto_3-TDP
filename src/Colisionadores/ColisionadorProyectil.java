package Colisionadores;

import Premios.Premio;
import arma.Proyectil;
import arma.Proyectil_sanitario;

public abstract class ColisionadorProyectil extends ColisionadorBase{

    protected Proyectil proyectilAsociado;
    protected int dano;

    public ColisionadorProyectil(Proyectil proyectil){
        this.proyectilAsociado = proyectil;
        dano = proyectil.getDano();
    }

}
