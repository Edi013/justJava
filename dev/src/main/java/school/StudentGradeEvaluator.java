package main.java.school;

import java.util.Scanner;

public class StudentGradeEvaluator {

    public static double calculateAverage(int[] scores) {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.length;
    }

    public static String evaluateStudent(double average, int attendance) {
        String status;

        if (average >= 70 && attendance >= 75) {
            status = "PASS";
        } else if (average >= 50 && average < 70) {
            status = "RE-EXAM";
        } else {
            status = "FAIL";
        }

        return status;
    }

    public static String getLetterGrade(double average) {
            return switch ((int) (average / 10)) {
                case 10, 9 -> "A";
                case 8 -> "B";
                case 7 -> "C";
                case 6 -> "D";
                default -> "F";
            };
            // java doesn't support :(  the next switch
//        return switch (average) {
//            case double grade when grade >= 9 -> "A";
//            case double grade when grade >= 8 -> "B";
//            case double grade when grade >= 7 -> "C";
//            case double grade when grade >= 6 -> "D";
//            default -> "F";
//        };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\nEnter student name (or 'exit' to stop): ");
            String nameInput = scanner.nextLine();

            if (nameInput.isEmpty()) {
                System.out.println("Invalid name input! Please try again.");
                continue;
            }
            if (nameInput.equalsIgnoreCase("exit")) {
                System.out.println("Program terminated.");
                break;
            }

            int[] scores = new int[3];
            System.out.print("Enter 3 test scores: ");

            boolean valid = true;
            for (int i = 0; i < 3; i++) {
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input! Restarting...");
                    scanner.nextLine();
                    valid = false;
                    break;
                }
                scores[i] = scanner.nextInt();
            }
            if (!valid) continue;

            System.out.print("Enter attendance percentage: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Restarting...");
                scanner.nextLine();
                continue;
            }

            int attendance = scanner.nextInt();
            scanner.nextLine();

            double average = calculateAverage(scores);
            String grade = getLetterGrade(average);
            String status = evaluateStudent(average, attendance);

            String message = (status.equals("PASS")) ? "→ PASS" :
                    status.equals("RE-EXAM") ? "→ RE-EXAM" : "→ FAIL";

            System.out.printf("Average: %.1f  Grade: %s  %s%n", average, grade, message);
        }
        scanner.close();
    }
}
