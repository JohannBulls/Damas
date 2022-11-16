package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Rules extends JFrame {
	
	Diseno diseno;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rules frame = new Rules();
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
	public Rules() {
		
		diseno = new Diseno();
		
		JLabel lbRules = new JLabel("RULES");
		lbRules.setFont(new Font("Tahoma", Font.BOLD, 60));
		
		JTextPane txt_1 = new JTextPane();
		txt_1.setToolTipText("");
		txt_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_1.setText("El juego consiste en mover las piezas en diagonal a través de los cuadros negros de un tablero de 100 cuadros negros y blancos (NxN). Se juega entre dos personas, moviendo una ficha por turno, comiendo o capturando las fichas del rival pasando por encima de estás, la intención del juego es dejar sin movimientos al rival o comer todas sus fichas. \r\n\r\nAdiconalmente, ofrece las siguientes novedades:\r\n• Una ficha puede llegar a convertirse en una ficha especial, si llega al otro lado del tablero. El jugador escogerá el tipo de la nueva ficha.\r\n• Es posible jugar en tableros con casillas especiales.\r\n• Aparecerán de manera aleatoria comodines las cuales podrán afectar el comportamiento de algunas fichas o bien del juego. ");
		txt_1.setForeground(new Color(0, 0, 0));
		txt_1.setBackground(new Color(128, 255, 255));
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExit.setForeground(Color.BLACK);
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnExit.setBackground(Color.WHITE);
		
		JTextPane txt_2 = new JTextPane();
		txt_2.setToolTipText("");
		txt_2.setText("FICHAS\r\nLos jugadores inician con fichas normales. Al llegar al otro lado del tablero, estas pueden convertirse en nuevas fichas. Las transformaciones de fichas posibles son:");
		txt_2.setForeground(Color.BLACK);
		txt_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_2.setBackground(new Color(128, 255, 255));
		
		JButton btnNext = new JButton("NEXT");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNext.setForeground(Color.BLACK);
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNext.setBackground(Color.WHITE);
		
		JTextPane txt_3 = new JTextPane();
		txt_3.setToolTipText("");
		txt_3.setText("FICHA\r\n\r\n• Normal\r\n• Reina\r\n\r\n• Ninja\r\n\r\n\r\n• Zombie");
		txt_3.setForeground(Color.BLACK);
		txt_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_3.setBackground(new Color(128, 255, 255));
		
		JTextPane txt_4 = new JTextPane();
		txt_4.setToolTipText("");
		txt_4.setText("COMPORTAMIENTO\r\n\r\nAvanza a normalmente por el tablero.\r\nAvanza a lo largo del tablero en cualquier dirección Según la preferencia del jugador.\r\nEs invulnerable la primera vez que se trata de capturar: la ficha que la salta no la captura.\r\nDespués de ser capturada, puede volver al espacio en que fue capturada. Inicia los intentos de volver después de tres turnos de juego y ocupa el espacio una vez esté libre.\r");
		txt_4.setForeground(Color.BLACK);
		txt_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_4.setBackground(new Color(128, 255, 255));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txt_1, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
							.addGap(58))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
							.addGap(7)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txt_2, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txt_3, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txt_4, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)))
					.addContainerGap(31, GroupLayout.PREFERRED_SIZE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(355)
					.addComponent(lbRules)
					.addContainerGap(392, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(lbRules)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txt_1, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txt_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txt_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		
		
	}
}
