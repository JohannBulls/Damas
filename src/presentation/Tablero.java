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
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(lblNewLabel);
		
		JPanel panel_10 = new JPanel();
		panel_10.setOpaque(false);
		panel.add(panel_10, BorderLayout.SOUTH);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_19 = new JLabel("10:00");
		lblNewLabel_19.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		panel_10.add(lblNewLabel_19);
		
		JPanel panel_12 = new JPanel();
		panel_10.add(panel_12, BorderLayout.WEST);
		panel_12.setOpaque(false);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("Player 1");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_12.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("            ");
		panel_12.add(lblNewLabel_1, BorderLayout.WEST);
		
		JButton btnNewButton_1 = new JButton(" ");
		btnNewButton_1.setBackground(Color.RED);
		panel_12.add(btnNewButton_1, BorderLayout.EAST);
		
		JPanel panel_13 = new JPanel();
		panel_10.add(panel_13, BorderLayout.EAST);
		panel_13.setOpaque(false);
		panel_13.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3_1 = new JLabel("Player 2");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_13.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_18 = new JLabel("            ");
		panel_13.add(lblNewLabel_18, BorderLayout.EAST);
		
		JButton btnNewButton_1_1 = new JButton(" ");
		btnNewButton_1_1.setBackground(Color.GREEN);
		panel_13.add(btnNewButton_1_1, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_6 = new JLabel(" ");
		panel_1.add(lblNewLabel_6);
		
<<<<<<< HEAD
=======
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DamasGUI da = new DamasGUI();
				da.setVisible(true);
				dispose();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_1.add(btnExit);
		
>>>>>>> Restructura
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		getContentPane().add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_10 = new JLabel("                                                    ");
		panel_2.add(lblNewLabel_10, BorderLayout.SOUTH);
		
		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8, BorderLayout.NORTH);
		panel_8.setOpaque(false);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(128, 255, 255));
		getContentPane().add(panel_3, BorderLayout.WEST);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("                                                    ");
		panel_3.add(lblNewLabel_2, BorderLayout.CENTER);
		
		JPanel panel_5 = new JPanel();
		panel_5.setOpaque(false);
		panel_3.add(panel_5, BorderLayout.SOUTH);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DamasGUI da = new DamasGUI();
				da.setVisible(true);
				dispose();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_5.add(btnExit);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 128, 0));
		getContentPane().add(panel_4, BorderLayout.CENTER);
	}
	
    public void Ventana() {
		
		this.setTitle("Damas");	
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int height = pantalla.height;
		int width = pantalla.width;
		setSize(width, height);		
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
