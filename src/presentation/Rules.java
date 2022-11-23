package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Rules extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Rules frame = new Rules();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Rules() {
        super("Damas");
        getContentPane().setBackground(new Color(128, 255, 255));

        JLabel lbRules = new JLabel("RULES");
        lbRules.setFont(new Font("Tahoma", Font.BOLD, 60));

        JTextPane txtpnAsdsadsadjksaggjdgsajhdvsajvjhdvjhsavjhdasvjhsjavhasdvvhsadvjhvasd = new JTextPane();
        txtpnAsdsadsadjksaggjdgsajhdvsajvjhdvjhsavjhdasvjhsjavhasdvvhsadvjhvasd.setToolTipText("");
        txtpnAsdsadsadjksaggjdgsajhdvsajvjhdvjhsavjhdasvjhsjavhasdvvhsadvjhvasd.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtpnAsdsadsadjksaggjdgsajhdvsajvjhdvjhsavjhdasvjhsjavhasdvvhsadvjhvasd.setText("El juego consiste en mover las piezas en diagonal a través de los cuadros negros de un tablero de 100 cuadros negros y blancos (NxN). Se juega entre dos personas, moviendo una ficha por turno, comiendo o capturando las fichas del rival pasando por encima de estás, la intención del juego es dejar sin movimientos al rival o comer todas sus fichas. \r\n\r\nAdiconalmente, ofrece las siguientes novedades:\r\n• Una ficha puede llegar a convertirse en una ficha especial, si llega al otro lado del tablero. El jugador escogerá el tipo de la nueva ficha.\r\n• Es posible jugar en tableros con casillas especiales.\r\n• Aparecerán de manera aleatoria comodines las cuales podrán afectar el comportamiento de algunas fichas o bien del juego. ");
        txtpnAsdsadsadjksaggjdgsajhdvsajvjhdvjhsavjhdasvjhsjavhasdvvhsadvjhvasd.setForeground(new Color(0, 0, 0));
        txtpnAsdsadsadjksaggjdgsajhdvsajvjhdvjhsavjhdasvjhsjavhasdvvhsadvjhvasd.setBackground(new Color(128, 255, 255));

        JButton btnExit = new JButton("EXIT");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnExit.setForeground(Color.BLACK);
        btnExit.setFont(new Font("Tahoma", Font.PLAIN, 30));
        btnExit.setBackground(Color.WHITE);

        JTextPane txtpnFichasLosJugadores = new JTextPane();
        txtpnFichasLosJugadores.setToolTipText("");
        txtpnFichasLosJugadores.setText("FICHAS\r\nLos jugadores inician con fichas normales. Al llegar al otro lado del tablero, estas pueden convertirse en nuevas fichas. Las transformaciones de fichas posibles son:");
        txtpnFichasLosJugadores.setForeground(Color.BLACK);
        txtpnFichasLosJugadores.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtpnFichasLosJugadores.setBackground(new Color(128, 255, 255));

        JButton btnNext = new JButton("Next");
        btnNext.setForeground(Color.BLACK);
        btnNext.setFont(new Font("Tahoma", Font.PLAIN, 30));
        btnNext.setBackground(Color.WHITE);

        JTextPane txtpnFichaNormalReina = new JTextPane();
        txtpnFichaNormalReina.setToolTipText("");
        txtpnFichaNormalReina.setText("FICHA\r\n\r\n• Normal\r\n• Reina\r\n\r\n• Ninja\r\n\r\n• Zombie");
        txtpnFichaNormalReina.setForeground(Color.BLACK);
        txtpnFichaNormalReina.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtpnFichaNormalReina.setBackground(new Color(128, 255, 255));

        JTextPane txtpnFichasLosJugadores_1_1 = new JTextPane();
        txtpnFichasLosJugadores_1_1.setToolTipText("");
        txtpnFichasLosJugadores_1_1.setText("COMPORTAMIENTO\r\n\r\nAvanza a normalmente por el tablero.\r\nAvanza a lo largo del tablero en cualquier dirección Según la preferencia del jugador.\r\nEs invulnerable la primera vez que se trata de capturar: la ficha que la salta no la captura.\r\nDespués de ser capturada, puede volver al espacio en que fue capturada. Inicia los intentos de volver después de tres turnos de juego y ocupa el espacio una vez esté libre.\r");
        txtpnFichasLosJugadores_1_1.setForeground(Color.BLACK);
        txtpnFichasLosJugadores_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtpnFichasLosJugadores_1_1.setBackground(new Color(128, 255, 255));
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.TRAILING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap(400, Short.MAX_VALUE)
                                .addComponent(lbRules)
                                .addGap(347))
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(37)
                                                .addComponent(txtpnAsdsadsadjksaggjdgsajhdvsajvjhdvjhsavjhdasvjhsjavhasdvvhsadvjhvasd, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(201)
                                                .addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(txtpnFichasLosJugadores, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addComponent(txtpnFichaNormalReina, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(txtpnFichasLosJugadores_1_1, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)))
                                .addContainerGap(38, GroupLayout.PREFERRED_SIZE))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(30)
                                .addComponent(lbRules)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addComponent(txtpnAsdsadsadjksaggjdgsajhdvsajvjhdvjhsavjhdasvjhsjavhasdvvhsadvjhvasd, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                                        .addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addComponent(txtpnFichasLosJugadores, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(9)
                                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(txtpnFichaNormalReina, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtpnFichasLosJugadores_1_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(70, Short.MAX_VALUE))
        );
        getContentPane().setLayout(groupLayout);
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height;
        int width = pantalla.width;
        setSize(width / 2, height / 2);
        setLocationRelativeTo(null);
        setVisible(true);
        this.setResizable(false);

    }
}
