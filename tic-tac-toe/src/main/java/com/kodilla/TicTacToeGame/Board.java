package com.kodilla.TicTacToeGame;

import java.util.Arrays;

public class Board {

    private int numOfRows;
    private int numOfCols;
    private char[][] board;
    private String boardString;

    public String createBoard(int numOfRows, int numOfCols) {
        this.numOfRows = numOfRows;
        this.numOfCols = numOfCols;

        board = new char[numOfCols][numOfRows];

        for (char[] row: board) {
            Arrays.fill(row, ' ');
        }

        boardString = "";

        for (char[] row: board) {
            for (char c: row) {
                boardString += "|";
                boardString += c;
            }
            boardString += "|\n";
        }

        return boardString;
    }

    public String updateBoard(char[][] boardAfterChoice) {
        board = boardAfterChoice;
        boardString = "";

        for (char[] row: board) {
            for (char c: row) {
                boardString += "|";
                boardString += c;
            }
            boardString += "|\n";
        }

        return boardString;
    }

    public char[][] getBoard() {
        return board;
    }

    public int getNumOfRows() {
        return numOfRows;
    }

    public int getNumOfCols() {
        return numOfCols;
    }

}
