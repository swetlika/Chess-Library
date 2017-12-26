import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class ChessGUI implements ActionListener{

    public ChessGUI(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e) {
            //silently ignore
        }
        JFrame window = new JFrame("Chess");
        window.setSize(450, 450);
        Frame frame = new Frame();
        window.add(frame);
        window.setContentPane(frame);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public class Frame extends JPanel{

        public Frame(){
            setLayout(new GridBagLayout());

            GridBagConstraints constraints = new GridBagConstraints();
            for (int x = 0; x < 8; x++) {
                for (int y = 0; y < 8; y++) {
                    constraints.gridx = y;
                    constraints.gridy = x;

                    Border border = new LineBorder(Color.black);
                    JButton button = new JButton();

                    if (constraints.gridy == 1) {
                        Image blackPawn = null;
                        try {
                            blackPawn = ImageIO.read(getClass().getResource("assets/blackPawn.png"));
                        } catch (IOException e) {
                        }
                        button.setIcon(new ImageIcon(blackPawn));
                    }

                    if (constraints.gridy == 6) {
                        Image whitePawn = null;
                        try {
                            whitePawn = ImageIO.read(getClass().getResource("assets/whitePawn.png"));
                        } catch (IOException e) {
                        }
                        button.setIcon(new ImageIcon(whitePawn));
                    }

                    if (x == 0 && (y == 0 || y == 7)) {
                        Image blackRook = null;
                        try {
                            blackRook = ImageIO.read(getClass().getResource("assets/blackRook.png"));
                        } catch (IOException e) {
                        }
                        button.setIcon(new ImageIcon(blackRook));
                    }

                    if (x == 0 && (y == 1 || y == 6)) {
                        Image blackKnight = null;
                        try {
                            blackKnight = ImageIO.read(getClass().getResource("assets/blackKnight.png"));
                        } catch (IOException e) {
                        }
                        button.setIcon(new ImageIcon(blackKnight));
                    }

                    if (x == 0 && (y == 2 || y == 5)) {
                        Image blackBishop = null;
                        try {
                            blackBishop = ImageIO.read(getClass().getResource("assets/blackBishop.png"));
                        } catch (IOException e) {
                        }
                        button.setIcon(new ImageIcon(blackBishop));
                    }

                    if (x == 0 && y == 3) {
                        Image blackQueen = null;
                        try {
                            blackQueen = ImageIO.read(getClass().getResource("assets/blackQueen.png"));
                        } catch (IOException e) {
                        }
                        button.setIcon(new ImageIcon(blackQueen));
                    }

                    if (x == 0 && y == 4) {
                        Image blackKing = null;
                        try {
                            blackKing = ImageIO.read(getClass().getResource("assets/blackKing.png"));
                        } catch (IOException e) {
                        }
                        button.setIcon(new ImageIcon(blackKing));
                    }

                    if (x == 7 && (y == 0 || y == 7)) {
                        Image whiteRook = null;
                        try {
                            whiteRook = ImageIO.read(getClass().getResource("assets/whiteRook.png"));
                        } catch (IOException e) {
                        }
                        button.setIcon(new ImageIcon(whiteRook));
                    }

                    if (x == 7 && (y == 1 || y == 6)) {
                        Image whiteKnight = null;
                        try {
                            whiteKnight = ImageIO.read(getClass().getResource("assets/whiteKnight.png"));
                        } catch (IOException e) {
                        }
                        button.setIcon(new ImageIcon(whiteKnight));
                    }

                    if (x == 7 && (y == 2 || y == 5)) {
                        Image whiteBishop = null;
                        try {
                            whiteBishop = ImageIO.read(getClass().getResource("assets/whiteBishop.png"));
                        } catch (IOException e) {
                        }
                        button.setIcon(new ImageIcon(whiteBishop));
                    }

                    if (x == 7 && y == 3) {
                        Image whiteQueen = null;
                        try {
                            whiteQueen = ImageIO.read(getClass().getResource("assets/whiteQueen.png"));
                        } catch (IOException e) {
                        }
                        button.setIcon(new ImageIcon(whiteQueen));
                    }


                    if (x == 7 && y == 4) {
                        Image whiteKing = null;
                        try {
                            whiteKing = ImageIO.read(getClass().getResource("assets/whiteKing.png"));
                        } catch (IOException e) {
                        }
                        button.setIcon(new ImageIcon(whiteKing));
                    }

                    button.setBorderPainted(true);
                    button.setPreferredSize(new Dimension(50, 50));
                    button.setBackground(java.awt.Color.white);
                    add(button, constraints);

                }
            }
        }
    }

    private void initializeButton(JPanel myPanel) {
        JButton button = new JButton("Click me");
        button.addActionListener(this);
        myPanel.add(button, BorderLayout.NORTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,
                "I was clicked by "+e.getActionCommand(),
                "Title here", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new ChessGUI();
    }
}