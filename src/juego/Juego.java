package juego;

import javax.swing.JLabel;

import arma.Proyectil_sanitario;
import cerebros.ComandoPlayer;
import cerebros.GameController;
import colisiones.CollisionManager;
import entidades.Entidad;
import entidades.Infectado;
import entidades.Jugador;
import infectado.InfectadoAlfa;

public class Juego implements Mediator{
	
//Attributes
	protected GUI_juego interfaz;
	protected Jugador jugador;
	protected Nivel nivel;
	protected ComandoPlayer controlesPlayer;
	protected GameController npcController;
	protected CollisionManager colManager;
	
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
		controlesPlayer.setJuego(this);
		interfaz.addKeyListener(controlesPlayer);

		npcController = GameController.getInstancia();

		colManager=new CollisionManager();
		colManager.putEntidadVerificable(jugador);
		npcController.setCollisionManager(colManager);
	}

//Methods
	public void iniciar() {
		nivel=new Nivel(50,interfaz.getAlto());//<------------------------------------------provisorio
		Infectado[] primerOleada=nivel.getPrimerOleada();

		//inserto infectados en gameController
		for(int i=0;i<primerOleada.length;i++) {
			primerOleada[i].setMediador(this);
			addEntidadSecundaria(primerOleada[i]);
		}
		npcController.start();
	}

	public Jugador getJugador(){
		return jugador;
	}
	
	@Override
	public void addEntidad(Entidad entidad) {
		addGeneral(entidad);
		colManager.putEntidadVerificable(entidad);
	}
	
	@Override
	public void addEntidadSecundaria(Entidad entidad) {
		addGeneral(entidad);
		colManager.putEntidad(entidad);
	}
	
	public void addGeneral(Entidad entidad) {
		npcController.insertarEntidad(entidad);
		interfaz.addEntidad(entidad);
	}
	
	@Override
	public void removeEntidad(Entidad entidad) {
		removeGeneral(entidad);
		colManager.removeEntidadVerificable(entidad);
	}
	
	@Override
	public void removeEntidadSecundaria(Entidad entidad) {
		removeGeneral(entidad);
		colManager.removeEntidad(entidad);
	}
	
	private void removeGeneral(Entidad entidad){
		npcController.removeEntidad(entidad);
		interfaz.removeEntidad(entidad);
	}

	

}
















