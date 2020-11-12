package juego;

import java.util.Random;

import entidades.*;
import infectado.Infectado;
import infectado.InfectadoAlfa;

public class Nivel {
	int sizeOleada;
	protected Infectado[] primerOleada;

	public Nivel(int sOleada, int altoRecorrido) {
		this.sizeOleada = sOleada;
		primerOleada = new Infectado[sizeOleada];
		Random r = new Random();
		for (int i = 0; i < sizeOleada; i++) {
			//Para que no esten todos en la misma fila
			int y = r.nextInt(15) * -20;
			//Ajustar valores para que no se salga de la pantalla (20
			int x = r.nextInt(25) * 20;
										// porque es el tamaño de lavel provisorio que defini en el )
			primerOleada[i] = new InfectadoAlfa(new Vector(x, y),altoRecorrido);
			primerOleada[i].setVisible(true);
			primerOleada[i].setSize(20,20);;
		}
	}

	public Infectado[] getPrimerOleada() {
		return primerOleada;
	}
}
