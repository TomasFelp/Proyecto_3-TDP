package juego;

import java.awt.Color;

import javax.swing.JPanel;

import cerebros.GameController;
import entidades.*;

public class Mapa extends JPanel {

	private Nivel nivel;
	/**
	 * Create the panel.
	 */
	public Mapa() {
		super(); //branch nueva
		
		GameController.getInstancia().setMapa(this);
		
		//configuro el panel general
		this.setOpaque(true);
		this.setBackground(Color.RED);
		this.setLayout(null);
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













