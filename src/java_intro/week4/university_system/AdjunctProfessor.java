package java_intro.week4.university_system;

public class AdjunctProfessor extends Professor{

    private int coursesTaught;

    public AdjunctProfessor(String name, int coursesTaught, Department department) {
        super(name, department);
        this.coursesTaught = coursesTaught;
    }

    // ??
    @Override
    public void teachCourse() {

    }

    @Override
    public double calculateSalary() {
    return coursesTaught * 1500;
    }

    public class FullTimeProfessor extends Professor{

        private double monthlySalary;

        public FullTimeProfessor(String name, Department department, double monthlySalary) {
            super(name, department);
            this.monthlySalary = monthlySalary;
        }

        @Override
        public double calculateSalary() {
            return monthlySalary; //fixed monthly salary
        }
    }
}
