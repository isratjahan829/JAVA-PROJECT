package GameProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class TicTacToe extends JFrame implements ActionListener {
    private JButton[][] buttons;
    private boolean playerX;
    private int moves;
    private JLabel scoreLabelX;
    private JLabel scoreLabelO;
    private int scoreX;
    private int scoreO;
    private int roundCount;

    public TicTacToe() {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        JLabel gameNameLabel = new JLabel("Tic Tac Toe Game");
        gameNameLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        gameNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(gameNameLabel, BorderLayout.NORTH);

        buttons = new JButton[3][3];
        playerX = true;
        moves = 0;
        scoreX = 0;
        scoreO = 0;
        roundCount = 0;

        JPanel boardPanel = new JPanel(new GridLayout(3, 3));
        boardPanel.setBackground(Color.WHITE);

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new JButton();
                buttons[row][col].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
                buttons[row][col].addActionListener(this);
                boardPanel.add(buttons[row][col]);
            }
        }

        add(boardPanel, BorderLayout.CENTER);

        JPanel scorePanel = new JPanel(new GridLayout(2, 1));
        scorePanel.setBackground(Color.BLUE);

        scoreLabelX = new JLabel("Player X Score: " + scoreX);
        scoreLabelX.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        scoreLabelX.setForeground(Color.WHITE);
        scorePanel.add(scoreLabelX);

        scoreLabelO = new JLabel("Player O Score: " + scoreO);
        scoreLabelO.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        scoreLabelO.setForeground(Color.WHITE);
        scorePanel.add(scoreLabelO);

        add(scorePanel, BorderLayout.WEST);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TicTacToe::new);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        if (button.getText().isEmpty()) {
            if (playerX) {
                button.setText("X");
                button.setForeground(Color.GREEN);
                button.setBackground(Color.RED);
            } else {
                button.setText("O");
                button.setForeground(Color.GREEN);
                button.setBackground(Color.BLUE);
            }

            moves++;

            if (checkWin() || moves == 9) {
                showResult();
                resetGame();
            } else {
                playerX = !playerX;
            }
        }
    }

    private boolean checkWin() {
        String[][] board = new String[3][3];

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = buttons[row][col].getText();
            }
        }

        // Check rows
        for (int row = 0; row < 3; row++) {
            if (board[row][0].equals(board[row][1]) && board[row][0].equals(board[row][2]) && !board[row][0].isEmpty()) {
                return true;
            }
        }

        // Check columns
        for (int col = 0; col < 3; col++) {
            if (board[0][col].equals(board[1][col]) && board[0][col].equals(board[2][col]) && !board[0][col].isEmpty()) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]) && !board[0][0].isEmpty()) {
            return true;
        }

        if (board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]) && !board[0][2].isEmpty()) {
            return true;
        }

        return false;
    }

    private void showResult() {
        String message;
        if (moves == 9) {
            message = "It's a draw!";
        } else {
            message = (playerX ? "X" : "O") + " wins!";
            updateScore(playerX);
        }
        JOptionPane.showMessageDialog(this, message, "Round " + (roundCount + 1) + " Result", JOptionPane.INFORMATION_MESSAGE);
        
        roundCount++;
        if (roundCount == 3) {
            showGameEnd();
            resetScore();
        }
    }

    private void updateScore(boolean playerXWon) {
        if (playerXWon) {
            scoreX++;
            scoreLabelX.setText("Player X Score: " + scoreX);
        } else {
            scoreO++;
            scoreLabelO.setText("Player O Score: " + scoreO);
        }
    }

    private void resetGame() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setText("");
                buttons[row][col].setEnabled(true);
                buttons[row][col].setBackground(null);
            }
        }

        playerX = true;
        moves = 0;
    }

    private void showGameEnd() {
        String winner;
        if (scoreX > scoreO) {
            winner = "Player X";
        } else if (scoreO > scoreX) {
            winner = "Player O";
        } else {
            winner = "No one";
        }

        String message = "Congratulations " + winner + "! You are the winner!\n\nLet's enjoy this game again.";
        JOptionPane.showMessageDialog(this, message, "Game Over", JOptionPane.INFORMATION_MESSAGE);
    }

    private void resetScore() {
        scoreX = 0;
        scoreO = 0;
        roundCount = 0;
        scoreLabelX.setText("Player X Score: " + scoreX);
        scoreLabelO.setText("Player O Score: " + scoreO);
    }
}
