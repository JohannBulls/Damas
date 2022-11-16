package presentation;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DamasGUI extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public DamasGUI() {
		
		Estilo es = new Estilo();
		es.Ventana();
	}
	
	
	
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
}
