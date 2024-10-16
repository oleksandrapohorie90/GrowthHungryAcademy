package java_intro.week4.university_system;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private String studentID;
    private List<Course> courses;

    public Student(String name, String studentID) {
        this.name = name;
        this.studentID = studentID;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
