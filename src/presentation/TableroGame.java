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
                			break;
                		}else {
                			x=i;
                    		y=j;
                		}
                	}
                }
              }
    		
    	}
    	
    }
    

    
    public void validar(int i ,int j,int x,int y, int[][] TableroVis ) {
    	int[] arriba = {2,6,8};
    	int[] abajo = {3,7,9};
    	int[] arribaRe = {2,4,6,8};
    	int[] abajoRe = {3,5,7,9};
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
        		//Fichas de arriba mata solo se peude mover un espacio
        		}else if(this.TableroVis[x][y]==arriba[k] && i==x+2 && (this.TableroVis[x+1][y+1]==abajoRe[k] || this.TableroVis[x+1][y-1]==abajoRe[k]) ) {
        			System.out.println("Mata arriba");
        			f=this.TableroVis[x][y];
        			mataArriba(i ,j, x, y,f,TableroVis);
        			 break;
        		//Fichas de abajo mata solo se peude mover un espacio
        		}else if(this.TableroVis[x][y]==abajo[k] && i==x-2 && (this.TableroVis[x-1][y+1]==arribaRe[k] || this.TableroVis[x-1][y-1]==arribaRe[k]) ) { 
        			f=this.TableroVis[x][y];
        			mataAbajo(i ,j, x, y,f,TableroVis);
        			break;
        		//genera un mesaje de error 
        		}else if (this.TableroVis[x][y]==4 || this.TableroVis[x][y]==5){
        			if (this.TableroVis[x][y]==4) {
        				f=4;
        				reina(i ,j, x, y,f,TableroVis);
        			}else {
        				f=5;
        				reina(i ,j, x, y,f,TableroVis);
        			}
        			break;
        		}else {
        			JOptionPane.showMessageDialog(null, "No se puede hacer esta Accion","ALERTA!!!",JOptionPane.PLAIN_MESSAGE);
        			break;
        		}
        	}
    		if(this.TableroVis[i][j]==2 && i==(nMatriz-1)){
    			this.TableroVis[i][j]=4;
    			f=4;
    			tipoficha(i,j,f);
    		}else if(this.TableroVis[i][j]==3 && i==0){
    			this.TableroVis[i][j]=5;
    			f=5;
    			tipoficha(i,j,f);
    		}
    	}else {
			JOptionPane.showMessageDialog(null, "No se puede hacer esta Accion","ALERTA!!!",JOptionPane.PLAIN_MESSAGE);
		}
    	
    }
    public void tipoficha(int i ,int j,int f) {
    	if (f==2) {
    		nCasillas[i][j].setIcon(new ImageIcon(TableroGame.class.getResource("/image/peonV.png")));
    	}else if(f==3) {
    		nCasillas[i][j].setIcon(new ImageIcon(TableroGame.class.getResource("/image/peonA.png")));
    	}else if(f==4) {
    		nCasillas[i][j].setIcon(new ImageIcon(TableroGame.class.getResource("/image/reinaV.png")));
    	}else if(f==5) {
    		nCasillas[i][j].setIcon(new ImageIcon(TableroGame.class.getResource("/image/reinaA.png")));
    	}else if(f==6) {
    		nCasillas[i][j].setIcon(new ImageIcon(TableroGame.class.getResource("/image/ninjaV.png")));
    	}else if(f==7) {
    		nCasillas[i][j].setIcon(new ImageIcon(TableroGame.class.getResource("/image/ninjaA.png")));
    	}else if(f==8) {
    		nCasillas[i][j].setIcon(new ImageIcon(TableroGame.class.getResource("/image/zombiV.png")));
    	}else if(f==9) {
    		nCasillas[i][j].setIcon(new ImageIcon(TableroGame.class.getResource("/image/zombiA.png")));
    	}else {
    		JOptionPane.showMessageDialog(null, "Imagen no encontrada","ALERTA!!!",JOptionPane.PLAIN_MESSAGE);
    		nCasillas[i][j].setIcon(new ImageIcon(TableroGame.class.getResource("/image/giphy.gif")));
    	}
    }

    public void reina(int i ,int j,int x,int y, int f, int[][] TableroVis) {
    	if(this.TableroVis[x][y]==4 ){
			tipoficha(i,j,f);
		}else if(this.TableroVis[x][y]==5 ){
			tipoficha(i,j,f);
		}
    	this.TableroVis[x][y]=1;
    	this.TableroVis[i][j]=f;
		nCasillas[x][y].setIcon(null);
    }
    
    public void mataAbajo(int i ,int j,int x,int y, int f, int[][] TableroVis) {
    	int[] arribaRe = {2,4,6,8};
    	int h=0;
    	for(int w=0;w<arribaRe.length;w++) {
    		while(h!=99999999) {
    			if (y<j && TableroVis[x-h][y+h]==arribaRe[w]) {
    				this.TableroVis[(x-h)][(y+h)]=1;
    				nCasillas[(x-h)][(y+h)].setIcon(null);
    				h=99999999;
    				break;
        		}
    			else if(y>j && TableroVis[x+h][y-h]==arribaRe[w]){
    				this.TableroVis[(x-h)][(y-h)]=1;
    				nCasillas[(x-h)][(y-h)].setIcon(null);
    				h=99999999;
    				break;
    			}else {
    				h++;
    			}
    		}
    		h=99999999;
    	}
    	
    	this.TableroVis[x][y]=1;
    	this.TableroVis[i][j]=f;
    	tipoficha(i,j,f);
		nCasillas[x][y].setIcon(null);
    }
    
    public void mataArriba(int i ,int j,int x,int y, int f, int[][] TableroVis) {
    	int[] abajoRe = {3,5,7,9};
    	int[] arribaRe = {2,4,6,8};
    	int h=0;
    	for(int w=0;w<abajoRe.length;w++) {
    		while(h!=99999999) {
    			if (y<j && TableroVis[x+h][y+h]==abajoRe[w]  ) {
    				this.TableroVis[(x+h)][(y+h)]=1;
    				nCasillas[(x+h)][(y+h)].setIcon(null);
    				h=99999999;
    				break;
        		}
    			else if(y>j && TableroVis[x+h][y-h]==abajoRe[w]){
    				this.TableroVis[(x+h)][(y-h)]=1;
    				nCasillas[(x+h)][(y-h)].setIcon(null);
    				h=99999999;
    				break;
    			}else {
    				h++;
    			}
    		}
    		h=99999999;
    	}
    	
    	this.TableroVis[x][y]=1;
    	this.TableroVis[i][j]=f;
    	tipoficha(i,j,f);
		nCasillas[x][y].setIcon(null);
    }
    
    
    public void peon_arriba(int i ,int j,int x,int y, int f, int[][] TableroVis) {

    	this.TableroVis[x][y]=1;
    	this.TableroVis[i][j]=f;
    	tipoficha(i,j,f);
		nCasillas[x][y].setIcon(null);

    }

    public void peon_abajo(int i ,int j,int x,int y,int f,int[][] TableroVis) {

    	this.TableroVis[x][y]=1;
    	this.TableroVis[i][j]=f;
    	tipoficha(i,j,f);
		nCasillas[x][y].setIcon(null);

    }
   
}


