package com.kodilla.TicTacToeGame;

public class GameTicTacToe {


    public void play() {

        Board board = new Board();
        System.out.println(board.createBoard());

        CheckingIfWinner checkingIfWinner = new CheckingIfWinner();

        ChoiceOfMove playerOne = new ChoiceOfMove(board, 'X');
        ChoiceOfMove playerTwo = new ChoiceOfMove(board, 'O');

        String winner = "";

        while (winner.isEmpty()) {
            System.out.println("Make your move Player One:");
            playerOne.makeMove();
            System.out.println(board.updateBoard(playerOne.getBoardAfterChoice()));
            if (checkingIfWinner.checkIfWinner(board, 'X')) {
                winner = "Player One";
                break;
            }
            System.out.println("Make your move Player Two:");
            playerTwo.makeMove();
            System.out.println(board.updateBoard(playerTwo.getBoardAfterChoice()));
            if (checkingIfWinner.checkIfWinner(board, 'O')) {
                winner = "Player Two";
                break;
            }
        }

        System.out.println(winner + " is the winner!");
    }

}
