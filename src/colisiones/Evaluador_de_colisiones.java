package colisiones;

/**
 * Clase con todos los metodos relacionados a revisar las colisioes. (Si en el
 * futuro se ponen ademas otras formas para las colisiones habria que formar una
 * gerarquia de erencias para esta clase)
 * 
 * @author Tomás
 *
 */
abstract public class Evaluador_de_colisiones {
    /**
     * Determina se dos zonas de colision circulares estan en contacto
     * 
     * @param za zona de colision 1.
     * @param zb zona de colision 2.
     * @return True si estan en contacto, false en caso contrario.
     */
    static public boolean estanEnContacto(ZonaColision za, ZonaColision zb) {
        double distancia = distanciaCentros(za, zb);

        /*
         * Dos zonas de colision circulares estan en contacto si la suma de sus radios
         * es menor a la distancia entre sus centros.
         */
        return (za.getRadio() + zb.getRadio()) > distancia;
    }

    /**
     * Calcula la distancia entre los centros de dos zonas de colision.
     */
    static private double distanciaCentros(ZonaColision za, ZonaColision zb) {
        double distanciaX = Math.abs(za.getCentroX() - zb.getCentroX());
        double distanciaY = Math.abs(za.getCentroY() - zb.getCentroY());

        return Math.sqrt(Math.pow(distanciaX, 2) + Math.pow(distanciaY, 2));
    }
}
