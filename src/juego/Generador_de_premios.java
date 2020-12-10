package juego;

import java.util.Random;

import Premios.Cuarentena;
import Premios.MovimientoPremio;
import Premios.MovimientoPremioResbaloso;
import Premios.Pocion_vida;
import Premios.Premio;
import Premios.Super_arma;
import Premios.Super_arma_perforadora;

/**
 * Guarda una coleccionde premios y retorna una instancia de uno seleccionada aleatoriamente.
 *
 */
public class Generador_de_premios {

//Attributes
	protected Premio[] premios;
	protected static Generador_de_premios instancia;
	
//Builder
	private Generador_de_premios() {
		premios=new Premio[4];
		premios[0]=new Super_arma();
		premios[1]=new Super_arma_perforadora();
		premios[2]=new Pocion_vida();
		premios[3]=new Cuarentena();
	}
	
//Methods
	/**
	 * Devuelve un premio aleatorio
	 * @return premio aleatorio.
	 */
	public Premio getPremio() {
		Random r=new Random();
		//Premio res = premios[r.nextInt(premios.length)].clone();
		Premio res = premios[1].clone();
		
		if(r.nextInt(4) == 0)
			res.setMovimiento(new MovimientoPremioResbaloso());
		
		return res;
	}
	
	/**
	 * Devuelve una instaancia de Generador de premios
	 * @return instancia de Generador_de_premios
	 */
	public static Generador_de_premios getInstancia() {
		
		if(instancia==null)
			instancia=new Generador_de_premios();
		
		return instancia;
	}
	
}
