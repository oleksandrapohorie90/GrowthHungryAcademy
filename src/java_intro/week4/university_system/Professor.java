package java_intro.week4.university_system;

abstract public class Professor implements Teach, Evaluatable {

    private String name;
    private double salary;
    private Department department;

    public Professor(String name, Department department) {
        this.name = name;
        this.department = department;
    }
    public abstract double calculateSalary();
    public void teachCourse() {
        System.out.println("Professor " + name + " is teaching the course.");
    }
    public void gradeStudents() {
        System.out.println("Professor " + name + " is grading the students.");
    }

    public String getName() {
        return name;
    }
}
