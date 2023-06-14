# JAVA-PROJECT

The provided code is an implementation of the Tic Tac Toe game in Java using Swing for the graphical user interface. It creates a window with a 3x3 grid of buttons representing the game board. Two players, X and O, take turns clicking on the buttons to make their moves.The game keeps track of the score for each player and the number of rounds played. After each move, the code checks for a winning condition by examining the rows, columns, and diagonals of the game board. If a player wins or if all buttons are filled without a winner, a result message is displayed.The code includes additional features such as a game name label, a scoreboard displaying the scores for X and O, and the ability to play multiple rounds. After three rounds, a game end message is shown, declaring the winner based on the highest score, or indicating a draw if the scores are tied.The implementation follows object-oriented principles, with the TicTacToe class extending JFrame and implementing the ActionListener interface to handle button clicks. The main method creates an instance of the TicTacToe class to start the game.Overall, this code provides a basic structure for a playable Tic Tac Toe game with multiple rounds and score tracking.

# Here's the modified algorithmic code :

class TicTacToe:
    variables:
        buttons: 2D array of buttons
        playerX: boolean to track player X's turn
        moves: integer to count the number of moves
        scoreX: integer to track player X's score
        scoreO: integer to track player O's score
        roundCount: integer to track the current round count

    # Constructor:
        1. Initialize the game window
        2. Create the game board buttons
        3. Set initial values for variables
        4. Add components to the window
        5. Make the window visible

    # Method actionPerformed(button):
    
        1. if the button is empty:
            1.1 if it's player X's turn:
                    1.1.1 set the button text as "X"
                1.2 else:
                    1.2.1 set the button text as "O"
            2. increment the moves count

            3. if checkWin() is true or moves equals 9:
                3.1 showResult()
                3.2 resetGame()
            4. else:
                4.1 switch turns to the next player

    # Method checkWin():
        1. create a 2D array representing the game board
        2. check rows, columns, and diagonals for matching symbols
        3. if a match is found:
            3.1 return true (winning condition)
        4. else:
            4.1 return false

    # Method showResult():
        1. if moves equals 9:
            1.1 display "It's a draw!"
        2. else:
            2.1 display the winning player and update the score
        3. show a message dialog with the result and round number

        4. increment the round count
        5. if roundCount equals 3:
            5.1 showGameEnd()
            5.2 resetScore()

    # Method updateScore(playerXWon):
        1. if playerXWon is true:
            1.1 increment scoreX
        2. else:
            2.1 increment scoreO

    # Method resetGame():
        1. clear the text and background color of all buttons
        2. enable all buttons
        3. reset playerX to true
        4. reset moves to 0

    # Method showGameEnd():
        1. determine the winner based on the highest score or declare a draw
        2. display a message congratulating the winner and suggesting to play again

    # Method resetScore():
        1. reset scoreX and scoreO to 0
        2. reset roundCount to 0
