# JAVA-PROJECT

The provided code is an implementation of the Tic Tac Toe game in Java using Swing for the graphical user interface. It creates a window with a 3x3 grid of buttons representing the game board. Two players, X and O, take turns clicking on the buttons to make their moves.The game keeps track of the score for each player and the number of rounds played. After each move, the code checks for a winning condition by examining the rows, columns, and diagonals of the game board. If a player wins or if all buttons are filled without a winner, a result message is displayed.The code includes additional features such as a game name label, a scoreboard displaying the scores for X and O, and the ability to play multiple rounds. After three rounds, a game end message is shown, declaring the winner based on the highest score, or indicating a draw if the scores are tied.The implementation follows object-oriented principles, with the TicTacToe class extending JFrame and implementing the ActionListener interface to handle button clicks. The main method creates an instance of the TicTacToe class to start the game.Overall, this code provides a basic structure for a playable Tic Tac Toe game with multiple rounds and score tracking.


Initialize the game:

Create a JFrame window for the game.
Set up the game board consisting of a 3x3 grid of buttons.
Initialize variables for player X's turn, move count, and scores.
Create and add components such as game name label and score labels to the window.
Set the window visibility to true.
Handle button click events:

Implement the ActionListener interface to capture button clicks.
When a button is clicked:
Check if the button is empty.
If yes, set the button's text to "X" or "O" based on the current player's turn.
Update move count.
Check for a winning condition or a draw:
Call the checkWin() method to examine the game board.
If a win or draw is detected, call the showResult() method.
Otherwise, switch the turn to the next player.
Check for a win:

Create a 2D array representing the game board.
Iterate through rows, columns, and diagonals to check for matching symbols ("X" or "O").
If a match is found, return true (winning condition), otherwise return false.
Show the game result:

Determine the result message based on the move count and the current player's turn.
If it's a draw, display a message stating that it's a draw.
If there's a winner, display a message indicating the winner and update the score.
Show a JOptionPane message dialog with the result message and round number.
Increment the round count and check if it's the end of the game (3 rounds).
If it's the end, call the showGameEnd() method, otherwise reset the game.
Update the score:

Based on the player who won, increment the corresponding score (X or O).
Update the score labels to display the updated scores.
Reset the game:

Reset the text and background color of all buttons.
Enable all buttons for interaction.
Reset the player turn to X.
Reset the move count to 0.
Show the game end:

Determine the winner based on the highest score (X or O) or declare a draw if the scores are tied.
Display a message congratulating the winner and suggesting to play the game again.
Reset the score:

Reset the scores for X and O to 0.
Reset the round count to 0.
Update the score labels to display the reset scores.
This algorithm provides a high-level overview of the program flow in the Tic Tac Toe game implementation. It outlines the main steps involved in handling button clicks, checking for wins or draws, updating scores, and managing game rounds.
