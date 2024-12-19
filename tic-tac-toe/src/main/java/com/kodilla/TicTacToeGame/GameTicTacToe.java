package com.kodilla.TicTacToeGame;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameTicTacToe {

    private String winner;
    private ScoreBoard scoreBoard = new ScoreBoard();
    private ChoiceOfMove playerOne;
    private ChoiceOfMove playerTwo;
    private Scanner scanner;
    private int numOfRows;
    private int numOfCols;
    private Board board;
    private WinnerChecker winnerChecker;

    public GameTicTacToe() throws IOException {
    }

    public void play() throws IOException {

        scanner = new Scanner(System.in);

        boolean replay = true;
        while (replay == true) {

            System.out.println("Size of the board. Type '3' to play classic Tic-Tac-Toe or choose any other size you want to try: ");
            int boardSize = 0;

            // checking if boardSize is integer and valid
            while (true) {
                try {
                    boardSize = scanner.nextInt();
                    if (boardSize < 2) {
                        System.out.println("Enter a playable size");
                    } else {
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Enter a number");
                    scanner.next();
                }
            }

            // I leave it here in case I wanted to make custom irregular boards like 5x10
            numOfRows = boardSize;
            numOfCols = boardSize;

            board = new Board();
            board.createBoard(numOfRows, numOfCols);

            winnerChecker = new WinnerChecker(numOfRows, numOfCols);
            playerOne = new ChoiceOfMove(board, 'X');
            playerTwo = new ChoiceOfMove(board, 'O');

            winner = "";

            int mode = 0;

            // checkin if mode is integer and valid
            while (true) {
                System.out.println("1 - single player\n2 - two players");
                try {
                    mode = scanner.nextInt();
                    if (mode == 1 || mode == 2) {
                        break;
                    }
                } catch (InputMismatchException e) {
                    scanner.nextLine();
                }
            }

            System.out.println(board.createBoard(numOfRows, numOfCols));

            if (mode == 1) {
                // SINGLE PLAYER
                playSinglePlayer();
            } else if (mode == 2) {
                // MULTI PLAYER
                playMultiplayer();
            }

            // the finish interface where player can see the scoreboard and choose some actions
            endingTerminal();

            System.out.println("Do you want to play again? (y/n):");
            if (scanner.nextLine().equals("n")) {
                replay = false;
            }
        }
    }

    public void playSinglePlayer() {
        int counterOfMoves = 0; // counter of moves in case there's a tie
        while (true) {
            // player
            System.out.println("Make your move Player One:");
            playerOne.makeMove(scanner);
            counterOfMoves++;

            System.out.println(board.updateBoard(playerOne.getBoardAfterChoice()));
            if (winnerChecker.checkIfWinner(board, 'X')) {
                winner = "Player One";
                break;
            }
            if (counterOfMoves == numOfRows * numOfCols) {
                break;
            }

            // COMPUTER PLAYER THAT MAKES RANDOM MOVES
            System.out.println("Computer makes his move: ");
            playerTwo.makeRandomMove(board, 'O');
            counterOfMoves++; // counter of moves in case there's a tie
            if (counterOfMoves == numOfRows * numOfCols) {
                break;
            }
            System.out.println(board.updateBoard(playerTwo.getBoardAfterChoice()));
            if (winnerChecker.checkIfWinner(board, 'O')) {
                winner = "Computer";
                break;
            }
        }
    }

    public void playMultiplayer() {
        int counterOfMoves = 0;
        while (true) {
            // player one
            System.out.println("Make your move Player One:");
            playerOne.makeMove(scanner);
            counterOfMoves++;

            System.out.println(board.updateBoard(playerOne.getBoardAfterChoice()));
            if (winnerChecker.checkIfWinner(board, 'X')) {
                winner = "Player One";
                break;
            }
            if (counterOfMoves == numOfRows * numOfCols) {
                break;
            }

            // player two
            System.out.println("Make your move Player Two:");
            playerTwo.makeMove(scanner);
            counterOfMoves++;

            System.out.println(board.updateBoard(playerTwo.getBoardAfterChoice()));
            if (winnerChecker.checkIfWinner(board, 'O')) {
                winner = "Player Two";
                break;
            }
            if (counterOfMoves == numOfRows * numOfCols) {
                break;
            }
        }
    }

    public void endingTerminal() throws IOException {
        if (winner.isBlank()) {
            System.out.println("It's a tie!");
        } else if (winner.equals("Computer")) {
            System.out.println("Game over.");
        } else {
            scanner.nextLine();
            System.out.println(winner + " is the winner! Do you want to save your score? (y/n):");
            if (scanner.nextLine().equals("y")) {
                System.out.println("Enter your name:");
                String name = scanner.nextLine();

                scoreBoard.updateScoreBoard(name);

                System.out.println("This is the current ScoreBoard:");
                scoreBoard.showScoreBoard();
            } else {
                System.out.println("This is the current ScoreBoard:");
                scoreBoard.showScoreBoard();
            }
        }
        System.out.println("Do you want to want to reset the score board? (y/n):");
        if (scanner.nextLine().equals("y")) {
            scoreBoard.resetScoreBoard();
        }
    }

    public String getWinner() {
        return winner;
    }
}