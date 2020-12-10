package infectado;

import java.util.List;

import entidades.Colisionador;
import entidades.Entidad;
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

	private int daño = 35;

	public InfectadoAlfa(Vector posicion) {
		super(posicion);
		this.setIcon(GUI.ImageProvider.getInstancia().getSpriteInfectadoAlfa());
		this.setVisible(true);
		velocidadDefault = 1;
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

	// Metodos patron visitor

	public void chocarConJugador(Jugador jugador) {

		if (inofensivo == false) {
			jugador.recibirDano(daño);
			hacerInofensivo(SEGUNDOS_INOFENSIVO);
		}
	}

	public void chocarConInfectado(Infectado infectado) {
		// No hacer nada
	}

	public void aceptarColision(Colisionador colisionador) {
		colisionador.chocarConInfectado(this);
	}

}
