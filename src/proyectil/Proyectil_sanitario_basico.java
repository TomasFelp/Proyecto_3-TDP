package proyectil;

import java.awt.Point;

import GUI.ImageProvider;
import colisiones.ZonaColision;
import entidades.EntidadGrafica;

public class Proyectil_sanitario_basico extends Proyectil_sanitario {

    public Proyectil_sanitario_basico(Point origen) {
        damage = 100;
        grafico = new EntidadGrafica(ImageProvider.getInstancia().getSpriteProyectilSantiarioBasico());
        this.setIcon(grafico.getGrafico());
        this.origen = origen;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public ZonaColision getZonaColision() {
        int centroX = (int) (this.getLocation().x - (this.getSize().getWidth()) / 2);
        int centroY = (int) (this.getLocation().y - (this.getSize().getHeight()) / 2);
        int radio = (int) (this.getSize().getHeight() / 2);
        return new ZonaColision(centroX, centroY, radio);
    }

}
