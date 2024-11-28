package com.kodilla.TicTacToeGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ChoiceOfMove {

    private Scanner scanner = new Scanner(System.in);
    private int choice;
//    private List<Integer> moves = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    private char[][] theBoard;
    private char sign;
    private Board board;
    private List<Integer> moves;

    public ChoiceOfMove(Board board, char sign) {
        this.board = board;
        this.theBoard = board.getBoard();
        this.sign = sign;
        this.moves = board.getMoves();
    }

    public void makeMove() {

        // in case player types something different thatn int
        boolean validInput = false;
        while (validInput == false) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                validInput = true;
            } else {
                System.out.println("Please enter a number.");
                scanner.nextLine();
            }
        }

        if (moves.contains(choice)) {
            moves.remove(Integer.valueOf(choice));
            if (choice == 1) {
                theBoard[0][0] = sign;
            } else if (choice == 2) {
                theBoard[0][1] = sign;
            } else if (choice == 3) {
                theBoard[0][2] = sign;
            } else if (choice == 4) {
                theBoard[1][0] = sign;
            } else if (choice == 5) {
                theBoard[1][1] = sign;
            } else if (choice == 6) {
                theBoard[1][2] = sign;
            } else if (choice == 7) {
                theBoard[2][0] = sign;
            } else if (choice == 8) {
                theBoard[2][1] = sign;
            } else if (choice == 9) {
                theBoard[2][2] = sign;
            }
        } else {
            System.out.println("Invalid move");
            this.makeMove();
        }
    }

    public char[][] getBoardAfterChoice() {
        return theBoard;
    }

    public char getSign() {
        return sign;
    }


}
