package GUI;

import java.net.URL;

import javax.swing.ImageIcon;

/**
 * Se encarga de cargar y proveer los sprites que usan las entidades graficas.
 */
public class ImageProvider {
    private ImageIcon spriteEnemigoAlfa;
    private ImageIcon spriteEnemigoBeta;
    private ImageIcon spritePlayer;

    public ImageProvider() {
        loadSpritePlayer();
        loadSpriteEnemigoAlfa();
        loadSpriteEnemigoBeta();
    }

    private void loadSpriteEnemigoAlfa() {
        URL path = getClass().getResource("/ImagenesPlayer/player.png");
        spriteEnemigoAlfa = new ImageIcon(path);
    }

    private void loadSpriteEnemigoBeta() {
        URL path = getClass().getResource("/ImagenesPlayer/player.png");
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
