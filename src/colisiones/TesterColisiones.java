package colisiones;

import static org.junit.Assert.*;

import org.junit.*;

public class TesterColisiones {
    @Test
    public void colision_a_distancia_radio10() {
        ZonaColision zona1 = new ZonaColision(0, 0, 10);
        ZonaColision zona2 = new ZonaColision(0, 5, 10);
        boolean colision = Evaluador_de_colisiones.estanEnContacto(zona1, zona2);
        assertTrue(colision);
    }

    @Test
    public void colision_en_mismo_punto_radio10() {
        ZonaColision zona1 = new ZonaColision(0, 0, 10);
        ZonaColision zona2 = new ZonaColision(0, 0, 10);
        boolean colision = Evaluador_de_colisiones.estanEnContacto(zona1, zona2);
        assertTrue(colision);
    }

    @Test
    public void no_colision_a_distancia_radio0() {
        ZonaColision zona1 = new ZonaColision(0, 11, 0);
        ZonaColision zona2 = new ZonaColision(0, 0, 0);
        boolean colision = Evaluador_de_colisiones.estanEnContacto(zona1, zona2);
        assertFalse(colision);
    }

    @Test
    public void no_colision_a_distancia_radio10() {
        ZonaColision zona1 = new ZonaColision(0, 22, 10);
        ZonaColision zona2 = new ZonaColision(0, 0, 10);
        boolean colision = Evaluador_de_colisiones.estanEnContacto(zona1, zona2);
        assertFalse(colision);
    }
}
