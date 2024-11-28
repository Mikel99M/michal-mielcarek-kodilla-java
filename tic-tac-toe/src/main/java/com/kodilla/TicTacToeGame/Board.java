package com.kodilla.TicTacToeGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    private char[][] board;

    private char[] row1 = new char[3];
    private char[] row2 = new char[3];
    private char[] row3 = new char[3];

    private String boardString;

    private ChoiceOfMove choiceOfMove = new ChoiceOfMove(this, ' ');

    private List<Integer> moves = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

    public String createBoard() {

        for (int i = 0; i < 3; i++) {
            row1[i] = ' ';
            row2[i] = ' ';
            row3[i] = ' ';
        }

        board = new char[3][3];
        board[0] = row1;
        board[1] = row2;
        board[2] = row3;

        boardString = "" +
                "|"+ board[0][0] +"|"+ board[0][1] +"|"+ board[0][2] +"|\n" +
                "|"+ board[1][0] +"|"+ board[1][1] +"|"+ board[1][2] +"|\n" +
                "|"+ board[2][0] +"|"+ board[2][1] +"|"+ board[2][2] +"|"
                ;
        return boardString;
    }

    public String updateBoard(char[][] boardAfterChoice) {
        board = boardAfterChoice;
        String boardString = "" +
                "|"+ board[0][0] +"|"+ board[0][1] +"|"+ board[0][2] +"|\n" +
                "|"+ board[1][0] +"|"+ board[1][1] +"|"+ board[1][2] +"|\n" +
                "|"+ board[2][0] +"|"+ board[2][1] +"|"+ board[2][2] +"|"
                ;
        return boardString;
    }

    public char[][] getBoard() {
        return board;
    }

    public List<Integer> getMoves() {
        return moves;
    }
}
