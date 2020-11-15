package juego;

import cerebros.ComandoPlayer;
import cerebros.GameController;
import entidades.Infectado;
import entidades.Jugador;

public class Juego {
	
//Attributes
	protected GUI_juego interfaz;
	protected Jugador jugador;
	protected Nivel nivel;
	protected ComandoPlayer controlesPlayer;
	protected GameController npcController;
	
//Builder
	public Juego(GUI_juego inter) {
		interfaz=inter;
		
		jugador =new Jugador();
		jugador.setVisible(true);
		interfaz.addEntidad(jugador);
		jugador.setSize(20,20);		 //tamaño genericos solo para prueba.
		//Coloco el jugador en el centro del borde inferior
		jugador.setLocation(interfaz.getAncho()/2- jugador.getWidth()/2,interfaz.getAlto()- jugador.getHeight());
		
		controlesPlayer=new ComandoPlayer(jugador,interfaz.getAncho()-20);
		interfaz.addKeyListener(controlesPlayer);
		
		npcController = new GameController();
		
	}
//Methods
	public void iniciar() {
		nivel=new Nivel(50,interfaz.getAlto());//<------------------------------------------provisorio
		Infectado[] primerOleada=nivel.getPrimerOleada();
		
		//inserto infectados en gameController
		for(int i=0;i<primerOleada.length;i++) {
			npcController.insertarInfectado(primerOleada[i]);
			interfaz.addEntidad(primerOleada[i]);
		}
		npcController.start();
		
	}

}
















