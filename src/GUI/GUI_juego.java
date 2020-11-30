package GUI;

import java.awt.*;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class GUI_juego extends JFrame {

	private JPanel contentPane;
	private JPanel panelEntidades;
	private JPanel panelInformacion;
	private JPanel panelVida;
	private JLabel [] vida;
	private static int alto=600;
	private static int ancho=500;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_juego frame = new GUI_juego();
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
	public GUI_juego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, ancho, alto);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		armarInterfaz();
	}
	
	private void armarInterfaz(){
		
		armarPanelEntidades();
		
		armarPanelInformacion();

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}
	
	private void armarPanelInformacion() {
		panelInformacion=new JPanel();
		contentPane.add(panelInformacion,BorderLayout.NORTH);
		panelInformacion.setLayout(new GridLayout(1,3));
		panelInformacion.setBackground(Color.orange);
		panelInformacion.setVisible(true);
				
		
		panelVida=new JPanel();
		
		panelInformacion.add(new JLabel("lugar libre"));
		panelInformacion.add(new JLabel("-------MEGA JUEGO-------"),BorderLayout.EAST);
		panelInformacion.add(panelVida);
		
		panelVida.setBackground(Color.BLUE);
		
		panelVida.setLayout(new GridLayout(1,5));
		
		vida=new JLabel[10];
		
		for(int i=0;i<vida.length;i++) {
			vida[i]=new JLabel();
			vida[i].setBackground(Color.green);
			vida[i].setOpaque(true);
			vida[i].setVisible(true);
			vida[i].setBorder(BorderFactory.createLineBorder(Color.black));
			panelVida.add(vida[i]);
		}
		
	}

	/**
	 * Arma el panel en el cual se desplazaran las entidades del juego
	 */
	private void armarPanelEntidades() {
		panelEntidades= new PanelFondo();
		panelEntidades.setOpaque(true);
		panelEntidades.setBackground(Color.RED);
		panelEntidades.setLayout(null);
		contentPane.add(panelEntidades,BorderLayout.CENTER);
		
		
	}
	
	/**
	 * Añade una entidad al panel de entidades.
	 * @param entidad a agregar al panel.
	 */
	public void addEntidad(JLabel entidad) {
		panelEntidades.add(entidad);
	}
	
	public void removeEntidad(JLabel entidad) {
		panelEntidades.remove(entidad);
	}
	
	public int getAncho() {
		return panelEntidades.getWidth();
	}
	
	public int getAlto() {
		return panelEntidades.getHeight();
	}
	
	public JLabel mostrarCartel(String msj) {
		
		JLabel mensaje=new JLabel(msj);
		mensaje.setFont(new Font("Tahoma", Font.PLAIN, 20));

		mensaje.setSize(300,50);
		mensaje.setLocation(panelEntidades.getWidth()/2-mensaje.getWidth()/2,panelEntidades.getHeight()/2-mensaje.getHeight()/2);
		panelEntidades.add(mensaje);
		
		return mensaje;
	}
	
	
	public void decrementarVida(int x) {
		int v=(x*vida.length)/500;
		
		for(int i=vida.length-1;i>=v && i>=0;i--) {
			vida[i].setBackground(Color.red);
		}
		
		for(int i=0;i<vida.length && i<v;i++) {
			vida[i].setBackground(Color.green);
		}
		
	}
}
