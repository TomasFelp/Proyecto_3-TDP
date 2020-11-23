package juego;

import java.util.Random;

import Premios.Pocion_vida;
import Premios.Premio;
import Premios.Super_arma;
import Premios.Super_arma_perforadora;

public class Generador_de_premios {

//Attributes
	protected Premio[] premios;
	protected static Generador_de_premios instancia;
	
//Builder
	private Generador_de_premios() {
		premios=new Premio[3];
		premios[0]=new Super_arma();
		premios[1]=new Super_arma_perforadora();
		premios[2]=new Pocion_vida();
	}
	
//Methods
	/**
	 * Devuelve un premio aleatorio
	 * @return premio aleatorio.
	 */
	public Premio getPremio() {
		Random r=new Random();
		return premios[r.nextInt(premios.length)].clone();
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
