package org.Mahmoud;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private List<Assignment> assignments;
    private List<Student> registeredStudents;
    private List<Double> finalScores;
    private static int nextId = 1;

    public Course(String courseName, double credits, Department department) {
        this.courseName = Util.toTitleCase(courseName);
        this.credits = credits;
        this.department = department;
        this.assignments = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
        this.finalScores = new ArrayList<>();

        this.courseId = "C-" + department.getDepartmentId() +
                "-" + String.format("%02d", nextId++);
    }

    /**
     * Checks if the sum of weights of all assignments of that course equal to 100%.
     * @return true if sum of all assignments equals to 100.0, else false.
     */
    public boolean isAssignmentWeightValid() {
        double sum = 0;
        for (Assignment assignment : assignments) {
            sum += assignment.getWeight();
        }
        return Math.abs(sum - 100.0) < 0.0001;
    }

    /**
     * Registers student to the course.
     * @param student The student to be registered.
     * @return true if student is successfully registered.
     */
    public boolean registerStudent(Student student) {
        if (registeredStudents.contains(student)) {
            return false;
        }
        registeredStudents.add(student);

        for (Assignment assignment : assignments) {
            assignment.getScores().add(null);
        }

        finalScores.add(null);
        return true;
    }

    /**
     * Calculates the weighted average score of registered students.
     * @return the weighted average score of registered students (int array).
     */
    public int[] calcStudentsAverage() {
        int[] averages = new int[registeredStudents.size()];
        for (int i = 0; i < finalScores.size(); i++) {
            if (finalScores.get(i) != null) {
                averages[i] = (int) Math.round(finalScores.get(i));
            } else {
                averages[i] = 0;
            }
        }
        return averages;
    }

    /**
     * Adds a new assignment to the course.
     * @param assignmentName the name of the assignment.
     * @param weight the weight of the assignment.
     * @return true if the assignment is added to the course.
     */
    public boolean addAssignment(String assignmentName, double weight) {
        Assignment assignment = new Assignment(assignmentName, weight);

        for (int i = 0; i < registeredStudents.size(); i++) {
            assignment.getScores().add(null);
        }
        assignments.add(assignment);
        return true;
    }

    /**
     * Generates random scores for each assignment and student, and calculates the final score for each student.
     */
    public void generateScores() {
        for (Assignment assignment : assignments) {
            assignment.generateRandomScore();
        }

        for (int i = 0; i < registeredStudents.size(); i++) {
            double calculatedScore = 0;
            for (Assignment assignment : assignments) {
                if (i < assignment.getScores().size()) {
                    Integer score = assignment.getScores().get(i);
                    if (score != null) {
                        calculatedScore += score * (assignment.getWeight() / 100.0);
                    }
                }
            }
            finalScores.set(i, calculatedScore);
        }
    }

    /**
     * Displays the scores of a course in a table, with the assignment averages and student weighted average (helper methods might be required)
     */
    public void displayScores() {
        System.out.printf("Course Name: %s(%s)\n", courseName, courseId);

        System.out.printf("%-20s", "");
        for (Assignment assignment : assignments) {
            System.out.printf("%-20s", assignment.getAssignmentName());
        }
        System.out.printf("%-20s\n", "Final Score");

        for (int i = 0; i < registeredStudents.size(); i++) {
            System.out.printf("%-20s", registeredStudents.get(i).getStudentName());

            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(i);
                System.out.printf("%-20d", score == null ? 0 : score);
            }

            Double finalScore = finalScores.get(i);
            System.out.printf("%-20.0f\n", finalScore == null ? 0.0 : finalScore);
        }

        System.out.printf("%-20s", "Average");
        for (Assignment assignment : assignments) {
            System.out.printf("%-20.0f", assignment.calcAssignmentAvg());
        }

        double classTotalSum = 0;
        int classCount = 0;

        for (Double finalScore : finalScores) {
            if (finalScore != null) {
                classTotalSum += finalScore;
                classCount++;
            }
        }

        double classFinalAvg = classCount == 0 ? 0 : classTotalSum / classCount;
        System.out.printf("%-20.0f\n", classFinalAvg);
    }

    /**
     * Converts a course to a simple string.
     * @return A simple string with courseId, courseName, credits, and departmentName.
     */
    public String toSimplifiedString() {
        return courseId + " " + courseName + " " + credits + " " + department.getDepartmentName();
    }

    @Override
    public String toString() {
        String studentsString = "[";
        for (int i = 0; i < registeredStudents.size(); i++) {
            studentsString += registeredStudents.get(i).toSimplifiedString();
            if (i < registeredStudents.size() - 1) {
                studentsString += ", ";
            }
        }
        studentsString += "]";

        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", department=" + department +
                ", assignments=" + assignments +
                ", registeredStudents=" + studentsString +
                ", isAssignmentWeightValid=" + isAssignmentWeightValid() +
                '}';
    }
}
