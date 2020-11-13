package juego;

import cerebros.ComandoPlayer;
import cerebros.GameController;
import entidades.NPC;
import entidades.Player;

public class Juego {
	
//Attributes
	protected GUI_juego interfaz;
	protected Player player;
	protected Nivel nivel;
	protected ComandoPlayer controlesPlayer;
	protected GameController npcController;
	
//Builder
	public Juego(GUI_juego inter) {
		interfaz=inter;
		
		player=new Player();
		player.setVisible(true);
		interfaz.addEntidad(player);
		player.setSize(20,20);		 //tamaño genericos solo para prueba.
		//Coloco el player en el centro del borde inferior
		player.setLocation(interfaz.getAncho()/2-player.getWidth()/2,interfaz.getAlto()-player.getHeight());
		
		controlesPlayer=new ComandoPlayer(player,interfaz.getAncho()-20);		
		interfaz.addKeyListener(controlesPlayer);
		
		npcController = new GameController();
		
	}
//Methods
	public void iniciar() {
		nivel=new Nivel(50,interfaz.getAlto());//<------------------------------------------provisorio
		NPC[] primerOleada=nivel.getPrimerOleada();
		
		//inserto infectados en gameController
		for(int i=0;i<primerOleada.length;i++) {
			npcController.insertarNPC(primerOleada[i]);
			interfaz.addEntidad(primerOleada[i]);
		}
		npcController.start();
		
	}

}
















