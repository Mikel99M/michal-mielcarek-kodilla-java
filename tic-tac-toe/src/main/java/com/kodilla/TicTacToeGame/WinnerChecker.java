package com.kodilla.TicTacToeGame;

public class WinnerChecker {

    private char[][] theBoard;
    private char sign;
    private int numOfRows;
    private int numOfCols;

    public WinnerChecker(int numOfRows, int numOfCols) {
        this.numOfRows = numOfRows;
        this.numOfCols = numOfCols;
    }

    public boolean checkIfWinner(Board board, char sign) {
        this.theBoard = board.getBoard();
        this.sign = sign;

        // CHECKING ROWS
        if (checkRows()) {
            return true;
        }

        // CHECKING COLUMNS
        if (checkColumns()) {
            return true;
        }

        // CHECKING DIAGONALS FROM LEFT TO RIGHT
        if (checkLeftToRightDiagonals()) {
            return true;
        }

        // CHECKING DIAGONALS FROM RIGHT TO LEFT
        if (checkRightToLeftDiagonals()) {
            return true;
        }

        return false;
    }

    private boolean checkRows() {
        for (int i = 0; i < numOfRows; i++) {
            int count = 0;
            for (int j = 0; j < numOfCols; j++) {
                if (theBoard[i][j] == sign) {
                    count++;
                    if (numOfRows < 5) {
                        if (count == numOfRows) {
                            return true;
                        }
                    } else {
                        if (count == 5) {
                            return true;
                        }
                    }
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int i = 0; i < numOfCols; i++) {
            int count = 0;
            for (int j = 0; j < numOfRows; j++) {
                if (theBoard[j][i] == sign) {
                    count++;
                    if (numOfRows < 5) {
                        if (count == numOfRows) {
                            return true;
                        }
                    } else {
                        if (count == 5) {
                            return true;
                        }
                    }
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    private boolean checkLeftToRightDiagonals() {
        if (numOfRows >= 5 && numOfCols >= 5) {
            for (int i = 0; i <= numOfRows - 5; i++) {
                for (int j = 0; j <= numOfCols - 5; j++) {
                    if (theBoard[i][j] == sign &&
                            theBoard[i + 1][j + 1] == sign &&
                            theBoard[i + 2][j + 2] == sign &&
                            theBoard[i + 3][j + 3] == sign &&
                            theBoard[i + 4][j + 4] == sign) {
                        return true;
                    }
                }
            }
        } else {
            // Small board
            boolean checker = true;
            int size = Math.min(numOfRows, numOfCols); // Explicit calculation could replace this if Math is disallowed
            for (int i = 0; i < size; i++) {
                if (theBoard[i][i] != sign) {
                    checker = false;
                    break;
                }
            }
            if (checker) {
                return true;
            }
        }
        return false;
    }

    private boolean checkRightToLeftDiagonals() {
        if (numOfRows >= 5 && numOfCols >= 5) {
            for (int i = 4; i < numOfRows; i++) {
                for (int j = 0; j <= numOfCols - 5; j++) {
                    if (theBoard[i][j] == sign &&
                            theBoard[i - 1][j + 1] == sign &&
                            theBoard[i - 2][j + 2] == sign &&
                            theBoard[i - 3][j + 3] == sign &&
                            theBoard[i - 4][j + 4] == sign) {
                        return true;
                    }
                }
            }
        } else {
            // Small board
            boolean checker = true;
            int size = Math.min(numOfRows, numOfCols); // Explicit calculation could replace this if Math is disallowed
            for (int i = 0; i < size; i++) {
                if (theBoard[i][size - 1 - i] != sign) {
                    checker = false;
                    break;
                }
            }
            if (checker) {
                return true;
            }
        }
        return false;
    }
}