package juego;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class GUI_juego extends JFrame {

	private JPanel contentPane;
	private JPanel panelEntidades;
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
		
		

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}

	/**
	 * Arma el panel en el cual se desplazaran las entidades del juego
	 */
	private void armarPanelEntidades() {
		panelEntidades= new JPanel();
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
}
