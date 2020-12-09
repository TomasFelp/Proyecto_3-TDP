package GUI;

import java.awt.*;
import javax.swing.*;

public class SplashScreen extends JWindow {
	private int duration;
	private JLabel jLabelTitle;
	private JPanel content;

	/**
	 * Crea una nueva SplashScreen que se mostrara un tiempo dado.
	 * 
	 * @param d El tiempo que se mostrará la SplashScreen en pantalla.
	 */
	public SplashScreen(int d) {
		duration = d;
	}

	/**
	 * Crea la SplashScreen que se muestra al principio del juego.
	 */
	public void mostrarPantallaStart() {
		showSplash(GUI.ImageProvider.getInstancia().getSplashScreen(), "Mega Juego");
	}

	/**
	 * Crea la SplashScreen que se muestra al ganar el juego.
	 */
	public void mostrarPantallaGanar() {
		showSplash(GUI.ImageProvider.getInstancia().getWinScreen(), "You Win!");
	}

	/**
	 * Crea la SplashScreen que se muestra al perder el juego.
	 */
	public void mostrarPantallaPerder() {
		showSplash(GUI.ImageProvider.getInstancia().getLoseScreen(), "You lose");
	}

	/**
	 * Muestra una ventana con una imagen y texto dados.
	 * 
	 * @param imagen Imagen que se quiere mostrar en la pantalla.
	 * @param texto  Texto que se quiere mostrar en la pantalla.
	 */
	public void showSplash(ImageIcon imagen, String texto) {
		this.setLocationByPlatform(true);
		content = (JPanel) getContentPane();
		content.setBackground(new java.awt.Color(191, 191, 191));
		content.setLayout(null);
		JLabel label = new JLabel(new ImageIcon("oreilly.gif"));
		JLabel copyrt = new JLabel();
		copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
		copyrt.setForeground(new java.awt.Color(165, 42, 42));
		content.add(copyrt, "South");

		int width = 915;
		int height = 460;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width - width) / 2;
		int y = (screen.height - height) / 2;
		this.setBounds(x, y, 915, 460);

		jLabelTitle = new JLabel();
		content.add(jLabelTitle, "Center");
		jLabelTitle.setText(texto);
		jLabelTitle.setFont(new java.awt.Font("Ubuntu", 0, 72));
		jLabelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelTitle.setForeground(new java.awt.Color(100, 0, 0));
		jLabelTitle.setBounds(0, 298, 437, 157);

		content.add(label, BorderLayout.WEST);
		label.setIcon(imagen);
		label.setBounds(0, 1, 915, 458);
		copyrt.setBounds(18, 405, 464, 43);

		setVisible(true);

		try {
			Thread.sleep(duration);
		} catch (Exception e) {
			e.printStackTrace();
		}

		setVisible(false);
		getContentPane().setBackground(new java.awt.Color(0, 0, 0));
		this.setOpacity(0.0f);
		content.add(copyrt, "South");
		content.add(label, "West");
	}
}
