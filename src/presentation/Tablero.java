package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tablero extends JFrame {

	/**
	 * Create the frame.
	 */
	public Tablero() {
		Ventana();
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("DAMAS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 60));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		panel.add(lblNewLabel_1, BorderLayout.NORTH);
		
		JPanel panel_10 = new JPanel();
		panel_10.setOpaque(false);
		panel.add(panel_10, BorderLayout.SOUTH);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_19 = new JLabel("10:00");
		lblNewLabel_19.setFont(new Font("OCR A Extended", Font.PLAIN, 30));
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		panel_10.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel(" ");
		panel_10.add(lblNewLabel_20, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_25 = new JLabel(" ");
		panel_10.add(lblNewLabel_25, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_6 = new JLabel(" ");
		panel_1.add(lblNewLabel_6);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DamasGUI da = new DamasGUI();
				da.setVisible(true);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_1.add(btnExit);
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		getContentPane().add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_7 = new JLabel("                          ");
		panel_2.add(lblNewLabel_7, BorderLayout.WEST);
		
		JLabel lblNewLabel_8 = new JLabel("                          ");
		panel_2.add(lblNewLabel_8, BorderLayout.EAST);
		
		JLabel lblNewLabel_10 = new JLabel(" ");
		panel_2.add(lblNewLabel_10, BorderLayout.SOUTH);
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6, BorderLayout.CENTER);
		
		JLabel lblNewLabel_12 = new JLabel("                          ");
		panel_6.add(lblNewLabel_12);
		
		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8, BorderLayout.NORTH);
		panel_8.setOpaque(false);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3_1 = new JLabel("Player 2");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		panel_8.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_9 = new JLabel(" ");
		panel_8.add(lblNewLabel_9, BorderLayout.NORTH);
		
		JPanel panel_9 = new JPanel();
		panel_9.setOpaque(false);
		panel_8.add(panel_9, BorderLayout.SOUTH);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_21 = new JLabel(" ");
		panel_9.add(lblNewLabel_21, BorderLayout.NORTH);
		
		JLabel lblNewLabel_22 = new JLabel(" ");
		panel_9.add(lblNewLabel_22, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_23 = new JLabel("                              ");
		panel_9.add(lblNewLabel_23, BorderLayout.WEST);
		
		JLabel lblNewLabel_24 = new JLabel("                              ");
		panel_9.add(lblNewLabel_24, BorderLayout.EAST);
		
		JButton btnNewButton_1_1 = new JButton(" ");
		btnNewButton_1_1.setBackground(new Color(0, 255, 0));
		panel_9.add(btnNewButton_1_1, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(128, 255, 255));
		getContentPane().add(panel_3, BorderLayout.WEST);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("                          ");
		panel_3.add(lblNewLabel_2, BorderLayout.EAST);
		
		JLabel lblNewLabel_4 = new JLabel("                          ");
		panel_3.add(lblNewLabel_4, BorderLayout.WEST);
		
		JLabel lblNewLabel_5 = new JLabel(" ");
		panel_3.add(lblNewLabel_5, BorderLayout.SOUTH);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5, BorderLayout.CENTER);
		
		JLabel lblNewLabel_11 = new JLabel("                          ");
		panel_5.add(lblNewLabel_11);
		
		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7, BorderLayout.NORTH);
		panel_7.setOpaque(false);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("Player 1");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 40));
		panel_7.add(lblNewLabel_3);
		
		JLabel lblNewLabel_16 = new JLabel(" ");
		panel_7.add(lblNewLabel_16, BorderLayout.NORTH);
		
		JPanel panel_11 = new JPanel();
		panel_11.setOpaque(false);
		panel_7.add(panel_11, BorderLayout.SOUTH);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_1 = new JButton(" ");
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		panel_11.add(btnNewButton_1);
		
		JLabel lblNewLabel_13 = new JLabel(" ");
		panel_11.add(lblNewLabel_13, BorderLayout.NORTH);
		
		JLabel lblNewLabel_14 = new JLabel(" ");
		panel_11.add(lblNewLabel_14, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_15 = new JLabel("                              ");
		panel_11.add(lblNewLabel_15, BorderLayout.EAST);
		
		JLabel lblNewLabel_17 = new JLabel("                              ");
		panel_11.add(lblNewLabel_17, BorderLayout.WEST);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 128, 0));
		getContentPane().add(panel_4, BorderLayout.CENTER);
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
    
    public void PanelCenter_Tablero() {
    	JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
    }

}
