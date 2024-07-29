import java.util.ArrayList;

public class GradeManager {
    private ArrayList<Grade> grades;

    public GradeManager() {
        grades = new ArrayList<>();
    }

    public void addGrade(int id, int grade) {
        grades.add(new Grade(id, grade));
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }
}
