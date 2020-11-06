package juego;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import entidades.*;
import cerebros.*;

public class JFrameJuego extends JFrame {

	private JPanel contentPane;
	private Mapa mapa;
	private static int alto=600;
	private static int ancho=500;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameJuego frame = new JFrameJuego();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameJuego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, ancho, alto);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		armarJuego();
	}
	
	private void armarJuego(){
		mapa=new Mapa();
		
		GameController npcController= GameController.getInstancia();
		npcController.setMapa(mapa);

		Nivel nivel1=new Nivel(50, this.getWidth());
		mapa.ArmarNivel(nivel1);
		contentPane.add(mapa);
		
		ComandoPlayer controlesPlayer=new ComandoPlayer(mapa.getPlayer(),this);		
		this.addKeyListener(controlesPlayer);
		
		
		npcController.insertarColeccionNPC(nivel1.primerOleada);
		npcController.start();

	}
	
	public int getAncho() {
		return ancho;
	}
	
	public int getAlto() {
		return alto;
	}
}










