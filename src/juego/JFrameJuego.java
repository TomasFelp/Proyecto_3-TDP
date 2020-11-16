package juego;

import cerebros.ComandoPlayer;
import cerebros.GameController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

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
	}
	
	public int getAncho() {
		return ancho;
	}
	
	public int getAlto() {
		return alto;
	}
}










