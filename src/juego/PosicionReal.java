package juego;

/**
 * Modela una posicion en R^2
 */
public class PosicionReal {
	private float x;
	private float y;

	public PosicionReal(float x, float y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Suma las componentes x e y de un vector
	 */
	public void add(Vector v) {
		this.x = x + v.x;
		this.y = y + v.y;
	}
}
