package presentation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JButton[][] nCasillas;
    private int nMatriz = 10;
    private int x=99999999;
	private int y=99999999;
    private int TableroVis[][]  = new int[nMatriz][nMatriz];
    /*private int verdes[][] = null;
    private int amari[][] = null;*/
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
            	nCasillas[i][j] = new JButton();
            	nCasillas[i][j].setBackground(Color.WHITE);
            	TableroVis[i][j]=0;
            	nCasillas[i][j].setEnabled(false);
            	if ((i + j) % 2 != 0) {
            		nCasillas[i][j].setBackground(Color.BLACK);
            		nCasillas[i][j].setEnabled(true);
            		TableroVis[i][j]=1;
                    if ((nMatriz / 2) - 2 >= i) {
                    	TableroVis[i][j]=2;
                    	nCasillas[i][j].setIcon(new ImageIcon(TableroGame.class.getResource("/image/peonV.png")));
                    } else if ((nMatriz / 2) + 1 <= i) {
                    	TableroVis[i][j]=3;
                    	nCasillas[i][j].setIcon(new ImageIcon(TableroGame.class.getResource("/image/peonA.png")));
                    }
                }
            	ButtonController bt = new ButtonController();
            	nCasillas[i][j].addActionListener(bt);
            	this.add(nCasillas[i][j]);
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
    
    private class ButtonController implements ActionListener{
    	
    	@Override
    public void actionPerformed(ActionEvent e) {
    		
    		for (int i = 0; i < nMatriz; i++) {
                for (int j = 0; j < nMatriz; j++) {
                	if (e.getSource().equals(nCasillas[i][j])) {
                		System.out.println(x+","+y);
                		if (x!=-99999999 && y !=99999999) {
                			validar(i,j,x,y);
                			x=99999999;
                			y=99999999;
                		}else {
                			x=i;
                    		y=j;
                		}
                	}
                }
              }
    		
    	}
    	
    }
    
    
    public void validar(int i ,int j,int x,int y) {
    	if (nCasillas[i][j].getIcon()==null) {
    		if (x+1 == i || x-1==i) {
    			peon( i , j, x, y);
    		} else if ((x+1>i&&(y+2==j||y-2==j)) || (x-1<i&&(y+2==j||y-2==j))  ) {
    			mata(i , j, x, y);
    		}
    		
    	}else {
    		JOptionPane.showMessageDialog(null, "No se puede hacer esta Accion","ALERTA!!!",JOptionPane.PLAIN_MESSAGE);
    	}
    }
    

    public void peon(int i ,int j,int x,int y) {
    		if(i==x+1 && (y==j+1 || y==j-1) && TableroVis[x][y]==2) {
    			System.out.println("-------mueve------");
    			System.out.println(TableroVis[x][y]+","+x+"-"+y+"------>"+TableroVis[i][j]+","+i+"-"+j);
    			TableroVis[x][y]=1;
    			TableroVis[i][j]=2;
    			nCasillas[i][j].setIcon(new ImageIcon(TableroGame.class.getResource("/image/peonV.png")));
    			nCasillas[x][y].setIcon(null);
    			System.out.println(TableroVis[x][y]+","+x+"-"+y+"------>"+TableroVis[i][j]+","+i+"-"+j);
    		}else if(i==x-1 && (y==j+1 || y==j-1) && TableroVis[x][y]==3) {
    			System.out.println("-------mueve------");
    			System.out.println(TableroVis[x][y]+","+x+"-"+y+"------>"+TableroVis[i][j]+","+i+"-"+j);
    			TableroVis[x][y]=1;
    			TableroVis[i][j]=3;
    			nCasillas[i][j].setIcon(new ImageIcon(TableroGame.class.getResource("/image/peonA.png")));
    			nCasillas[x][y].setIcon(null);
    			System.out.println(TableroVis[x][y]+","+x+"-"+y+"------>"+TableroVis[i][j]+","+i+"-"+j);
    		}
    	
    }
    
   public void mata (int i ,int j,int x,int y) {
	   if((TableroVis[x+1][y+1]==2 || TableroVis[x+1][y-1]==2)  && x+2 == i) {
		   System.out.println("-------mata------");
			System.out.println(TableroVis[x][y]+","+x+"-"+y+"------>"+TableroVis[i][j]+","+i+"-"+j);
			TableroVis[x][y]=1;
			TableroVis[i][j]=2;
			nCasillas[i][j].setIcon(new ImageIcon(TableroGame.class.getResource("/image/peonV.png")));
			nCasillas[x][y].setIcon(null);
			if (j>y){
				TableroVis[x+1][j+1]=1;
				nCasillas[x+1][y+1].setIcon(null);
				System.out.println(TableroVis[x][y]+","+x+"-"+y+"------>"+TableroVis[i][j]+","+i+"-"+j);
			}else {
				TableroVis[x+1][j-1]=1;
				nCasillas[x+1][y-1].setIcon(null);
				System.out.println(TableroVis[x][y]+","+x+"-"+y+"------>"+TableroVis[i][j]+","+i+"-"+j);
			}
		}else if((TableroVis[x-1][y+1]==3 || TableroVis[x-1][y-1]==3)  && x-2 == i) {
			System.out.println("-------mata------");
			System.out.println(TableroVis[x][y]+","+x+"-"+y+"------>"+TableroVis[i][j]+","+i+"-"+j);
			TableroVis[x][y]=1;
			TableroVis[i][j]=3;
			nCasillas[i][j].setIcon(new ImageIcon(TableroGame.class.getResource("/image/peonA.png")));
			nCasillas[x][y].setIcon(null);
			if (j>y){
				TableroVis[x-1][j+1]=1;
				nCasillas[x-1][y+1].setIcon(null);
				System.out.println(TableroVis[x][y]+","+x+"-"+y+"------>"+TableroVis[i][j]+","+i+"-"+j);
			}else {
				TableroVis[x-1][j-1]=1;
				nCasillas[x-1][y-1].setIcon(null);
				System.out.println(TableroVis[x][y]+","+x+"-"+y+"------>"+TableroVis[i][j]+","+i+"-"+j);
			}
		}
   }
}


