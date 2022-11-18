package presentation;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.Color;

public class Estilos extends JFrame {
	
	public void Ventana() {
		
		this.setTitle("Damas");	
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int height = pantalla.height;
		int width = pantalla.width;
		setSize(width/2, height/2);		
		setLocationRelativeTo(null);		
		setVisible(true);
		this.setResizable(false);
		getContentPane().setBackground(new Color(128, 255, 255));
	}
	
	public void VenEmergente() {
		
		this.setTitle("Damas");	
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int height = pantalla.height;
		int width = pantalla.width;
		setSize(width/3, height/3);		
		setLocationRelativeTo(null);		
		setVisible(true);
		this.setResizable(false);
		getContentPane().setBackground(new Color(128, 255, 255));
	}
	

}
