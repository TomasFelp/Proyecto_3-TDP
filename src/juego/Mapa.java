package juego;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

import cerebros.GameController;
import entidades.*;
import infectado.Infectado;

public class Mapa extends JPanel {
	
	private Player player;
	private Nivel nivel;
	/**
	 * Create the panel.
	 */
	public Mapa() {
		super(); //branch nueva
		
		//GameController.getInstancia().setMapa(this);
		
		player= new Player();
		
		//configuro el panel general
		this.setOpaque(true);
		this.setBackground(Color.RED);
		this.setLayout(null);
		
		
		/*

		 * Inserto los infectados y el player con las cordenadas absolutas.
		 * Lo hice asi porque si ponia los infectados en el panel peincipal los superponia todos por el layout y 
		 * si los ponia en su porpio panel desaparecian cuando llegaban al panel del player.
		 * 
		 * Yo creo que lo mas conveniente seria hacer que el jframe sea de un tamaño fijo y respecto de ese tamaño acamodar todas las cordenadas absolutas.
		 * 
		 * 
		 */
		//Coloco el player
		this.add(player);
		player.setSize(20,20);		 // Cordenadas y tamaño genericos solo para prueba.
		player.setLocation(230,530);//
	}
	
	public Player getPlayer() {
		return player;
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













