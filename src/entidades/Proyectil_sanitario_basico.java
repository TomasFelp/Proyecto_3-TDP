package entidades;

import java.awt.Point;

import colisiones.ZonaColision;

public class Proyectil_sanitario_basico extends Proyectil_sanitario{

//Attributes
	
//Builder
	public Proyectil_sanitario_basico(Point origen) {
		damage=100;
		grafico=new EntidadGrafica("/ImagenesProyectiles/Proyectil_sanitario_basico.png");
		this.setIcon(grafico.getGrafico());
		this.origen=origen;
	}
	
//Methods
	public int getDamage() {
		// TODO Auto-generated method stub
		return damage;
	}

	@Override
	public ZonaColision getZonaColision() {
		int centroX=(int) (this.getLocation().x-(this.getSize().getWidth())/2);
		int centroY=(int) (this.getLocation().y-(this.getSize().getHeight())/2);
		int radio=(int)(this.getSize().getHeight()/2);
		return new ZonaColision(centroX,centroY,radio);
	}

}
