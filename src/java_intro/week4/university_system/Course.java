package java_intro.week4.university_system;

import java.util.HashMap;
import java.util.Map;

public class Course {

    private String courseName;
    private int creditHours;
    private int amountOfStudents;

    private Map<Student,Integer> studentGrade;

    public Course(String courseName, int creditHours) {
        this.courseName = courseName;
        this.creditHours = creditHours;
        this.studentGrade = new HashMap<>();
    }

    public void registerStudent(Student student) {
        studentGrade.put(student, null); // No grade initially
    }

    public void assignGrade(Student student, int grade) {
        studentGrade.put(student, grade);
    }

    public String getCourseName() {
        return courseName;
    }

}
