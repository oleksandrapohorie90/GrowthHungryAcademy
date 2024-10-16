package java_intro.week4.university_system;

public class Course {

    private String courseName;
    private int creditHours;
    private int amountOfStudents;

    public Course(String courseName, int creditHours, int amountOfStudents) {
        this.courseName = courseName;
        this.creditHours = creditHours;
        this.amountOfStudents = amountOfStudents;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public int getAmountOfStudents() {
        return amountOfStudents;
    }

    public void setAmountOfStudents(int amountOfStudents) {
        this.amountOfStudents = amountOfStudents;
    }
}
