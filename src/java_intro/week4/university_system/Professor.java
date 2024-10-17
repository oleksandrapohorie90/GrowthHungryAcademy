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

    @Override
    public void conductLecture() {
        System.out.println(name + " is conducting a lecture.");
    }

    public void gradeStudents() {
        System.out.println("Professor " + name + " is grading the students.");
    }

    public String getName() {
        return name;
    }
}
