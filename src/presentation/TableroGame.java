package presentation;

import java.awt.Color;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TableroGame extends JPanel implements ComponentListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JButton[][] nCasillas = null;
    private int nMatriz = 10;
    private int TableroVis[][]  = new int[nMatriz][nMatriz];
    private int verdes[][] = null;
    private int amari[][] = null;
    private int mSeparacion = 2;
    

    public void acomodar() {
        int ancho = this.getWidth();
        int alto = this.getHeight();

        int dimensionMenor = Math.min(ancho, alto);

        int tamaAncho = dimensionMenor / nMatriz;
        int tamaAlto = dimensionMenor / nMatriz;

        int xOffset = (ancho - dimensionMenor) / 2;
        int yOffset = (alto - dimensionMenor) / 2;

        for (int i = 0; i < nMatriz; i++) {
            for (int j = 0; j < nMatriz; j++) {
                JButton temp = nCasillas[i][j];
                TableroVis[i][j]= 0;
                temp.setBounds(xOffset + j * tamaAncho, yOffset + i * tamaAlto, tamaAncho - mSeparacion, tamaAlto - mSeparacion);             
            }
        }
        
    }

    /**
     * Create the panel.
     */
    public TableroGame() {

        this.setOpaque(false);

        this.addComponentListener(this);

        this.setLayout(null);

    }

    public void inicializar() {

        nCasillas = new JButton[nMatriz][nMatriz];
        for (int i = 0; i < nMatriz; i++) {
            for (int j = 0; j < nMatriz; j++) {
                JButton temp = new JButton();
                ImageIcon peon = new ImageIcon();
                temp.setBackground(Color.WHITE);
                
                if ((i + j) % 2 != 0) {
                    temp.setBackground(Color.BLACK);
                    TableroVis[i][j]= 1;
                    if ((nMatriz / 2) - 2 >= i) {
                        temp.setIcon(new ImageIcon(TableroGame.class.getResource("/image/peonV.png")));
                        TableroVis[i][j]= 2;
                        verdes[i][j]=2;
                    } else if ((nMatriz / 2) + 1 <= i) {
                        temp.setIcon(new ImageIcon(TableroGame.class.getResource("/image/peonA.png")));
                        TableroVis[i][j]= 3;
                        amari[i][j]= 3;
                    }
                }
                nCasillas[i][j] = temp;
                this.add(temp);

            }
        }
        
    }
    
    public void juego() {
    	for (int i = 0; i < nCasillas.length; i++) {
    		   for (int j = 0; j < nCasillas[].length; j++) {
    			   nCasillas[i]j].setOnClickListener(new OnClickListener (){
    		                   public void onClick(View view){ 
    		                         //haces lo que necesites
    		                   }  
    		              });   
    		   }  
    		}
    }
    
    public void validar() {
    	if (TableroVis[x][y] != 0) {
    		JOptionPane.showMessageDialog(null, "Esta casilla no esta vacia","ALERTA!!!",JOptionPane.PLAIN_MESSAGE);
    	}
    }
    
    public void moverficha() {
    	validar();
    }
    

    public void componentResized(ComponentEvent e) {

        this.acomodar();

    }

    public void componentMoved(ComponentEvent e) {
    }

    public void componentShown(ComponentEvent e) {
    }

    public void componentHidden(ComponentEvent e) {
    }

    public void setMatriz(int nMatriz) {
        this.nMatriz = nMatriz;
    }

    public int getMatriz() {
        return nMatriz;
    }
}
