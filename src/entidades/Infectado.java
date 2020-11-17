package entidades;

import colisiones.ZonaColision;
import juego.Vector;

public abstract class Infectado extends Personaje{

    protected int recorrido;

    public Infectado(Vector posicion, int r){
        super(posicion);
        cargaViral = 100;
        recorrido = r;
    }

    public void PropagarVirus(){

    }

    @Override
    public void update() {
        int x = this.getLocation().x;
        int y = this.getLocation().y;

        this.setLocation(x + velocidad.x, y + velocidad.y);
    }

    //TODO: ver si funciona sin redefinirlo de Entidad
    public ZonaColision getZonaColision() {
        int centroX = (int) (this.getLocation().x - (this.getSize().getWidth()) / 2);
        int centroY = (int) (this.getLocation().y - (this.getSize().getHeight()) / 2);
        int radio = (int) (this.getSize().getHeight() / 2);
        return new ZonaColision(centroX, centroY, radio);
    }
}
