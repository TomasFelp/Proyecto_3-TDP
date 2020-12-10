package Colisionadores;

import Premios.Premio;
import arma.Proyectil;
import arma.Proyectil_sanitario;

public abstract class ColisionadorProyectil implements Colisionador{

    protected Proyectil proyectilAsociado;
    protected int dano;

    public ColisionadorProyectil(Proyectil proyectil){
        this.proyectilAsociado = proyectil;
        dano = proyectil.getDano();
    }

}
