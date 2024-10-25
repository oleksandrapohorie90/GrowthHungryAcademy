package java_intro.week5.practiceExercises;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> scores = new ArrayList<>();
        BufferedReader br = null;
        String filePath = "/Users/alexasky111/IdeaProjects/GrowthHungryAcademy/src/java_intro/week5/practiceExercises/students.txt";
        try {
            br = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(","); //to get the names and scores
                String name = data[0]; //get the name
                String scoreStr = data[1];
                try {
                    int scoreInt = Integer.parseInt(scoreStr);
                    // Validate the score and throw custom exception if out of range
                    if (scoreInt < 0 || scoreInt > 100) {
                        throw new InvalidScoreException(name + " has invalid score of " + scoreInt);
                    }
                    scores.add(scoreInt);
                } catch (NumberFormatException nfe) {
                    System.err.println("An error occurred while parsing score for " + name + " - " + scoreStr);
                } catch (InvalidScoreException e) {
                    System.err.println(e.getMessage());
                }
            }
            //calculate average score
            if (!scores.isEmpty()) {
                double averageScore = 0;
                for (int i = 0; i < scores.size(); i++) {
                    averageScore += (double) scores.get(i) / scores.size();
                }
                System.out.println("Average score is " + averageScore);
            } else {
                System.out.println("There is no average score to calculate.");
            }
        } catch (FileNotFoundException fnf) {
            System.err.println("File not found " + fnf.getMessage());
        } catch (IOException e) {
            System.err.println("Error occurred while reading a file " + e.getMessage());
        } finally {
            //close the file
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.err.println("Error closing reader " + e.getMessage());
                }
            }
        }

    }
}

