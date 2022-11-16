package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Estilo extends JFrame {
	public Estilo() {
	}

	
	/**
	 * Create the frame.
	 */
	public void Ventana() {
		this.setTitle("Damas");	
		getContentPane().setBackground(new Color(128, 255, 255));
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int height = pantalla.height;
		int width = pantalla.width;
		setSize(width/2, height/2);		
		setLocationRelativeTo(null);		
		setVisible(true);
		this.setResizable(false);
		
	}
	
	

}
