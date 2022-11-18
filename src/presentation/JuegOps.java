package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JuegOps extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	public JuegOps() {
		VenEmergente();
		
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
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("                 ");
		getContentPane().add(lblNewLabel, BorderLayout.WEST);
		
		JLabel lblNewLabel_1 = new JLabel("                 ");
		getContentPane().add(lblNewLabel_1, BorderLayout.EAST);
		
		JLabel lbDamas = new JLabel("GAME TYPE");
		lbDamas.setHorizontalAlignment(SwingConstants.CENTER);
		lbDamas.setFont(new Font("Tahoma", Font.BOLD, 30));
		getContentPane().add(lbDamas, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setOpaque(false);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_4 = new JLabel(" ");
		panel.add(lblNewLabel_4, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_5 = new JLabel(" ");
		panel.add(lblNewLabel_5, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setOpaque(false);
		panel_1.setLayout(new GridLayout(0, 5, 0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("Player 1");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		panel_1.add(textField);
		
		JLabel lblNewLabel_7 = new JLabel("");
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_3_1 = new JLabel("Player 2");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_3_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		panel_1.add(textField_1);
		
		JLabel lblNewLabel_8 = new JLabel("");
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_6 = new JLabel("Game mode");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_6);
		
		JRadioButton rdbtnVs = new JRadioButton("1 vs 1");
		rdbtnVs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnVs.setOpaque(false);
		panel_1.add(rdbtnVs);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("1 vs PC");
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton_1.setOpaque(false);
		panel_1.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_9 = new JLabel("");
		panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_8_1 = new JLabel("");
		panel_1.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("Difficulty");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_6_1);
		
		JRadioButton rdbtnNormal = new JRadioButton("Normal");
		rdbtnNormal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNormal.setOpaque(false);
		panel_1.add(rdbtnNormal);
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("Quicktime");
		rdbtnNewRadioButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton_1_1.setOpaque(false);
		panel_1.add(rdbtnNewRadioButton_1_1);
		
		JLabel lblNewLabel_9_1 = new JLabel("");
		panel_1.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_8_2 = new JLabel("");
		panel_1.add(lblNewLabel_8_2);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DamasGUI da = new DamasGUI();
				da.setVisible(true);
				dispose();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(btnExit);
		
		JLabel lblNewLabel_6_2 = new JLabel("");
		panel_1.add(lblNewLabel_6_2);
		
		JButton btnNewButton = new JButton("Play");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tablero ta =new Tablero();
				ta.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_9_2_1 = new JLabel("");
		panel_1.add(lblNewLabel_9_2_1);
		
		JLabel lblNewLabel_2 = new JLabel(" ");
		getContentPane().add(lblNewLabel_2, BorderLayout.SOUTH);
	}
}
