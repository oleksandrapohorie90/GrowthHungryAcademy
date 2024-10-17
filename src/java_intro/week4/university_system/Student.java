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

    public void registerCourse(Course course){
        courses.add(course);
    }

    public String getName() {
        return name;
    }


}
