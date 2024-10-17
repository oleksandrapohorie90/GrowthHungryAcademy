package java_intro.week4.university_system;

public class AdjunctProfessor extends Professor {

    private int coursesTaught;

    public AdjunctProfessor(String name, Department department, int coursesTaught) {
        super(name, department);
        this.coursesTaught = coursesTaught;
    }

    @Override
    public double calculateSalary() {
        return coursesTaught * 1500;
    }
}

