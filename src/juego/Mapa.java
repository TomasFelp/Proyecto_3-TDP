package juego;

import java.awt.Color;

import javax.swing.JPanel;

import cerebros.GameController;
import entidades.*;

public class Mapa extends JPanel {
	
	private Jugador jugador;
	private Nivel nivel;
	/**
	 * Create the panel.
	 */
	public Mapa() {
		super(); //branch nueva
		
		GameController.getInstancia().setMapa(this);
		
		jugador = new Jugador();
		
		//configuro el panel general
		this.setOpaque(true);
		this.setBackground(Color.RED);
		this.setLayout(null);
		
		
		/*

		 * Inserto los infectados y el jugador con las cordenadas absolutas.
		 * Lo hice asi porque si ponia los infectados en el panel peincipal los superponia todos por el layout y 
		 * si los ponia en su porpio panel desaparecian cuando llegaban al panel del jugador.
		 * 
		 * Yo creo que lo mas conveniente seria hacer que el jframe sea de un tamaño fijo y respecto de ese tamaño acamodar todas las cordenadas absolutas.
		 * 
		 * 
		 */
		//Coloco el jugador
		this.add(jugador);
		jugador.setSize(20,20);		 // Cordenadas y tamaño genericos solo para prueba.
		jugador.setLocation(230,530);//
	}
	
	public Jugador getJugador() {
		return jugador;
	}
	
	public void ArmarNivel(Nivel n) {
		//Dividi insertarInfectados, porque sino los infectados
		// se creaban antes que el gameController y el mapa
		nivel = n;
		insertarInfectados();
	}
	
	private void insertarInfectados() {
		Infectado[] infectados=nivel.getPrimerOleada();
		Infectado infectadoActual;
		
		for(int i=0;i<infectados.length;i++) {
			infectadoActual=infectados[i];
			infectadoActual.setSize(20,20);
			this.add(infectadoActual);
			infectados[i].setLocation(infectadoActual.getX(), infectadoActual.getY());
		}
	}
}













