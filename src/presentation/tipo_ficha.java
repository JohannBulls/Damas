package presentation;

import java.awt.Dimension;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class tipo_ficha extends JFrame {

	private static final long serialVersionUID = 1L;
	private ButtonGroup bg = new ButtonGroup();
	private URL url;
	int fi;
	protected String fichati;

	public tipo_ficha(int ficha) {
		getContentPane().setBackground(new Color(0, 255, 255));
		Ventana(ficha);
	}
	public void Ventana(int ficha) {

        this.setTitle("Damas");
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height;
        int width = pantalla.width;
        setSize(width / 4, height / 4);
        setLocationRelativeTo(null);
        setVisible(true);
        this.setResizable(false);
        getContentPane().setLayout(new BorderLayout(0, 0));
        
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        getContentPane().add(panel, BorderLayout.NORTH);
        
        JLabel lbDamas = new JLabel("TOKEN TYPE");
        lbDamas.setHorizontalAlignment(SwingConstants.CENTER);
        lbDamas.setFont(new Font("Tahoma", Font.BOLD, 30));
        panel.add(lbDamas);
        
        JPanel panel_1 = new JPanel();
        panel_1.setOpaque(false);
        getContentPane().add(panel_1, BorderLayout.WEST);
        
        JPanel panel_2 = new JPanel();
        panel_2.setOpaque(false);
        getContentPane().add(panel_2, BorderLayout.EAST);
        
        JPanel panel_3 = new JPanel();
        panel_3.setOpaque(false);
        getContentPane().add(panel_3, BorderLayout.SOUTH);
        
        JPanel panel_4 = new JPanel();
        panel_4.setOpaque(false);
        getContentPane().add(panel_4, BorderLayout.CENTER);
        panel_4.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_5 = new JPanel();
        panel_5.setOpaque(false);
        panel_4.add(panel_5);
        
        JLabel JLimagen = new JLabel("");
        JLimagen.setHorizontalAlignment(SwingConstants.CENTER);
        panel_5.add(JLimagen);
        
        JPanel panel_6 = new JPanel();
        panel_6.setOpaque(false);
        panel_4.add(panel_6, BorderLayout.SOUTH);
        panel_6.setLayout(new GridLayout(0, 3, 5, 5));
        
        JRadioButton rdbtnReina = new JRadioButton("Reina");
        rdbtnReina.setOpaque(false);
        rdbtnReina.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		url = this.getClass().getResource("/image/reinaA.png");
        		ImageIcon icon = new ImageIcon(url);
        		JLimagen.setIcon(icon);
        		
				if(ficha==2) {
        			fi=4;
        		}else if(ficha==3) {
        			fi=5;
        		}
				fichati="reina";
        		
        	}
        });
        rdbtnReina.setSelected(true);
        rdbtnReina.setHorizontalAlignment(SwingConstants.CENTER);
        rdbtnReina.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_6.add(rdbtnReina);
        
        JRadioButton rdbtnNinja = new JRadioButton("Ninja");
        rdbtnNinja.setOpaque(false);
        rdbtnNinja.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		url = this.getClass().getResource("/image/ninjaA.png");
        		ImageIcon icon = new ImageIcon(url);
        		JLimagen.setIcon(icon);
        		
        		if(ficha==2) {
        			fi=6;
        		}else if(ficha==3) {
        			fi=7;
        		}
        		fichati="ninja";
        	}
        });
        rdbtnNinja.setSelected(true);
        rdbtnNinja.setHorizontalAlignment(SwingConstants.CENTER);
        rdbtnNinja.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_6.add(rdbtnNinja);
        
        JRadioButton rdbtnZombi = new JRadioButton("Zombi");
        rdbtnZombi.setOpaque(false);
        rdbtnZombi.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		url = this.getClass().getResource("/image/zombiA.png");
        		ImageIcon icon = new ImageIcon(url);
        		JLimagen.setIcon(icon);
        		
        		if(ficha==2) {
        			fi=8;
        		}else if(ficha==3) {
        			fi=9;
        		}
        		fichati="zombi";
        	}
        });
        rdbtnZombi.setSelected(true);
        rdbtnZombi.setHorizontalAlignment(SwingConstants.CENTER);
        rdbtnZombi.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_6.add(rdbtnZombi);
        
        bg.add(rdbtnReina);
        bg.add(rdbtnNinja);
        bg.add(rdbtnZombi);
        
        JLabel lblNewLabel_19 = new JLabel("");
        panel_6.add(lblNewLabel_19);
        
        JButton btnContinue = new JButton("Continue");
        btnContinue.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnContinueActionPerformed(e);
        	}
        });
        btnContinue.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel_6.add(btnContinue);
        
        JLabel lblNewLabel_1 = new JLabel("");
        panel_6.add(lblNewLabel_1);

        

    }
	
	 private void btnContinueActionPerformed(java.awt.event.ActionEvent evt) { 
		 
		if (fichati== null ) {
	            JOptionPane.showMessageDialog(this, "Debe llenar todos los campos \n", "AVISO!",JOptionPane.INFORMATION_MESSAGE);

	        } else {
	        	System.out.print(fi+",");
	        	TableroGame tag = new TableroGame();
	            tag.setf(fi);
	            tag.setVisible(true);
	            this.dispose();
	        }
	 }

}
