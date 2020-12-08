package juego;



import GUI.GUI_juego;

public class Main {
		
	public static void main(String[] args) {
		
		GUI_juego Gjuego=new GUI_juego();
	
		Juego juego=new Juego(Gjuego);
		juego.empezarJuego();
	
	}

}


