package com.kodilla.rps;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GameWithGUI {
    private int playerScore = 0;
    private int computerScore = 0;
    private String name;
    private int numberOfRounds;

    private final List<String> tokens = Arrays.asList("r", "p", "s", "x", "n");
    private final List<String> tokensAlt = Arrays.asList("r", "p", "s", "l", "q", "x", "n");
    private final Random rand = new Random();

    private JFrame frame = new JFrame("RPS Runner");
    private JButton classicButton = new JButton("Classic");
    private JButton alternativeButton = new JButton("Alterantive");
    private JButton restartButton = new JButton("Restart");
    private JLabel roundsLabel = new JLabel("Rounds: " + numberOfRounds);

    ///
    /// Jeszcze pracuję nad tą wersją
    ///
    public void play() {


        frame.setTitle("RPS Runner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setResizable(false);
        frame.setSize(700, 500);

        frame.setLayout(new BorderLayout());

        JPanel top = mainTopPanel();
        JPanel bottom = mainBottomPanel();







        frame.add(top, BorderLayout.NORTH);
        frame.add(bottom, BorderLayout.CENTER);

        frame.setVisible(true);


    }

    private JPanel mainBottomPanel() {
        JPanel bottom = new JPanel();

        CardLayout cardLayout = new CardLayout();
        bottom.setLayout(cardLayout);


        Color backgroundColor = new Color(123, 192, 201);
        JPanel blankPanel = new JPanel();
        blankPanel.setBackground(backgroundColor);

        JPanel classicPanel = new JPanel();
        classicPanel.setBackground(backgroundColor);
        JLabel classicLabel = new JLabel("Classic Mode Selected");
        classicPanel.add(classicLabel);

        JPanel alternativePanel = new JPanel();
        alternativePanel.setBackground(backgroundColor);
        JLabel alternativeLabel = new JLabel("Alternative Mode Selected");
        alternativePanel.add(alternativeLabel);

        bottom.add(blankPanel, "Blank");
        bottom.add(classicPanel, "Classic");
        bottom.add(alternativePanel, "Alternative");

        classicButton.addActionListener(e -> {
            cardLayout.show(bottom, "Classic");

        });
        alternativeButton.addActionListener(e -> {
            cardLayout.show(bottom, "Alternative");
        });
        restartButton.addActionListener(e -> {
            cardLayout.show(bottom, "Blank");
            numberOfRounds = 0;
            roundsLabel.setText("Rounds: " + 0);
        });

        blankPanel.setLayout(new BorderLayout());
        JPanel topSpacer = new JPanel();
        topSpacer.setPreferredSize(new Dimension(100, 50));
        JPanel bottomSpacer = new JPanel();
        bottomSpacer.setPreferredSize(new Dimension(100, 100));
        topSpacer.setBackground(Color.red);
        bottomSpacer.setBackground(Color.red);
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        // answers panel
        JPanel answersPanel = answers();
        answersPanel.setPreferredSize(new Dimension(500, 100));
        // score panel
        JLabel playerScoreLabel = new JLabel("Player Score: " + playerScore);
        JPanel scorePanel = new JPanel();
        JLabel computerScoreLabel = new JLabel("Computer Score: " + computerScore);
        scorePanel.setPreferredSize(new Dimension(500, 100));
        scorePanel.add(playerScoreLabel);
        scorePanel.add(computerScoreLabel);


        blankPanel.add(topSpacer, BorderLayout.NORTH);
        blankPanel.add(bottomSpacer, BorderLayout.SOUTH);
        centerPanel.add(answersPanel, BorderLayout.NORTH);
        centerPanel.add(scorePanel, BorderLayout.SOUTH);
        blankPanel.add(centerPanel, BorderLayout.CENTER);

        return bottom;
    }

    private JPanel mainTopPanel() {
        JPanel top = new JPanel();

        top.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        top.setBackground(Color.lightGray);
        top.setPreferredSize(new Dimension(100, 100));

        JPanel restartPanel = new JPanel();
        restartPanel.add(restartButton);

        JPanel namePanel = new JPanel();
        JLabel nameLabel = new JLabel("Name: ");
        JTextField nameField = new JTextField(10);
        namePanel.add(nameLabel);
        namePanel.add(nameField);
        namePanel.setPreferredSize(new Dimension(200, 36));
        name = nameField.getText();

        JPanel modePanel = new JPanel();
        JLabel modeLabel = new JLabel("Mode: ");

        modePanel.add(modeLabel);
        modePanel.add(classicButton);
        modePanel.add(alternativeButton);

        JPanel roundNumberPanel = new JPanel();
        JButton roundsPlusButton = new JButton("+");
        roundsPlusButton.addActionListener(e -> {
            numberOfRounds++;
            roundsLabel.setText("Rounds: " + numberOfRounds);
        });
        JButton roundsMinusButton = new JButton("-");
        roundsMinusButton.addActionListener(e -> {
            if (numberOfRounds > 0) {
                numberOfRounds--;
                roundsLabel.setText("Rounds: " + numberOfRounds);
            }
        });


        roundNumberPanel.add(roundsLabel);
        roundNumberPanel.add(roundsPlusButton);
        roundNumberPanel.add(roundsMinusButton);
        roundNumberPanel.setPreferredSize(new Dimension(250, 36));


        top.add(restartPanel);
        top.add(namePanel);
        top.add(modePanel);
        top.add(roundNumberPanel);

        return top;
    }

    private JPanel answers() {
        JPanel answersPanel = new JPanel();

        JButton rockButton = new JButton("Rock");
        JButton paperButton = new JButton("Paper");
        JButton scissorsButton = new JButton("Scissors");

        answersPanel.add(rockButton);
        answersPanel.add(paperButton);
        answersPanel.add(scissorsButton);

        return answersPanel;
    }




//    public void classicMode(int numberOfRounds) {
//        playerScore = 0;
//        computerScore = 0;
//
//
//
//        if (!closing) {
//            displayResults();
//        }
//    }
//
//    public void alternativeMode(int numberOfRounds, Scanner scanner) {
//        playerScore = 0;
//        computerScore = 0;
//
//        while (numberOfRounds > 0) {
//            System.out.println("Enter your choice:");
//            String input = scanner.nextLine().toLowerCase();
//
//            if (tokensAlt.contains(input)) {
//                int randomNum = rand.nextInt(5);
//                String computerChoice = tokensAlt.get(randomNum);
//
//                if (input.equals("x")) {
//                    if (confirmExit(scanner)) {
//                        closing = true;
//                        break;
//                    }
//                } else if (input.equals("n")) {
//                    if (confirmRestart(scanner)) {
//                        return;
//                    }
//                } else {
//                    playRoundAlt(input, computerChoice);
//                    numberOfRounds--;
//                    System.out.println("Rounds remaining: " + numberOfRounds);
//                }
//            } else {
//                System.out.println("Invalid choice. Please choose again.");
//            }
//        }
//
//        if (!closing) {
//            displayResults();
//        }
//    }
//
//    public void playRound(String playerChoice, String computerChoice) {
//        System.out.println("Computer chose: " + computerChoice);
//
//        if (playerChoice.equals(computerChoice)) {
//            System.out.println("It's a tie!");
//        } else if ((playerChoice.equals("r") && computerChoice.equals("s")) ||
//                (playerChoice.equals("p") && computerChoice.equals("r")) ||
//                (playerChoice.equals("s") && computerChoice.equals("p"))) {
//            playerScore++;
//            System.out.println("You win this round!");
//        } else {
//            computerScore++;
//            System.out.println("You lose this round!");
//        }
//
//        System.out.println("Your score: " + playerScore + " | Computer score: " + computerScore);
//    }
//
//    public void playRoundAlt(String playerChoice, String computerChoice) {
//        System.out.println("Computer chose: " + computerChoice);
//
//        if (playerChoice.equals(computerChoice)) {
//            System.out.println("It's a tie!");
//        } else if ((playerChoice.equals("r") && computerChoice.equals("s")) ||
//                (playerChoice.equals("r") && computerChoice.equals("l")) ||
//                (playerChoice.equals("p") && computerChoice.equals("r")) ||
//                (playerChoice.equals("p") && computerChoice.equals("q")) ||
//                (playerChoice.equals("s") && computerChoice.equals("p")) ||
//                (playerChoice.equals("s") && computerChoice.equals("l")) ||
//                (playerChoice.equals("l") && computerChoice.equals("q")) ||
//                (playerChoice.equals("l") && computerChoice.equals("p")) ||
//                (playerChoice.equals("q") && computerChoice.equals("s")) ||
//                (playerChoice.equals("q") && computerChoice.equals("r"))) {
//            playerScore++;
//            System.out.println("You win this round!");
//        } else {
//            computerScore++;
//            System.out.println("You lose this round!");
//        }
//
//        System.out.println("Your score: " + playerScore + " | Computer score: " + computerScore);
//    }
//
//    public boolean confirmExit(Scanner scanner) {
//        System.out.println("Are you sure you want to exit? (y/n)");
//        String response = scanner.nextLine();
//        return response.equalsIgnoreCase("y");
//    }
//
//    private boolean confirmRestart(Scanner scanner) {
//        System.out.println("Are you sure you want to restart? (y/n)");
//        String response = scanner.nextLine();
//        return response.equalsIgnoreCase("y");
//    }
//
//    private void displayResults() {
//        System.out.println("Final Scores:");
//        System.out.println("You: " + playerScore + " | Computer: " + computerScore);
//
//        if (playerScore > computerScore) {
//            System.out.println("Congratulations! You won the game!");
//        } else if (computerScore > playerScore) {
//            System.out.println("You lost the game. Better luck next time!");
//        } else {
//            System.out.println("It's a tie!");
//        }
//    }
//
//    public boolean isClosing() {
//        return closing;
//    }
}