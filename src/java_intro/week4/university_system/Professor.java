package java_intro.week4.university_system;

abstract public class Professor implements Teach {

    private String name;
    private double salary;
    private String department;

    public abstract void teachCourse();
    public abstract void calculateSalary();
}
