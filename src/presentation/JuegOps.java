package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JuegOps extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private ButtonGroup bg1 = new ButtonGroup();
    private ButtonGroup bg2 = new ButtonGroup();
    private JTextField player1;
    private JTextField player2;
    private JTextField size;
    String mode;
    String dificulty;

    public JuegOps() {

        VenEmergente();

    }



    public void VenEmergente() {

        this.setTitle("Damas");
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height;
        int width = pantalla.width;
        setSize(width / 3, height / 3);
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

        player1 = new JTextField();
        player1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        player1.setColumns(10);
        panel_1.add(player1);

        JLabel lblNewLabel_7 = new JLabel("");
        panel_1.add(lblNewLabel_7);

        JLabel lblNewLabel_3_1 = new JLabel("Player 2");
        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_1.add(lblNewLabel_3_1);

        player2 = new JTextField();
        player2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        player2.setColumns(10);
        panel_1.add(player2);

        JLabel lblNewLabel_8 = new JLabel("");
        panel_1.add(lblNewLabel_8);

        JLabel lblNewLabel_6 = new JLabel("Game mode");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_1.add(lblNewLabel_6);

        JRadioButton rdbtnVs = new JRadioButton("1 vs 1");
        rdbtnVs.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		mode = "1 vs 1";
        	}
        });
        rdbtnVs.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rdbtnVs.setOpaque(false);
        panel_1.add(rdbtnVs);

        JRadioButton rdbtnPc = new JRadioButton("1 vs PC");
        rdbtnPc.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		mode = "1 vs PC";
        	}
        });
        rdbtnPc.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rdbtnPc.setOpaque(false);
        panel_1.add(rdbtnPc);

        bg1.add(rdbtnVs);
        bg1.add(rdbtnPc);
        
        JLabel lblNewLabel_9 = new JLabel("");
        panel_1.add(lblNewLabel_9);

        JLabel lblNewLabel_8_1 = new JLabel("");
        panel_1.add(lblNewLabel_8_1);

        JLabel lblNewLabel_6_1 = new JLabel("Difficulty");
        lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_1.add(lblNewLabel_6_1);

        JRadioButton rdbtnNormal = new JRadioButton("Normal");
        rdbtnNormal.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		dificulty = "Normal";
        	}
        });
        rdbtnNormal.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rdbtnNormal.setOpaque(false);
        panel_1.add(rdbtnNormal);

        JRadioButton rdbtnQuictime = new JRadioButton("Quicktime");
        rdbtnQuictime.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		dificulty = "Quicktime";
        	}
        });
        rdbtnQuictime.setFont(new Font("Tahoma", Font.PLAIN, 14));
        rdbtnQuictime.setOpaque(false);
        panel_1.add(rdbtnQuictime);
        
        bg2.add(rdbtnNormal);
        bg2.add(rdbtnQuictime);

        JLabel lblNewLabel_9_1 = new JLabel("");
        panel_1.add(lblNewLabel_9_1);

        JLabel lblNewLabel_9_1_1 = new JLabel("");
        panel_1.add(lblNewLabel_9_1_1);

        JLabel lblNewLabel_6_1_1 = new JLabel("Size n=");
        lblNewLabel_6_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
        lblNewLabel_6_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_1.add(lblNewLabel_6_1_1);

        size = new JTextField();
        size.setFont(new Font("Tahoma", Font.PLAIN, 14));
        size.setColumns(10);
        panel_1.add(size);

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

        JLabel lblNewLabel_9_1_7 = new JLabel("");
        panel_1.add(lblNewLabel_9_1_7);

        JLabel lblNewLabel_9_1_6 = new JLabel("");
        panel_1.add(lblNewLabel_9_1_6);

        JLabel lblNewLabel_9_1_5 = new JLabel("");
        panel_1.add(lblNewLabel_9_1_5);

        JLabel lblNewLabel_9_1_4 = new JLabel("");
        panel_1.add(lblNewLabel_9_1_4);

        JLabel lblNewLabel_9_1_3 = new JLabel("");
        panel_1.add(lblNewLabel_9_1_3);

        JLabel lblNewLabel_9_1_8 = new JLabel("");
        panel_1.add(lblNewLabel_9_1_8);

        JLabel lblNewLabel_9_1_2 = new JLabel("");
        panel_1.add(lblNewLabel_9_1_2);
        btnExit.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_1.add(btnExit);

        JLabel lblNewLabel_6_2 = new JLabel("");
        panel_1.add(lblNewLabel_6_2);

        JButton btnplay = new JButton("Play");
        btnplay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	btnplayActionPerformed(e);
            }
        });
        btnplay.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_1.add(btnplay);

        JLabel lblNewLabel_9_2_1 = new JLabel("");
        panel_1.add(lblNewLabel_9_2_1);

        JLabel lblNewLabel_2 = new JLabel(" ");
        getContentPane().add(lblNewLabel_2, BorderLayout.SOUTH);


    }

    private void btnplayActionPerformed(java.awt.event.ActionEvent evt) { 
    	
    	int nMatriz_size = 0 ;
    	boolean a=true;
		try {
    		nMatriz_size = Integer.parseInt(size.getText());
    		a=true;
    	}catch(Exception e) {
    		a=false;
    	}
		System.out.println("-------->"+nMatriz_size);
		System.out.println("->"+mode +"<-->"+dificulty);
        if (player1.getText().equals("") || player2.getText().equals("") || a==false || dificulty==null || mode==null) {
            JOptionPane.showMessageDialog(this, "Debe llenar todos los campos \n", "AVISO!",JOptionPane.INFORMATION_MESSAGE);
            size.requestFocus();

        } else {
        	
            Tablero ta = new Tablero();
            ta.setdat(player1.getText(),player2.getText(),nMatriz_size);
            ta.setVisible(true);
            this.dispose();
        }
        
        

    } 



}
