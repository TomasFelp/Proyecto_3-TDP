package entidades;

import javax.swing.ImageIcon;

public class EntidadGrafica {
	private ImageIcon figura;
	private String imagen;

	public EntidadGrafica(ImageIcon sprite) {
		this.figura = sprite;
	}

	/**
	 * actualiza la imagen con la direccion que recibe como parametro. 
	 * @param im direccion de imagen.
	 */
	public void actualizar(String im) {
		imagen=im;
		ImageIcon imageIcon = new ImageIcon(this.getClass().getResource(imagen));
		this.figura.setImage(imageIcon.getImage());
	}
	
	public ImageIcon getGrafico() {
		return this.figura;
	}
	
	public void setGrafico(ImageIcon grafico) {
		this.figura = grafico;
	}
	
	public String getImagen() {
		return imagen;
	}
	
}
