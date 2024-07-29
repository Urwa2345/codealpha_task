import java.util.ArrayList;

public class GradeCalculator {

    public double calculateAverage(ArrayList<Grade> grades) {
        int sum = 0;
        for (Grade grade : grades) {
            sum += grade.getGrade();
        }
        return (double) sum / grades.size();
    }

    public Grade findHighest(ArrayList<Grade> grades) {
        Grade highest = grades.get(0);
        for (Grade grade : grades) {
            if (grade.getGrade() > highest.getGrade()) {
                highest = grade;
            }
        }
        return highest;
    }

    public Grade findLowest(ArrayList<Grade> grades) {
        Grade lowest = grades.get(0);
        for (Grade grade : grades) {
            if (grade.getGrade() < lowest.getGrade()) {
                lowest = grade;
            }
        }
        return lowest;
    }
}
