package com.kodilla.TicTacToeGame;

public class CheckingIfWinner {

    private Board board;
    private char[][] theBoard;
    private char sign;

    public boolean checkIfWinner(Board board, char sign) {
        this.board = board;
        this.theBoard = board.getBoard();
        this.sign = sign;


        int count = 0;

        for (char[] row : theBoard) {
            for (char element : row) {
                if (element == sign) {
                    count++;
                }
            }
            if (count == 3) {
                return true;
            } else {
                count = 0;
            }
        }

        count = 0;


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (theBoard[j][i] == sign) {
                    count++;
                }
            }
            if (count == 3) {
                return true;
            } else {
                count = 0;
            }
        }

        if (theBoard[0][0] == sign && theBoard[1][1] == sign && theBoard[2][2] == sign ||
                theBoard[0][2] == sign && theBoard[1][1] == sign && theBoard[2][0] == sign) {
            return true;
        }

        return false;
    }
}
