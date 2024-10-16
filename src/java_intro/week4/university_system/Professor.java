package java_intro.week4.university_system;

abstract public class Professor implements Teach {

    private String name;
    private double salary;
    private String department;

    public Professor(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public abstract void teachCourse();
    public abstract void calculateSalary();
}
