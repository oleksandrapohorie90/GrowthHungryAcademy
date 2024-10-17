package java_intro.week4.university_system;

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
