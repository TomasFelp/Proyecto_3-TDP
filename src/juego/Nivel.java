package juego;

import java.util.Random;

import entidades.*;
import infectado.InfectadoAlfa;
import infectado.InfectadoBeta;

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
			if(r.nextInt(3)==1)
				primerOleada[i] = new InfectadoBeta(new Vector(x, y),altoRecorrido);
			 else
				primerOleada[i] = new InfectadoAlfa(new Vector(x, y),altoRecorrido);
			
		}
	}

	public Infectado[] getPrimerOleada() {
		return primerOleada;
	}
}
