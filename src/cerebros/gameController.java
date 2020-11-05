package cerebros;

import java.util.HashMap;
import java.util.Map.Entry;

import entidades.NPC;
import juego.Mapa;

public class gameController extends Thread{
//Attributes
	private Mapa mapa;
	private HashMap<Integer,NPC> entidades;
	private int sleepTime;
	
//Builder
	public gameController(Mapa m) {
		mapa=m;
		entidades=new HashMap<Integer, NPC>();
		sleepTime=50;
	}
	
//Methods
	
	/**
	 * Agrega un NPC al hilo.
	 * @param entidad NPC a agregar
	 */
	public void insertarNPC(NPC entidad) {
		entidades.putIfAbsent(entidad.getID(),entidad);
		actualizarSleepTime();
	}
	
	/**
	 * Agrega una coleccion de entidades al hilo.
	 * @param ent coleccion a agregar.
	 */
	public void insertarColeccionNPC(NPC [] ent) {
		for(int i=0;i<ent.length;i++) {
			entidades.put(ent[i].getID(),ent[i]);
		}
		actualizarSleepTime();
	}
	
	/**
	 * Permite regular la velocidad del tiempo de sleep del run, para que sin importar la cantidad de NPC se desplacen a la misma velocidad.
	 * 
	 * (Mejoro pero no es constante, hay que perfeccionarlo.)
	 */
	private void actualizarSleepTime(){
		sleepTime=50/entidades.size();
	}
	
	public void run() {
		try {
			
			while(!entidades.isEmpty()) {
				
				for (Entry<Integer, NPC> entry : entidades.entrySet()) {
					this.sleep(sleepTime);
					NPC npcActual= entry.getValue();
				    npcActual.update(mapa);
				    if(npcActual.itsAlive()==false)
				    	entidades.remove(npcActual.getID());
				    	
				}
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}









