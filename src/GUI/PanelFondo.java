package GUI;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
 
/**
*Panel con imagen de fondo perzonalizada.
*/
 
public class PanelFondo extends JPanel {
 
public PanelFondo() {
	super();
}
 
@Override
public void paintComponent(Graphics g) {
	Dimension tam = getSize();
	ImageIcon imagen = ImageProvider.getInstancia().getSpriteFondo();
	g.drawImage(imagen.getImage(), 0, 0, tam.width, tam.height, null);
	setOpaque(false);
	super.paintComponent(g);
}
 
}