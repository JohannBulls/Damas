package presentation;

import java.awt.Color;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TableroGame extends JPanel implements ComponentListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton[][] nCasillas = null ;
	private int nMatriz = 10;
	private int mSeparacion = 2 ; 
	
	public void acomodar() {
		int ancho = this.getWidth();
		int alto = this.getHeight();
		
		int dimensionMenor = Math.min( ancho , alto ); 
		
		int tamaAncho = dimensionMenor / nMatriz;
		int tamaAlto = dimensionMenor / nMatriz;
		
		int xOffset = (ancho - dimensionMenor) / 2 ; 
        int yOffset = (alto - dimensionMenor) / 2 ; 
		
		for (int i =0 ; i < nMatriz ; i++) {
    		for (int j =0 ; j < nMatriz ; j++) {
    			JButton temp = nCasillas[i][j];
    			
    			temp.setBounds(xOffset + j * tamaAncho, yOffset + i * tamaAlto, tamaAncho - mSeparacion, tamaAlto - mSeparacion );
                

    		}	
    	}
		
	}
	
	/**
	 * Create the panel.
	 */
	public TableroGame() {        
        
        this.setBackground(Color.WHITE);
        
        this.addComponentListener(this);
        
        this.setLayout(null);                
        
    }
	
	public void inicializar() {
	    	
	    	nCasillas = new JButton[nMatriz][nMatriz];
	    	for (int i =0 ; i < nMatriz ; i++) {
	    		for (int j =0 ; j < nMatriz ; j++) {
	    			JButton temp = new JButton();
	    			temp.setText("("+(i+1)+","+(j+1)+")");	    			
	    			nCasillas[i][j]=temp;
	    			this.add(temp);
	    			
	    		}
	    	}
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
