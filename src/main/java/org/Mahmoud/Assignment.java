package org.Mahmoud;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
@EqualsAndHashCode
public class Assignment {

    private String assignmentId;
    private String assignmentName;
    private double weight;
    private List<Integer> scores;
    private static int nextId = 1;

    public Assignment(String assignmentName, double weight) {
        this.assignmentId = String.format("A%02d", nextId);
        nextId++;

        this.assignmentName = Util.toTitleCase(assignmentName);

        if (weight > 0) {
            this.weight = weight;
        } else {
            this.weight = 0;
        }

        this.scores = new ArrayList<>();
    }

    /**
     * Calculates the average score for the assignment.
     * @return the average score (double) or 0.0 if avg is null or empty.
     */
    public double calcAssignmentAvg() {
        if (scores == null || scores.isEmpty()) {
            return 0.0;
        }

        double sum = 0;
        int count = 0;

        for (Integer score : scores) {
            if (score != null) {
                sum += score;
                count++;
            }
        }

        if (count == 0) {
            return 0.0;
        }

        return sum / count;
    }

    /**
     * Generates random scores for all students in an assignment.
     */
    public void generateRandomScore() {
        Random random = new Random();

        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i) == null) {
                int randomInt = random.nextInt(11);
                int score;

                if (randomInt == 0) {
                    score = random.nextInt(60);
                } else if (randomInt <= 2) {
                    score = 60 + random.nextInt(10);
                } else if (randomInt <= 4) {
                    score = 70 + random.nextInt(10);
                } else if (randomInt <= 8) {
                    score = 80 + random.nextInt(10);
                } else {
                    score = 90 + random.nextInt(11);
                }

                scores.set(i, score);
            }
        }
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId='" + assignmentId + '\'' +
                ", assignmentName='" + assignmentName + '\'' +
                ", weight=" + weight +
                '}';
    }
}

