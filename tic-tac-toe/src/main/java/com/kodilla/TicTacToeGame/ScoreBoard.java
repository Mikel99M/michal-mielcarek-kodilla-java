package com.kodilla.TicTacToeGame;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class ScoreBoard {

    private File file;

    public ScoreBoard() {
        this.file = new File("C:\\Users\\48534\\OneDrive\\TicTacToeScoreBoard.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
        }
    }

    public void showScoreBoard() {;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateScoreBoard(String name) {

        Map<String, Integer> scores = new HashMap<String, Integer>();

        try {
            String line;
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null) {
                String[] scoresToAdd = line.split(": ");
                scores.put(scoresToAdd[0], Integer.parseInt(scoresToAdd[1]));
            }
            reader.close();
        } catch (IOException e) {
        }

        // updating the score
        if (scores.keySet().contains(name)) {
            scores.put(name, scores.get(name) + 1);
        } else {
            scores.put(name, 1);
        }

        // updating the ScoreBoard txt file
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (Map.Entry<String, Integer> entry : scores.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
            writer.close();
        } catch (IOException e) {
        }
    }


    public void resetScoreBoard() {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write("");
            writer.close();
        } catch (IOException e) {
        }
    }
}

