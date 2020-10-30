package juego;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class Mapa extends JPanel {
	
	private Player player;
	private JPanel panelPlayer;
	private Nivel nivel;
	private InfectadoBase ib;//<------------------Atributo para testear el comportamiento de los infectados
	/**
	 * Create the panel.
	 */
	public Mapa() {
		super();
		//nivel=new Nivel(5);
		//insertarInfectados();
		player=new Player();
		
		this.setOpaque(true);
		this.setBackground(Color.RED);
		this.setLayout(new BorderLayout());
		
		
		panelPlayer=new JPanel();
		this.add(panelPlayer,BorderLayout.SOUTH);
		panelPlayer.setLayout(new FlowLayout());
		panelPlayer.setBackground(Color.GREEN);
		panelPlayer.setOpaque(false);
		panelPlayer.add(player);
		

		ib=new InfectadoBase();
		this.add(ib);

	}
	
	public Player getPlayer() {
		return player;
	}
	
	/*
	 * --------------------------------------------------------------------
	 */
	//Metodo pra testear el comportamiento de los infectados
	public InfectadoBase getInf() {
		return ib;
	}
	/*
	 * --------------------------------------------------------------------
	 */
	/*
	 */
	/* 
	private void insertarInfectados() {
		InfectadoBase[] infectados=nivel.getPrimerOleada();
		
		for(int i=0;i<infectados.length;i++) {
			//this.add(infectados[i],BorderLayout.SOUTH);
			System.out.println("insertando infectado");
		
		panelPlayer.add(ib);
		ib=new InfectadoBase();
		this.add(ib);
	}
     */
	
}
