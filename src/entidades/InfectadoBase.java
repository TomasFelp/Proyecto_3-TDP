package entidades;

import javax.swing.ImageIcon;

import colisiones.Evaluador_de_colisiones;
import colisiones.ZonaColision;
import juego.JFrameJuego;
import juego.Mapa;

import java.awt.Point;
import java.util.Random;
import java.util.Random;

public class InfectadoBase extends Personaje implements NPC{
	private int posX,posY,ID;

  public InfectadoBase(ImageIcon sprite){
		saludActual=100;
		velocidad=2;
		grafico=new EntidadGrafica(sprite);
		this.setIcon(grafico.getGrafico());

		Random rnd=new Random();

		posY=rnd.nextInt(15)*-20;//<--------------------Para que no esten todos en la misma fila
		posX=rnd.nextInt(25)*20;//<---------------------Ajustar valores para que no se salga de la pantalla (20 porque es el tamaño de lavel provisorio que defini en el mapeo)
	
		ID=rnd.nextInt();
  }
//Methods
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return ID;
	}
	@Override
	public void update(Mapa mapa) {
		// TODO Auto-generated method stub
		Point pos=this.getLocation();
		Player player=mapa.getPlayer();
		int posYPlayer=player.getLocation().y;
		
		if(pos.y>mapa.getHeight()-(posYPlayer+player.getHeight())) {
			//obtengo sus zonas de colision y las comparo
			ZonaColision zonaPlayer,zonaInfectado;
			zonaPlayer=player.getZonaColision();
			zonaInfectado=this.getZonaColision();

			if(Evaluador_de_colisiones.estanEnContacto(zonaPlayer,zonaInfectado)) {
				System.out.println("player muerto");
			}
		}
		if(pos.y>mapa.getHeight()) {
			pos.setLocation(pos.x,0);
		}else {
			pos.setLocation(pos.x,pos.y+this.getVelocidad());
		}
			
		this.setLocation(pos);
		
	}
	@Override
	public boolean itsAlive() {
		// TODO Auto-generated method stub
		return saludActual>0;
	}
}















