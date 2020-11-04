package GUI;

import java.net.URL;

import javax.swing.ImageIcon;

public class ImageProvider {
    private ImageIcon spriteEnemigoAlfa;
    private ImageIcon spriteEnemigoBeta;
    private ImageIcon spritePlayer;
    private static ImageProvider instancia;

    private ImageProvider() {
        loadSpritePlayer();
        loadSpriteEnemigoAlfa();
        loadSpriteEnemigoBeta();
    }

    public static ImageProvider getInstancia(){
        if(instancia == null)
            instancia = new ImageProvider();

        return instancia;
    }

    private void loadSpriteEnemigoAlfa() {
        URL path = getClass().getResource("/SpritesInfectados/InfectadoAlfa.png");
        spriteEnemigoAlfa = new ImageIcon(path);
    }

    private void loadSpriteEnemigoBeta() {
        URL path = getClass().getResource("/SpritesInfectados/InfectadoAlfa.png");
        spriteEnemigoBeta = new ImageIcon(path);
    }

    private void loadSpritePlayer() {
        URL path = getClass().getResource("/ImagenesPlayer/player.png");
        spritePlayer = new ImageIcon(path);
    }

    public ImageIcon getSpritePlayer() {
        return spritePlayer;
    }

    public ImageIcon getSpriteEnemigoAlfa() {
        return spriteEnemigoAlfa;
    }

    public ImageIcon getSpriteEnemigoBeta() {
        return spriteEnemigoBeta;
    }
}
