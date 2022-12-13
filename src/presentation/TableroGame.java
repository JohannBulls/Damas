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
	int fi;

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

    	int[] fichaOtra = {6,7,8,9,10,11};

    	
    	int tam=fichaOtra.length;
    	int f ;
    	//Espacio en Blanco
    	if (this.TableroVis[i][j]==1 && ((j-y)/(i-x)==-1 || (j-y)/(i-x)==1)) {
    		for (int k =0;k<tam;k++) {
    			//Fichas peon de arriba solo se peude mover un espacio
        		if ((this.TableroVis[x][y]==2 && (x+1)==i )|| (this.TableroVis[x][y]==3 && (x-1)==i)) {
        			f=TableroVis[x][y];
        			moverpeon(i ,j, x, y,f,TableroVis);
        			break;
        		}else if (this.TableroVis[x][y] == fichaOtra[k] && (x+1==i || x-1 ==i) ) {
        			f=this.TableroVis[x][y];
        			moverpeon(i ,j, x, y,f,TableroVis);
        			break;
        		}else if ((this.TableroVis[x][y]==2 && (x+2)==i )  || (this.TableroVis[x][y]==3 && (x-2)==i) ){
        			f=this.TableroVis[x][y];
        			matarpeon(i ,j, x, y,f,TableroVis);
        			break;
    			}else if(this.TableroVis[x][y] == fichaOtra[k] && (x+2==i || x-2 ==i)){
    				f=this.TableroVis[x][y];
    				matar(i ,j, x, y,f,TableroVis);
    				break;
    			}else if(this.TableroVis[x][y]== 4   || this.TableroVis[x][y]== 5 ){
    				f=this.TableroVis[x][y];
    				matar(i ,j, x, y,f,TableroVis);
    				break;
    			}else {
        			JOptionPane.showMessageDialog(null, "No se puede hacer esta Accion","ALERTA!!!",JOptionPane.PLAIN_MESSAGE);
        			break;
        		}
        	}

			if(this.TableroVis[i][j]==2 && i==(nMatriz-1)){
    			
    			tipo_ficha da = new tipo_ficha(TableroVis[i][j]);
                da.setVisible(true);
				f=setf(fi);
    			tipoficha(i,j,f);
    		}else if(this.TableroVis[i][j]==3 && i==0){
    			tipo_ficha da = new tipo_ficha(TableroVis[i][j]);
                da.setVisible(true);
				f=setf(fi);
				System.out.println(TableroVis[i][j]+","+f);
    			tipoficha(i,j,f);
    		}
    	}else {
			JOptionPane.showMessageDialog(null, "No se puede hacer esta Accion","ALERTA!!!",JOptionPane.PLAIN_MESSAGE);
		}
    	System.out.println(TableroVis[x][y]+" "+x+","+y+"---->"+TableroVis[i][j]+" "+i+","+j);
    }
    
    public void matar(int i ,int j,int x,int y,int f,int[][] TableroVis){
    	int x_d = x-i;
    	int y_d = y-j;
    	int p=1;
    	int xm = 0;
		int ym = 0;
    	int cont=0;
    	int cont_no=0;
    	int[] lista_no = null;
    	int[] arriba= {2,4,6,8,10};
    	int[] abajo= {3,5,7,9,11};
    	int[] lista = null;
		for (int u=0;u<arriba.length;u++) {
    		
			if(arriba[u]==TableroVis[x][y]) {
    			lista=abajo;
    			lista_no=arriba;
    			break;
    		}else if (abajo[u]==TableroVis[x][y]) {
    			lista=arriba;
    			lista_no=abajo;
    			break;
    		}
    	}
		
		
		if (x_d>0 && y_d>0) {
			for (int m=0;m<lista.length;m++) {
				while (p!=-1) {
					if(TableroVis[x-p][y-p]==lista[m]) {
						xm=x-p;
						ym=y-p;
						cont++;
						p++;
					}else if (TableroVis[x-p][y-p]==lista_no[m]) {
						cont_no++;
						p++;
					}else if(TableroVis[x-p][y-p]==1) {
						p++;
					}else if(p==Math.abs(xm)) {
						p=-1;
					}	
				}
			}
			
			fichasmatar_mover(i ,j, x, y,f,TableroVis,xm,ym,cont,cont_no);
    	}else if(x_d<0 && y_d<0) {
    		for (int m=0;m<lista.length;m++) {
				while (p!=-1) {
					if(TableroVis[x+p][y+p]==lista[m]) {
						xm=x+p;
						ym=y+p;
						cont++;
						p++;
					}else if (TableroVis[x+p][y+p]==lista_no[m]) {
						cont_no++;
						p++;
					}else if(TableroVis[x+p][y+p]==1) {
						p++;
					}else if(p==Math.abs(xm)) {
						p=-1;
					}	
				}
			}
			
    		fichasmatar_mover(i ,j, x, y,f,TableroVis,xm,ym,cont,cont_no);
    	}else if(x_d>0 && y_d<0) {
    		for (int m=0;m<lista.length;m++) {
				while (p!=-1) {
					if(TableroVis[x-p][y+p]==lista[m]) {
						xm=x-p;
						ym=y+p;
						cont++;
						p++;
					}else if (TableroVis[x-p][y+p]==lista_no[m]) {
						cont_no++;
						p++;
					}else if(TableroVis[x-p][y+p]==1) {
						p++;
					}else if(p==Math.abs(xm)) {
						p=-1;
					}	
				}
			}
			
    		fichasmatar_mover(i ,j, x, y,f,TableroVis,xm,ym,cont,cont_no);
    	}else if(x_d<0 && y_d>0) {
    		for (int m=0;m<lista.length;m++) {
				while (p!=-1) {
					if(TableroVis[x+p][y-p]==lista[m]) {
						xm=x+p;
						ym=y-p;
						cont++;
						p++;
					}else if (TableroVis[x+p][y-p]==lista_no[m]) {
						cont_no++;
						p++;
					}else if(TableroVis[x+p][y-p]==1) {
						p++;
					}else if(p==Math.abs(xm)) {
						p=-1;
					}	
				}
			}
    		fichasmatar_mover(i ,j, x, y,f,TableroVis,xm,ym,cont,cont_no);
			
    	}
    	
    }
    
    public void fichasmatar_mover(int i ,int j,int x,int y,int f,int[][] TableroVis,int xm, int ym,int cont,int cont_no) {
    	if(cont==1 && cont_no==0) {
			this.TableroVis[x][y]=1;
			this.TableroVis[xm][ym]=1;
            this.TableroVis[i][j]=f;
			tipoficha(i,j,f);
			nCasillas[xm][ym].setIcon(null);
        	nCasillas[x][y].setIcon(null);
		}else if(cont==0 && cont_no==0) {
			this.TableroVis[x][y]=1;
            this.TableroVis[i][j]=f;
			tipoficha(i,j,f);
        	nCasillas[x][y].setIcon(null);
		}
    } 

    public void tipoficha(int i ,int j,int f) {
    	if (f==2) {
    		nCasillas[i][j].setIcon(new ImageIcon(TableroGame.class.getResource("/image/peonV.png")));
    		this.TableroVis[i][j]=2;
    	}else if(f==3) {
    		nCasillas[i][j].setIcon(new ImageIcon(TableroGame.class.getResource("/image/peonA.png")));
    		this.TableroVis[i][j]=3;
    	}else if(f==4) {
    		nCasillas[i][j].setIcon(new ImageIcon(TableroGame.class.getResource("/image/reinaV.png")));
    		this.TableroVis[i][j]=4;
    	}else if(f==5) {
    		nCasillas[i][j].setIcon(new ImageIcon(TableroGame.class.getResource("/image/reinaA.png")));
    		this.TableroVis[i][j]=5;
    	}else if(f==6) {
    		nCasillas[i][j].setIcon(new ImageIcon(TableroGame.class.getResource("/image/ninjaV.png")));
    		this.TableroVis[i][j]=6;
    	}else if(f==7) {
    		nCasillas[i][j].setIcon(new ImageIcon(TableroGame.class.getResource("/image/ninjaA.png")));
    		this.TableroVis[i][j]=7;
    	}else if(f==8) {
    		nCasillas[i][j].setIcon(new ImageIcon(TableroGame.class.getResource("/image/zombiV.png")));
    		this.TableroVis[i][j]=8;
    	}else if(f==9) {
    		nCasillas[i][j].setIcon(new ImageIcon(TableroGame.class.getResource("/image/zombiA.png")));
    		this.TableroVis[i][j]=9;
    	}else if(f==10) {
    		nCasillas[i][j].setIcon(new ImageIcon(TableroGame.class.getResource("/image/ninjaA_S.png")));
    		this.TableroVis[i][j]=10;
    	}else if(f==11) {
    		nCasillas[i][j].setIcon(new ImageIcon(TableroGame.class.getResource("/image/ninjaV_S.png")));
    		this.TableroVis[i][j]=11;
    	}else {
    		JOptionPane.showMessageDialog(null, "Imagen no encontrada","ALERTA!!!",JOptionPane.PLAIN_MESSAGE);
    		
    	}
    }
    
    public void matarpeon(int i ,int j,int x,int y,int f,int[][] TableroVis) {
    	if (f==2) {
			if((j-y)/(i-x)==1) {
				System.out.println(TableroVis[x+1][y+1]+" "+(x+1)+","+(y+1));
				System.out.println("--------------------");
				this.TableroVis[x][y]=1;
				this.TableroVis[x+1][y+1]=1;
                this.TableroVis[i][j]=f;
                System.out.println(TableroVis[x+1][y+1]+" "+(x+1)+","+(y+1));
                tipoficha(i,j,f);
            	nCasillas[x+1][y+1].setIcon(null);
            	nCasillas[x][y].setIcon(null);
			}else if((j-y)/(i-x)==-1) {
				System.out.println(TableroVis[x+1][y-1]+" "+(x+1)+","+(y-1));
				System.out.println("--------------------");
				this.TableroVis[x][y]=1;
				this.TableroVis[x+1][y-1]=1;
                this.TableroVis[i][j]=f;
                System.out.println(TableroVis[x+1][y-1]+" "+(x+1)+","+(y-1));
                tipoficha(i,j,f);
            	nCasillas[x+1][y-1].setIcon(null);
            	nCasillas[x][y].setIcon(null);
			}
			
		}else if (f==3) {
			System.out.println("Matar");
			if((j-y)/(i-x)==-1) {
				System.out.println(TableroVis[x-1][y+1]+" "+(x-1)+","+(y+1));
				System.out.println("--------------------");
				this.TableroVis[x][y]=1;
				this.TableroVis[x-1][y+1]=1;
                this.TableroVis[i][j]=f;
                System.out.println(TableroVis[x-1][y+1]+" "+(x-1)+","+(y+1));
                tipoficha(i,j,f);
            	nCasillas[x-1][y+1].setIcon(null);
            	nCasillas[x][y].setIcon(null);
			}else if((j-y)/(i-x)==1) {
				System.out.println(TableroVis[x-1][y-1]+" "+(x-1)+","+(y-1));
				System.out.println("--------------------");
				this.TableroVis[x][y]=1;
				this.TableroVis[x-1][y-1]=1;
                this.TableroVis[i][j]=f;
                System.out.println(TableroVis[x-1][y-1]+" "+(x-1)+","+(y-1));
                tipoficha(i,j,f);
            	nCasillas[x-1][y-1].setIcon(null);
            	nCasillas[x][y].setIcon(null);
			}
			
			System.out.println("Movimiento");
			System.out.println(TableroVis[x][y]+" "+x+","+y+"---->"+TableroVis[i][j]+" "+i+","+j);
		}
    }


    public void moverpeon(int i ,int j,int x,int y,int f,int[][] TableroVis) {
    	System.out.println("Movimineto");
		System.out.println(TableroVis[x][y]+" "+x+","+y+"---->"+TableroVis[i][j]+" "+i+","+j);
    	this.TableroVis[x][y]=1;
        this.TableroVis[i][j]=f;
        tipoficha(i,j,f);
    	nCasillas[x][y].setIcon(null);


    }
    
    public int setf(int fi) {
    	return fi;
    }
   
}


