package presentation;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DamasGUI extends JFrame {
	
	//Estilos es = new Estilos();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DamasGUI frame = new DamasGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DamasGUI() {
		//es.Ventana();
		Ventana();
		getContentPane().setLayout(new BorderLayout(0, 0));
		PanelNorth();
		PanelWest();
		PanelEast();
	}
	
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
	
	public void PanelNorth() {
		
		JPanel panelNorth = new JPanel();
		panelNorth.setBackground(new Color(128, 255, 255));
		getContentPane().add(panelNorth, BorderLayout.NORTH);
		panelNorth.setLayout(new BorderLayout(0, 0));
		JLabel lbDamas = new JLabel("DAMAS");
		lbDamas.setHorizontalAlignment(SwingConstants.CENTER);
		lbDamas.setFont(new Font("Tahoma", Font.BOLD, 60));
		panelNorth.add(lbDamas);
		
		JLabel lblNewLabel_6 = new JLabel(" ");
		panelNorth.add(lblNewLabel_6, BorderLayout.NORTH);
		
	}
	
	public void PanelEast() {		
		JPanel panelEast = new JPanel();
		panelEast.setBackground(new Color(128, 255, 255));
		getContentPane().add(panelEast, BorderLayout.EAST);
		panelEast.setLayout(new BorderLayout(0, 0));
		JLabel lbIconDamas = new JLabel();
		lbIconDamas.setIcon(new ImageIcon(DamasGUI.class.getResource("/image/damas (2).png")));
		panelEast.add(lbIconDamas);
		
		JLabel lblNewLabel_5 = new JLabel("                                               ");
		panelEast.add(lblNewLabel_5, BorderLayout.EAST);
		
		
	}
	
	public void PanelWest() {
		JPanel panelWest = new JPanel();
		panelWest.setBackground(new Color(128, 255, 255));
		getContentPane().add(panelWest, BorderLayout.WEST);
		panelWest.setLayout(new BorderLayout(0, 0));
		

		JLabel lblNewLabel = new JLabel(" ");
		panelWest.add(lblNewLabel, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		panelWest.add(lblNewLabel_1, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_3 = new JLabel("                                               ");
		panelWest.add(lblNewLabel_3, BorderLayout.WEST);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 255, 255));
		panelWest.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 10));
		
		JLabel lblNewLabel_4 = new JLabel(" ");
		panel.add(lblNewLabel_4);
		
		
		JButton btnPlay = new JButton("PLAY");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JuegOps juOps = new JuegOps();
				juOps.setVisible(true);
				dispose();
			}
		});
		btnPlay.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(btnPlay);
		
		JButton btnLoad = new JButton("LOAD");
		btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(btnLoad);
		
		JButton btnRules = new JButton("RULES");
		btnRules.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(btnRules);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(btnExit);
		
		JLabel lblNewLabel_2 = new JLabel(" ");
		panel.add(lblNewLabel_2);

	}		
	
}
