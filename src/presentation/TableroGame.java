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
	int[][] TableroVis = new int[nMatriz][nMatriz];

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
                		if (x!=-99999999 && y !=99999999) {
                			validar(i,j,x,y,TableroVis );
                			x=99999999;
                			y=99999999;
                			imprimri();
                		}else {
                			x=i;
                    		y=j;
                		}
                	}
                }
              }
    		
    	}
    	
    }
    
   public void imprimri() {
	   
	   
	   for (int x=0; x < TableroVis.length; x++) {
		   System.out.print("|");
		   for (int y=0; y < TableroVis[x].length; y++) {
		     System.out.print (TableroVis[x][y]);
		     if (y!=TableroVis[x].length-1) System.out.print("\t");
		   }
		   System.out.println("|");
		 }
   }
    
    public void validar(int i ,int j,int x,int y, int[][] TableroVis ) {
    	int[] arriba = {2,6,8};
    	int[] abajo = {3,7,9};
    	int tam=arriba.length;
    	int f;
    	//Espacio en Blanco
    	if (this.TableroVis[i][j]==1) {
    		for (int k =0;k<tam;k++) {
    			//Fichas de arriba solo se peude mover un espacio
        		if (this.TableroVis[x][y]==arriba[k] && i==x+1 ) {
        			f=this.TableroVis[x][y];
        			peon_arriba(i ,j, x, y,f,TableroVis);
        			 break;
        		//Fichas de abajo solo se peude mover un espacio
        		}else if(this.TableroVis[x][y]==abajo[k] && i==x-1 ) {
        			f=this.TableroVis[x][y];
        			peon_abajo(i ,j, x, y,f,TableroVis);
        			 break;
        		}else if(this.TableroVis[x][y]==arriba[k] && i==x+2 && (this.TableroVis[x+1][y+1]==abajo[k] || this.TableroVis[x+1][y-1]==abajo[k]) ) {
        			peon_arribaMata(i ,j, x, y,TableroVis);
        			 break;
        		}else if(this.TableroVis[x][y]==abajo[k] && i==x-2 && (this.TableroVis[x-1][y+1]==arriba[k] || this.TableroVis[x-1][y-1]==arriba[k]) ) {
        			peon_abajoMata(i ,j, x, y,TableroVis);
        			 break;
        		}else {
        			JOptionPane.showMessageDialog(null, "No se puede hacer esta Accion","ALERTA!!!",JOptionPane.PLAIN_MESSAGE);
        			break;
        		}
        	}
    	}else {
			JOptionPane.showMessageDialog(null, "No se puede hacer esta Accion","ALERTA!!!",JOptionPane.PLAIN_MESSAGE);
		}
    	
    }
    public void derecha() {}
    
    public void izquirda() {}
    
    public void peon_arriba(int i ,int j,int x,int y, int f, int[][] TableroVis) {
    	System.out.println("mueve");
    	System.out.println(this.TableroVis[x][y]+","+x+"-"+y+"------>"+this.TableroVis[i][j]+","+i+"-"+j);
    	this.TableroVis[x][y]=1;
    	this.TableroVis[i][j]=f;
		nCasillas[i][j].setIcon(new ImageIcon(TableroGame.class.getResource("/image/peonV.png")));
		nCasillas[x][y].setIcon(null);
		System.out.println(".                                                        .");
		System.out.println(this.TableroVis[x][y]+","+x+"-"+y+"------>"+this.TableroVis[i][j]+","+i+"-"+j);
    }

    public void peon_abajo(int i ,int j,int x,int y,int f,int[][] TableroVis) {
    	System.out.println("mueve");
    	System.out.println(this.TableroVis[x][y]+","+x+"-"+y+"------>"+this.TableroVis[i][j]+","+i+"-"+j);
    	this.TableroVis[x][y]=1;
    	this.TableroVis[i][j]=f;
		nCasillas[i][j].setIcon(new ImageIcon(TableroGame.class.getResource("/image/peonA.png")));
		nCasillas[x][y].setIcon(null);
		System.out.println(".                                                        .");
		System.out.println(this.TableroVis[x][y]+","+x+"-"+y+"------>"+this.TableroVis[i][j]+","+i+"-"+j);
    }
   
    public void peon_arribaMata(int i ,int j,int x,int y,int[][] TableroVis){
    	
    	System.out.println(y+"<"+j);
		if (y<j){
			System.out.println("erro 1");
			System.out.println("Ficha Muerta   " + this.TableroVis[x+1][y+1]);
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> F "+i+j+" I"+x+y);
			this.TableroVis[(x+1)][(y+1)]=1;
			nCasillas[(x+1)][(y+1)].setIcon(null);
			System.out.println("Ficha Muerta   " +this. TableroVis[x+1][y+1]);
		}else {
			System.out.println("erro 2");
			System.out.println("Ficha Muerta   " + this.TableroVis[x+1][y-1]);
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> F "+i+j+" I"+x+y);
			this.TableroVis[(x+1)][(y-1)]=1;
			nCasillas[(x+1)][(y-1)].setIcon(null);
			System.out.println("Ficha Muerta   " + this.TableroVis[(x+1)][(j-1)]);
		}
		System.out.println(">>>Mata<<<");
    	System.out.println(this.TableroVis[x][y]+","+x+"-"+y+"------>"+this.TableroVis[i][j]+","+i+"-"+j);
    	this.TableroVis[x][y]=1;
    	this.TableroVis[i][j]=2;
		nCasillas[i][j].setIcon(new ImageIcon(TableroGame.class.getResource("/image/peonV.png")));
		nCasillas[x][y].setIcon(null);
		System.out.println(".                                                        .");
		System.out.println(this.TableroVis[x][y]+","+x+"-"+y+"------>"+this.TableroVis[i][j]+","+i+"-"+j);
    }
    
   public void peon_abajoMata (int i ,int j,int x,int y,int[][] TableroVis) {
	   System.out.println(y+"<"+j);
		if (y<j){
			System.out.println("Ficha Muerta   " + this.TableroVis[x-1][y+1]);
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> F "+i+j+" I"+x+y);
			this.TableroVis[(x-1)][(y+1)]=1;
			nCasillas[(x-1)][(y+1)].setIcon(null);
			System.out.println("Ficha Muerta   " +this.TableroVis[x-1][y+1]);
		}else {
			System.out.println("erro 4");
			System.out.println("Ficha Muerta   " + this.TableroVis[x-1][y-1]);
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> F "+i+j+" I"+x+y);
			this.TableroVis[(x-1)][(y-1)]=1;
			nCasillas[(x-1)][(y-1)].setIcon(null);
			System.out.println("Ficha Muerta   " + this.TableroVis[x-1][y-1]);
		}
		System.out.println(">>>Mata<<<");
	   	System.out.println(this.TableroVis[x][y]+","+x+"-"+y+"------>"+this.TableroVis[i][j]+","+i+"-"+j);
	   	this.TableroVis[x][y]=1;
	   	this.TableroVis[i][j]=3;
		nCasillas[i][j].setIcon(new ImageIcon(TableroGame.class.getResource("/image/peonA.png")));
		nCasillas[x][y].setIcon(null);
		System.out.println(".                                                        .");
		System.out.println(this.TableroVis[x][y]+","+x+"-"+y+"------>"+this.TableroVis[i][j]+","+i+"-"+j);
   }
}


