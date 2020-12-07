package GUI;

//SplashScreen.java
//A simple application to show a title screen in the center of the screen
//for the amount of time given in the constructor.  This class includes
//a sample main() method to test the splash screen, but it's meant for use
//with other applications.
//

import java.awt.*;
import javax.swing.*;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class Screen extends JWindow {
	private int duration;
	private JLabel jLabelTitle;

	public Screen(int d) {
		duration = d;
	}

	public void showSplash() {
		showSplash(GUI.ImageProvider.getInstancia().getSplashScreen(),"Mega Juego");
	}
	
	public void showWin() {
		showSplash(GUI.ImageProvider.getInstancia().getWinScreen(),"You Win!");
	}
	
	public void showLose() {
		showSplash(GUI.ImageProvider.getInstancia().getLoseScreen(),"You lose");
	}
	
	// A simple little method to show a title screen in the center
	// of the screen for the amount of time given in the constructor
	public void showSplash(ImageIcon imagen, String texto) {
		this.setLocationByPlatform(true);
		 JPanel content = (JPanel)getContentPane();
		 content.setBackground(new java.awt.Color(191,191,191));
		 content.setLayout(null);
		 JLabel label = new JLabel(new ImageIcon("oreilly.gif"));
		 JLabel copyrt = new JLabel();
		 copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
		 copyrt.setForeground(new java.awt.Color(165,42,42));
		 copyrt.setText("ponele");
		 content.add(copyrt, "South");

		 // Set the window's bounds, centering the window
		 int width = 915;
		 int height =460;
		 Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		 int x = (screen.width-width)/2;
		 int y = (screen.height-height)/2;
		 this.setBounds(x, y, 915, 460);
		
		 // Build the splash screen

		 {
			 jLabelTitle = new JLabel();
			 content.add(jLabelTitle, "Center");
			 jLabelTitle.setText(texto);
			 jLabelTitle.setFont(new java.awt.Font("Ubuntu",0,72));
			 jLabelTitle.setHorizontalAlignment(SwingConstants.CENTER);
			 jLabelTitle.setForeground(new java.awt.Color(100,0,0));
			 jLabelTitle.setBounds(0, 298, 437, 157);
		 }
		 content.add(label, BorderLayout.WEST);
		 label.setIcon(imagen);
		 label.setBounds(0, 1, 915, 458);
		 copyrt.setBounds(18, 405, 464, 43);

		 // Display it
		 setVisible(true);
		
		 // Wait a little while, maybe while loading resources
		 try { Thread.sleep(duration); } catch (Exception e) {}
		
		 setVisible(false);
		 getContentPane().setBackground(new java.awt.Color(0,0,0));
		 this.setOpacity(0.0f);
		 content.add(copyrt, "South");
		 content.add(label, "West");
	}

	public void showSplashAndExit() {
		showSplash();
		
	}

}
