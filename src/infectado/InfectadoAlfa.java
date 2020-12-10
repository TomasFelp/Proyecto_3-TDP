package infectado;

import Colisionadores.Colisionador;
import Colisionadores.ColisionadorInfectado;
import entidades.Infectado;
import entidades.Jugador;
import juego.*;

/**
 *
 * Modela un infectado tipo Alfa, tiene una resistencia moderada al igual que el
 * daño que ocasiona. Ademas al poseer una carga viral critica duplica su
 * velocidad.
 *
 */
public class InfectadoAlfa extends Infectado {

	private final int DANO_INFECTADO_ALFA = 35;

	public InfectadoAlfa(Vector posicion) {
		super(posicion);
		this.dano = DANO_INFECTADO_ALFA;
		this.setIcon(GUI.ImageProvider.getInstancia().getSpriteInfectadoAlfa());
		this.setVisible(true);
		velocidadDefault = 1;
		this.colisionador = new ColisionadorInfectado(this);
	}

	@Override
	public void recibirDano(int dano) {
		if (cargaViral - dano > 0) {
			this.cargaViral -= dano; // recibe el dano
			if (cargaViral < 50) { // Si el infectado alfa tiene un nivel de vida critico duplica su velocidad
				movimientoAnterior = new MovimientoInfectadoAlfaEnojado();
				if (!ralentizado)
					setMovimiento(movimientoAnterior);
			}
		} else {
			// morido
			this.declararRecuperado();
		}
	}

	public void recibirColision(Colisionador colisionador) {
		colisionador.chocar(this);
	}

}
