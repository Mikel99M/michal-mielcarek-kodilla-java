package com.kodilla;

import com.kodilla.TicTacToeGame.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GameTicTacToe game = new GameTicTacToe();
        game.play();
    }
}