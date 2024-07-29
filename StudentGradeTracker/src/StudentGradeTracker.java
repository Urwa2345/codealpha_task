import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {
        GradeManager gradeManager = new GradeManager();
        GradeCalculator gradeCalculator = new GradeCalculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter student IDs and grades. Type '-1' to finish.");

        while (true) {
            System.out.print("Enter student ID: ");
            int id = scanner.nextInt();
            if (id == -1) {
                break;
            }
            System.out.print("Enter grade: ");
            int grade = scanner.nextInt();
            gradeManager.addGrade(id, grade);
        }

        if (gradeManager.getGrades().isEmpty()) {
            System.out.println("No grades entered.");
        } else {
            double average = gradeCalculator.calculateAverage(gradeManager.getGrades());
            Grade highestGrade = gradeCalculator.findHighest(gradeManager.getGrades());
            Grade lowestGrade = gradeCalculator.findLowest(gradeManager.getGrades());

            System.out.println("Average grade: " + average);
            System.out.println("Highest grade: " + highestGrade.getGrade() + " (ID: " + highestGrade.getId() + ")");
            System.out.println("Lowest grade: " + lowestGrade.getGrade() + " (ID: " + lowestGrade.getId() + ")");
        }

        scanner.close();
    }
}
