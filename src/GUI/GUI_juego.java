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
	private JLabel[] vida;
	private JLabel etiquetaSuperiorIzquierda;
	private static int alto = 600;
	private static int ancho = 500;

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
		setTitle("Mega Juego by Comision13, Inc");
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width - ancho) / 2;
		int y = (screen.height - alto) / 2;
		setBounds(x, y, ancho, alto);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		armarInterfaz();
	}

	private void armarInterfaz() {

		armarPanelEntidades();

		armarPanelInformacion();

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}

	/**
	 * Arma el panel ubicado en la parte superior del juego, donde se encontraran
	 * los datos de interes para el jugador, tales como el n° de nivel o la carga
	 * viral actual del jugador.
	 */
	private void armarPanelInformacion() {
		panelInformacion = new JPanel();
		contentPane.add(panelInformacion, BorderLayout.NORTH);
		panelInformacion.setLayout(new GridLayout(1, 3));
		panelInformacion.setBackground(Color.orange);
		panelInformacion.setVisible(true);
		etiquetaSuperiorIzquierda = new JLabel();

		panelVida = new JPanel();

		panelInformacion.add(etiquetaSuperiorIzquierda);
		panelInformacion.add(new JLabel("-------MEGA JUEGO-------"), BorderLayout.EAST);
		panelInformacion.add(panelVida);

		panelVida.setBackground(Color.BLUE);

		panelVida.setLayout(new GridLayout(1, 5));

		vida = new JLabel[10];

		for (int i = 0; i < vida.length; i++) {
			vida[i] = new JLabel();
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
		panelEntidades = new PanelFondo();
		panelEntidades.setOpaque(true);
		panelEntidades.setBackground(Color.RED);
		panelEntidades.setLayout(null);
		contentPane.add(panelEntidades, BorderLayout.CENTER);

	}

	/**
	 * Añade una entidad al panel de entidades.
	 * 
	 * @param entidad a agregar al panel.
	 */
	public void addEntidad(JLabel entidad) {
		panelEntidades.add(entidad);
	}

	/**
	 * Remueve una entidad del panel de entidades.
	 * 
	 * @param entidad a remover.
	 */
	public void removeEntidad(JLabel entidad) {
		panelEntidades.remove(entidad);
	}

	/**
	 * Devuelve el ancho del panel destinado a contener las entidades.
	 * 
	 * @return ancho del panel.
	 */
	public int getAncho() {
		return panelEntidades.getWidth();
	}

	/**
	 * Devuelve el alto del panel destinado a contener las entidades.
	 * 
	 * @return alto del panel.
	 */
	public int getAlto() {
		return panelEntidades.getHeight();
	}

	/**
	 * Crea y coloca una etiqueta con el texto recibido por parametro, sobre el
	 * panel de entidades.
	 * 
	 * @param msj Mensaje de la etiqueta.
	 * @return Etiqueta creada.
	 */
	public JLabel mostrarCartel(String msj) {

		JLabel mensaje = new JLabel(msj, 0);
		mensaje.setFont(new Font("Tahoma", Font.PLAIN, 30));
		mensaje.setForeground(Color.white);
		mensaje.setSize(300, 50);
		mensaje.setLocation(panelEntidades.getWidth() / 2 - mensaje.getWidth() / 2,
				panelEntidades.getHeight() / 2 - mensaje.getHeight() / 2);
		panelEntidades.add(mensaje);

		return mensaje;
	}

	/**
	 * Modifica el contenido de la etiqueta superior izquerda, con el texto recibido
	 * por parametro.
	 * 
	 * @param ms nuevo contenido de la etiqueta.
	 */
	public void setCartelSuperiorIzquierdo(String ms) {
		etiquetaSuperiorIzquierda.setText(ms);
	}

	/**
	 * Actualiza la reprecentacion de la carga viral del player
	 * 
	 * @param x carga viral a representar.
	 */
	public void updateBarraVida(float x) {
		int v = (int) Math.ceil(x * vida.length);

		for (int i = vida.length - 1; i >= v && i >= 0; i--) {
			vida[i].setBackground(Color.red);
		}

		for (int i = 0; i < vida.length && i < v; i++) {
			vida[i].setBackground(Color.green);
		}

	}
}
