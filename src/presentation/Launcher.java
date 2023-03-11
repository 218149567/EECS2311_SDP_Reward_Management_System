package presentation;

import java.awt.EventQueue;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

public class Launcher {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				//Add The Flat Light Look and Feel 
				try {
				    UIManager.setLookAndFeel( new FlatLightLaf() );
				} catch( Exception ex ) {
				    System.err.println( "Failed to initialize LaF" );
				}
				
				//Launch application
				try {
					MainFrame mainFrame = new MainFrame();
					mainFrame.initialize();
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
