package com.kodilla.rps;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private int playerScore = 0;
    private int computerScore = 0;
    private boolean closing = false;

    private final List<String> tokens = Arrays.asList("r", "p", "s", "x", "n");
    private final List<String> tokensAlt = Arrays.asList("r", "p", "s", "l", "q", "x", "n");
    private final Random rand = new Random();


    public void play() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Your name: ");
        String name = scanner.nextLine();
        System.out.println("""
                Choose game mode:
                1 - classic mode
                2 - alternative mode
                """);
        int mode = scanner.nextInt();
        System.out.println("How many rounds do you want to play?: ");
        int numberOfRounds = scanner.nextInt();
        scanner.nextLine();

        boolean closing = false;

        while (!closing) {

            if (mode == 1) {
                System.out.println("""
                INSTRUCTIONS:
                "r" - rock
                "p" - paper
                "s" - scissors
                "x" - exit
                "n" - restart
            """);
                classicMode(numberOfRounds, scanner);
            } else if (mode == 2) {
                System.out.println("""
                INSTRUCTIONS:
                "r" - rock
                "p" - paper
                "s" - scissors
                "q" - Spock
                "l" - lizard
                "x" - exit
                "n" - restart
            """);
                alternativeMode(numberOfRounds, scanner);
            }

            if (isClosing()) {
                closing = true;
            } else {
                System.out.println("Game Over!");
                System.out.println("Would you like to play again? (y/n)");
                String response = scanner.nextLine();
                if (response.equalsIgnoreCase("y")) {
                    System.out.println("How many rounds do you want to play?: ");
                    numberOfRounds = scanner.nextInt();
                    scanner.nextLine();
                } else {
                    closing = true;
                }
            }
        }

        System.out.println("Thank you for playing, " + name + "!");

    }


    public void classicMode(int numberOfRounds, Scanner scanner) {
        playerScore = 0;
        computerScore = 0;

        while (numberOfRounds > 0) {
            System.out.println("Enter your choice:");
            String input = scanner.nextLine().toLowerCase();

            if (tokens.contains(input)) {
                int randomNum = rand.nextInt(3);
                String computerChoice = tokens.get(randomNum);

                if (input.equals("x")) {
                    if (confirmExit(scanner)) {
                        closing = true;
                        break;
                    }
                } else if (input.equals("n")) {
                    if (confirmRestart(scanner)) {
                        return;
                    }
                } else {
                    playRound(input, computerChoice);
                    numberOfRounds--;
                    System.out.println("Rounds remaining: " + numberOfRounds);
                }
            } else {
                System.out.println("Invalid choice. Please choose again.");
            }
        }

        if (!closing) {
            displayResults();
        }
    }

    public void alternativeMode(int numberOfRounds, Scanner scanner) {
        playerScore = 0;
        computerScore = 0;

        while (numberOfRounds > 0) {
            System.out.println("Enter your choice:");
            String input = scanner.nextLine().toLowerCase();

            if (tokensAlt.contains(input)) {
                int randomNum = rand.nextInt(5);
                String computerChoice = tokensAlt.get(randomNum);

                if (input.equals("x")) {
                    if (confirmExit(scanner)) {
                        closing = true;
                        break;
                    }
                } else if (input.equals("n")) {
                    if (confirmRestart(scanner)) {
                        return;
                    }
                } else {
                    playRoundAlt(input, computerChoice);
                    numberOfRounds--;
                    System.out.println("Rounds remaining: " + numberOfRounds);
                }
            } else {
                System.out.println("Invalid choice. Please choose again.");
            }
        }

        if (!closing) {
            displayResults();
        }
    }

    public void playRound(String playerChoice, String computerChoice) {
        System.out.println("Computer chose: " + computerChoice);

        if (playerChoice.equals(computerChoice)) {
            System.out.println("It's a tie!");
        } else if ((playerChoice.equals("r") && computerChoice.equals("s")) ||
                (playerChoice.equals("p") && computerChoice.equals("r")) ||
                (playerChoice.equals("s") && computerChoice.equals("p"))) {
            playerScore++;
            System.out.println("You win this round!");
        } else {
            computerScore++;
            System.out.println("You lose this round!");
        }

        System.out.println("Your score: " + playerScore + " | Computer score: " + computerScore);
    }

    public void playRoundAlt(String playerChoice, String computerChoice) {
        System.out.println("Computer chose: " + computerChoice);

        if (playerChoice.equals(computerChoice)) {
            System.out.println("It's a tie!");
        } else if ((playerChoice.equals("r") && computerChoice.equals("s")) ||
                (playerChoice.equals("r") && computerChoice.equals("l")) ||
                (playerChoice.equals("p") && computerChoice.equals("r")) ||
                (playerChoice.equals("p") && computerChoice.equals("q")) ||
                (playerChoice.equals("s") && computerChoice.equals("p")) ||
                (playerChoice.equals("s") && computerChoice.equals("l")) ||
                (playerChoice.equals("l") && computerChoice.equals("q")) ||
                (playerChoice.equals("l") && computerChoice.equals("p")) ||
                (playerChoice.equals("q") && computerChoice.equals("s")) ||
                (playerChoice.equals("q") && computerChoice.equals("r"))) {
            playerScore++;
            System.out.println("You win this round!");
        } else {
            computerScore++;
            System.out.println("You lose this round!");
        }

        System.out.println("Your score: " + playerScore + " | Computer score: " + computerScore);
    }

    public boolean confirmExit(Scanner scanner) {
        System.out.println("Are you sure you want to exit? (y/n)");
        String response = scanner.nextLine();
        return response.equalsIgnoreCase("y");
    }

    private boolean confirmRestart(Scanner scanner) {
        System.out.println("Are you sure you want to restart? (y/n)");
        String response = scanner.nextLine();
        return response.equalsIgnoreCase("y");
    }

    private void displayResults() {
        System.out.println("Final Scores:");
        System.out.println("You: " + playerScore + " | Computer: " + computerScore);

        if (playerScore > computerScore) {
            System.out.println("Congratulations! You won the game!");
        } else if (computerScore > playerScore) {
            System.out.println("You lost the game.");
        } else {
            System.out.println("It's a tie!");
        }
    }

    public boolean isClosing() {
        return closing;
    }
}