package com.kodilla;

public class SudokuRunner {
    public static void main(String[] args) {

        boolean gameFinished = false;
        while (!gameFinished) {
            SudokuGame game = new SudokuGame();
            gameFinished = game.resolveSudoku();
        }

    }
}
