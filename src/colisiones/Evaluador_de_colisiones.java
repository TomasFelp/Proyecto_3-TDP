package colisiones;

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
		int zaRadio,zbRadio;
		float distancia;
		
		zaRadio=za.getRadio();
		zbRadio=zb.getRadio();
		
		distancia=distanciaCentros(za,zb);
		
		if((zaRadio+zbRadio)>distancia)
			resp=true;
		
		return resp;
	}
	
	private float distanciaCentros(ZonaColision za,ZonaColision zb) {
		float resp=0;
		int zaCentroX,zbCentroX,zaCentroY,zbCentroY;
		zaCentroX=za.getCentroX();
		zbCentroX=zb.getCentroX();
		zaCentroY=za.getCentroY();
		zbCentroY=zb.getCentroY();
		
		resp=(float) Math.sqrt(Math.pow((zaCentroX-zbCentroX),2)+Math.pow((zaCentroY-zbCentroY),2));
		
		return resp;
	}
}














