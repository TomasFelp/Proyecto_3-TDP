package juego;

import java.net.URL;

import javax.swing.ImageIcon;

/**
 * Modela un singleton que se encarga de cargar las imagenes necesarias para el
 * juego, y provee metodos para acceder a ellas.
 */
public class ImageProvider {
    private ImageIcon spriteEnemigoAlfa;
    private ImageIcon spriteEnemigoBeta;
    private ImageIcon spritePlayer;
    private ImageIcon spriteProyectilSanitario;
    private static ImageProvider instancia;

    private ImageProvider() {
        loadSpritePlayer();
        loadSpriteEnemigoAlfa();
        loadSpriteEnemigoBeta();
        loadSpriteProyectilSanitario();
    }

    /**
     * Devuelve la instancia del ImageProvider.
     */
    public static ImageProvider getInstancia() {
        if (instancia == null)
            instancia = new ImageProvider();

        return instancia;
    }

    private void loadSpriteEnemigoAlfa() {
        URL path = getClass().getResource("/SpritesInfectados/InfectadoAlfa.png");
        spriteEnemigoAlfa = new ImageIcon(path);
    }

    private void loadSpriteEnemigoBeta() {
        URL path = getClass().getResource("/SpritesInfectados/InfectadoBeta.png");
        spriteEnemigoBeta = new ImageIcon(path);
    }

    private void loadSpritePlayer() {
        URL path = getClass().getResource("/ImagenesPlayer/player.png");
        spritePlayer = new ImageIcon(path);
    }
    
	private void loadSpriteProyectilSanitario() {
        URL path = getClass().getResource("/Proyectil/ProyectilSanitario.png");
        spriteProyectilSanitario = new ImageIcon(path);
    }

    /**
     * Devuelve la sprite asignada al jugador
     */
    public ImageIcon getSpritePlayer() {
        return spritePlayer;
    }
    /**
     * Devuelve la sprite asignada al enemigo alfa.
     */
    public ImageIcon getSpriteInfectadoAlfa() {
        return spriteEnemigoAlfa;
    }

    public ImageIcon getSpriteInfectadoBeta() {
        return spriteEnemigoBeta;
    }

    public ImageIcon getSpriteProyectilSanitario(){
        return spriteProyectilSanitario;
    }
}
