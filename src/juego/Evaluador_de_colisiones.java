package juego;

/**
 * Clase con todos los metodos relacionados a revisar las colisioes.
 * (Si en el futuro se ponen ademas otras formas para las colisiones habria que formar una gerarquia de erencias para esta clase)
 * @author Tomás
 *
 */
public class Evaluador_de_colisiones {
	
	
//methods
	/**
	 * Determina se dos zonas de colision circulares estan en contacto
	 * @param za zona de colision 1.
	 * @param zb zona de colision 2.
	 * @return True si estan en contacto, false en caso contrario.
	 */
	public boolean estanEnContacto(ZonaColision za,ZonaColision zb) {
		/*
		 * Dos zonas de colision circulares estan en contacto 
		 * si la suma de sus radios es mayor a la distancia entre sus centros.
		 */
		boolean resp=false;
		int zaCentro,zaRadio,zbCentro,zbRadio,distancia;
		zaCentro=za.getCentro();
		zbCentro=zb.getCentro();
		zaRadio=za.getRadio();
		zbRadio=zb.getRadio();
		
		distancia=Math.abs(zaCentro-zbCentro);
		
		if((zaRadio+zbRadio)>distancia)
			resp=true;
		
		return resp;
	}
}
