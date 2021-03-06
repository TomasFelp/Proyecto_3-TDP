package GUI;

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
    private ImageIcon spriteProyectilSanitarioPerforador;
    private ImageIcon spriteProyectilSanitarioPower;
    private ImageIcon spritePremioProyectilPower;
    private ImageIcon spritePremioProyectilPerforador;
    private ImageIcon spriteProyectilViral;
    private ImageIcon spritePremioPocionVida;
    private ImageIcon spritePremioCuarentena;
    private ImageIcon spriteFondo;
    private ImageIcon splashScreen;
    private ImageIcon winScreen;
    private ImageIcon loseScreen;
    private static ImageProvider instancia;
   

    private ImageProvider() {
        loadSpritePlayer();
        loadSpriteEnemigoAlfa();
        loadSpriteEnemigoBeta();
        loadSpriteProyectilSanitario();
        loadSpriteProyectilViral();
        
        //Cargo sprites de los premios
        loadSpritePremioProyectilPower();
        loadSpritePremioProyectilPerforador();
        loadSpritePremioPocionVida();
        loadSpritePremioCuarentena();
        
        loadSpriteProyectilSanitarioPerforador();
        loadSpriteProyectilSanitarioPower();
        
        loadSplashScreen();
        loadLoseScreen();
        loadWinScreen();
        
        loadSpriteFondo();
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
	
	private void loadSpritePremioProyectilPower() {
        URL path = getClass().getResource("/Premios/ProyectilPower.png");
        spritePremioProyectilPower = new ImageIcon(path);
    }
	
	private void loadSpritePremioProyectilPerforador() {
        URL path = getClass().getResource("/Premios/ProyectilPowerPerforador.png");
        spritePremioProyectilPerforador = new ImageIcon(path);
    }
	
	private void loadSpritePremioPocionVida() {
        URL path = getClass().getResource("/Premios/pocionVida.png");
        spritePremioPocionVida = new ImageIcon(path);
    }
	
	private void loadSpritePremioCuarentena() {
        URL path = getClass().getResource("/Premios/cuarentena.png");
        spritePremioCuarentena = new ImageIcon(path);
    }
	
	private void loadSpriteProyectilViral() {
		URL path = getClass().getResource("/Proyectil/ProyectilViral.png");
        spriteProyectilViral = new ImageIcon(path);
    }
	
	private void loadSpriteProyectilSanitarioPerforador() {
        URL path = getClass().getResource("/Proyectil/ProyectilSanitarioPerforador.png");
        spriteProyectilSanitarioPerforador = new ImageIcon(path);
    }
	
	private void loadSpriteProyectilSanitarioPower() {
        URL path = getClass().getResource("/Proyectil/ProyectilSanitarioPower.png");
        spriteProyectilSanitarioPower = new ImageIcon(path);
    }
	
	private void loadSpriteFondo() {
        URL path = getClass().getResource("/escenario/fondo.png");
        spriteFondo = new ImageIcon(path);
    }
	
	private void loadSplashScreen() {
        URL path = getClass().getResource("/Screens/ImagenInicio.png");
        splashScreen = new ImageIcon(path);
    }
	
	private void loadWinScreen() {
        URL path = getClass().getResource("/Screens/win.png");
        winScreen = new ImageIcon(path);
    }
	
	private void loadLoseScreen() {
        URL path = getClass().getResource("/Screens/lose.png");
        loseScreen = new ImageIcon(path);
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
    
    public ImageIcon getSpriteProyectilSanitarioPower(){
        return spriteProyectilSanitarioPower;
    }
    
    public ImageIcon getSpriteProyectilSanitarioPerforador(){
        return spriteProyectilSanitarioPerforador;
    }
    
    
    public ImageIcon getSpritePremioSuperArma() {
        return spritePremioProyectilPower;
    }
    
    public ImageIcon getSpritePremioSuperArmaPerforadora() {
        return spritePremioProyectilPerforador;
    }
    
    public ImageIcon getSpritePremioPocionVida() {
        return spritePremioPocionVida;
    }
    
    public ImageIcon getSpritePremioCuarentena() {
        return spritePremioCuarentena;
    }
    
    public ImageIcon getSpriteProyectilViral(){
        return spriteProyectilViral;
    }
    
    public ImageIcon getSpriteFondo(){
        return spriteFondo;
    }
    
    public ImageIcon getSplashScreen(){
        return splashScreen;
    }
    
    public ImageIcon getWinScreen(){
        return winScreen;
    }
    
    public ImageIcon getLoseScreen(){
        return loseScreen;
    }
    
}


















