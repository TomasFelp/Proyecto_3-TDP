package juego;
import GUI.ImageProvider;
import entidades.*;

public class Nivel {
//Attributes
	int tam_primer_oleada;
	protected InfectadoBase[] primerOleada;
	
//Builder
	public Nivel(int t1) {
			tam_primer_oleada=t1;
			primerOleada=new InfectadoBase[tam_primer_oleada];
			
			for(int i=0;i<tam_primer_oleada;i++) {
				primerOleada[i]=new InfectadoBase(ImageProvider.getInstancia().getSpriteEnemigoAlfa());
				primerOleada[i].setVisible(true);
			}
	}
	
//Methods
	public InfectadoBase[] getPrimerOleada() {
		return primerOleada;
	}
}
