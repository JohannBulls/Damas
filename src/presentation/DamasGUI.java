package presentation;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class DamasGUI extends JFrame {

	private JPanel contentPane;

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
		super("Damas");	
		getContentPane().setBackground(new Color(128, 255, 255));
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int height = pantalla.height;
		int width = pantalla.width;
		setSize(width/2, height/2);		
		setLocationRelativeTo(null);		
		setVisible(true);
		this.setResizable(false);
		
		JButton btnPlay = new JButton("PLAY");
		btnPlay.setForeground(new Color(0, 0, 0));
		btnPlay.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnPlay.setBackground(new Color(255, 255, 255));
		
		JButton btnLoad = new JButton("LOAD");
		btnLoad.setForeground(new Color(0, 0, 0));
		btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLoad.setBackground(new Color(255, 255, 255));
		
		JButton btnRules = new JButton("RULES");
		btnRules.setForeground(new Color(0, 0, 0));
		btnRules.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnRules.setBackground(new Color(255, 255, 255));
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setForeground(new Color(0, 0, 0));
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnExit.setBackground(new Color(255, 255, 255));
		
		JLabel lbIconDamas = new JLabel("");
		lbIconDamas.setIcon(new ImageIcon(DamasGUI.class.getResource("/image/damas (2).png")));
		
		JLabel lbDamas = new JLabel("DAMAS");
		lbDamas.setFont(new Font("Tahoma", Font.BOLD, 60));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(156)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnLoad, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRules, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPlay, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 266, Short.MAX_VALUE)
					.addComponent(lbIconDamas)
					.addGap(121))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(347)
					.addComponent(lbDamas)
					.addContainerGap(392, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(158, Short.MAX_VALUE)
					.addComponent(btnPlay, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLoad, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRules, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(117))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(47, Short.MAX_VALUE)
					.addComponent(lbDamas)
					.addGap(30)
					.addComponent(lbIconDamas)
					.addGap(105))
		);
		getContentPane().setLayout(groupLayout);
		
	}
}
