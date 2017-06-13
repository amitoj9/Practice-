package javacs602;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class TicTacToe extends JFrame implements ActionListener {
    // define players
    public static final char playerX = 'X';
    public static final char playerO = 'O';
    public static final char playerN = 'N';

    // winner init to null player
    private Character winner = playerN;
    // indicate whether game over
    private boolean gameOver = false;

    // button count 
    private int count = 0;

    private Character buttonPlayers[] = new Character[9];
    private JButton buttons[] = new JButton[9];
    private JButton exitButton;
    public JLabel title;
    public JPanel titlePanel, panel;

    public TicTacToe() {
        // init buttonPlayers
        for (int i = 0; i < 9; i++) {
            buttonPlayers[i] = playerN;
        }

        // init title
        title = new JLabel("Tic Tac Toe");
        titlePanel = new JPanel();
        title.setFont(new Font(Font.SERIF, 0, 30));
        titlePanel.add(title);
        this.add(titlePanel, BorderLayout.NORTH);

        // init all buttons
        panel = new JPanel(new GridLayout(3, 3));
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            panel.add(buttons[i]);
            buttons[i].setFont(new Font("Sylfaen", Font.PLAIN, 200));
            buttons[i].setEnabled(true);
            buttons[i].addActionListener(this);
        }

        this.add(panel, BorderLayout.CENTER);
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));


    }

    public void whoWins() {
        // winner by horizontal
        if (!gameOver) {
            for (int i = 0; i < 3; i++) {
                if ((buttonPlayers[0 + i * 3] != playerN) && (buttonPlayers[0 + i * 3].equals(buttonPlayers[1 + i * 3]))
                        && buttonPlayers[1 + i * 3].equals(buttonPlayers[2 + i * 3])) {
                    winner = buttonPlayers[0 + i * 3];
                    gameOver = true;
                    break;
                }
            }
        }

        // winner by verical
        if (!gameOver) {
            for (int i = 0; i < 3; i++) {
                if ((buttonPlayers[i + 0 * 3] != playerN) && (buttonPlayers[i + 0 * 3].equals(buttonPlayers[i + 1 * 3]))
                        && buttonPlayers[i + 1 * 3].equals(buttonPlayers[i + 2 * 3])) {
                    winner = buttonPlayers[i + 0 * 3];
                    gameOver = true;
                    break;
                }
            }
        }

        // winner by diagonal
        if (!gameOver) {
            int winButtonIndex = -1;

            if ((buttonPlayers[0] != playerN) && (buttonPlayers[0].equals(buttonPlayers[4])) && buttonPlayers[4].equals(buttonPlayers[8])) {
                winButtonIndex = 0;
            } else if ((buttonPlayers[2] != playerN) && (buttonPlayers[2].equals(buttonPlayers[4])) && buttonPlayers[4].equals(buttonPlayers[6])) {
                winButtonIndex = 2;
            }

            if (winButtonIndex >= 0) {
                winner = buttonPlayers[winButtonIndex];
                gameOver = true;
            }
        }

        // game end
        if (count == 9) {
            gameOver = true;
        }

        if (gameOver) {
            String tip = "";
            switch (winner) {
            case playerO:
                tip = "Player O win!";
                break;
            case playerX:
                tip = "Player X win!";
                break;
            default:
                tip = "Game ends in a Draw";
                break;
            }

            JOptionPane.showMessageDialog(null, tip);
        }
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
    	
        for (int i = 0; i < buttons.length; i++) {
            JButton button = buttons[i];
            if (button == e.getSource()) {
                Character currentPlayer = (count % 2 == 1 ? playerX : playerO);
                button.setText(String.valueOf(currentPlayer));
                buttonPlayers[i] = currentPlayer;
                button.setEnabled(false);

                break;
            }
        }
        count++;
        whoWins();
    }

    public static void main(String[] args) {
        TicTacToe ref1 = new TicTacToe();
        ref1.setTitle("Tic Tac Toe");
        ref1.setVisible(true);
        ref1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ref1.setSize(500, 500);
        ref1.setLocationRelativeTo(null);
    }
}