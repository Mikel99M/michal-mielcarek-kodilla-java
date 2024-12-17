package com.kodilla.TicTacToeGame;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ChoiceOfMove {

    private Board board;
    private char sign;
    private char[][] theBoard;
    private int coordinateX;
    private int coordinateY;

    public ChoiceOfMove(Board board, char sign) {
        this.board = board;
        this.sign = sign;
        this.theBoard = board.getBoard();
    }

    // MAIN FUNCTION HERE. MAKES A MOVE BY THE PLAYER ON THE BOARD
    public void makeMove(Scanner scanner) {

        // checking if coordinate X is a an integer and is valid
        while (true) {
            System.out.println("Coordinate X:");
            try {
                coordinateX = scanner.nextInt() - 1;
                if (coordinateX >= 0 && coordinateX < board.getNumOfCols()) {
                    break;
                } else {
                    System.out.println("Invalid number");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
            }
        }

        while (true) {
            System.out.println("Coordinate Y:");
            try {
                coordinateY = scanner.nextInt() - 1;
                if (coordinateY >= 0 && coordinateY < board.getNumOfRows()) {
                    break;
                } else {
                    System.out.println("Invalid number");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
            }
        }

        if (theBoard[coordinateY][coordinateX] == ' ') {
            theBoard[coordinateY][coordinateX] = sign;
        } else {
            System.out.println("Invalid move");
            this.makeMove(scanner);
        }
    }

    // THIS MAKES RANDOM MOVES
    public void makeRandomMove(Board board, char sign) {
        Random rand = new Random();
        int coordinateX = rand.nextInt(theBoard.length);
        int coordinateY = rand.nextInt(theBoard.length);
        if (theBoard[coordinateY][coordinateX] == ' ') {
            theBoard[coordinateY][coordinateX] = sign;
        } else {
            this.makeRandomMove(board, sign);
        }
    }

    public char[][] getBoardAfterChoice() {
        return theBoard;
    }

}