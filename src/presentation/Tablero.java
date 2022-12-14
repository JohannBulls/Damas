package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class Tablero extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Image imagen;
    private TableroGame mTablero = new TableroGame();
    String player1;
    String player2;
	int size;



    /**
     * Create the frame.
     */
    public Tablero() {
    	getContentPane().setBackground(new Color(128, 128, 255));
        Ventana();
        getContentPane().setLayout(new BorderLayout(0, 0));
        setdat(player1, player1, size);
        panelWest();;
        panelEast();
        panelSouth();
        
    }
    public void setdat(String player1 , String player2 ,int size) {
    	panelNorth(player1,player2);
		panelCenter(size);
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

    }

    public void panelCenter(int size) {
        JPanel panelCenter = new JPanel();
        panelCenter.setOpaque(false);
        getContentPane().add(panelCenter, BorderLayout.CENTER);
        panelCenter.setLayout(new FlowLayout());

        getContentPane().add(mTablero, BorderLayout.CENTER);
        this.size=size;
        mTablero.setMatriz(size);

        mTablero.inicializar();

    }
  

    public void panelNorth(String player1, String player2) {
    	this.player1=player1;
    	this.player2=player2;
        JPanel panelNorth = new JPanel();
        panelNorth.setOpaque(false);
        getContentPane().add(panelNorth, BorderLayout.NORTH);
        panelNorth.setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel = new JLabel("DAMAS");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        panelNorth.add(lblNewLabel);

        JPanel panel_10 = new JPanel();
        panel_10.setOpaque(false);
        panelNorth.add(panel_10, BorderLayout.SOUTH);
        panel_10.setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel_19 = new JLabel("10:00");
        lblNewLabel_19.setFont(new Font("OCR A Extended", Font.PLAIN, 20));
        lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
        panel_10.add(lblNewLabel_19);

        JPanel panel_12 = new JPanel();
        panel_10.add(panel_12, BorderLayout.WEST);
        panel_12.setOpaque(false);
        panel_12.setLayout(new BorderLayout(0, 0));

        JLabel lblplayer1 = new JLabel(player1+" ");
        lblplayer1.setHorizontalAlignment(SwingConstants.CENTER);
        lblplayer1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_12.add(lblplayer1);

        JLabel lblNewLabel_1 = new JLabel("            ");
        panel_12.add(lblNewLabel_1, BorderLayout.WEST);

        JButton btnNewButton_1 = new JButton(" ");
        btnNewButton_1.setEnabled(false);
        btnNewButton_1.setBackground(Color.RED);
        panel_12.add(btnNewButton_1, BorderLayout.EAST);

        JPanel panel_13 = new JPanel();
        panel_10.add(panel_13, BorderLayout.EAST);
        panel_13.setOpaque(false);
        panel_13.setLayout(new BorderLayout(0, 0));

        JLabel lblplayer2 = new JLabel(" "+player2);
        lblplayer2.setHorizontalAlignment(SwingConstants.CENTER);
        lblplayer2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_13.add(lblplayer2);

        JLabel lblNewLabel_18 = new JLabel("            ");
        panel_13.add(lblNewLabel_18, BorderLayout.EAST);

        JButton btnNewButton_1_1 = new JButton(" ");
        btnNewButton_1_1.setBackground(Color.GREEN);
        panel_13.add(btnNewButton_1_1, BorderLayout.WEST);
    }

    public void panelWest() {
        JPanel panelWest = new JPanel();
        panelWest.setOpaque(false);
        getContentPane().add(panelWest, BorderLayout.WEST);
        panelWest.setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel_2 = new JLabel("                                                    ");
        panelWest.add(lblNewLabel_2, BorderLayout.CENTER);

        JPanel panel_5 = new JPanel();
        panel_5.setOpaque(false);
        panelWest.add(panel_5, BorderLayout.SOUTH);

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
    }

    public void panelEast() {
        JPanel panelEast = new JPanel();
        panelEast.setOpaque(false);
        getContentPane().add(panelEast, BorderLayout.EAST);
        panelEast.setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel_10 = new JLabel("                                                    ");
        panelEast.add(lblNewLabel_10, BorderLayout.SOUTH);
        JPanel panel_8 = new JPanel();
        panelEast.add(panel_8, BorderLayout.NORTH);
        panel_8.setOpaque(false);
        panel_8.setLayout(new BorderLayout(0, 0));
    }

    public void panelSouth() {
        JPanel panelSouth = new JPanel();
        panelSouth.setOpaque(false);
        getContentPane().add(panelSouth, BorderLayout.SOUTH);

        JLabel lblNewLabel_6 = new JLabel(" ");
        panelSouth.add(lblNewLabel_6);
    }


}
