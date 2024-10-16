package java_intro.week4.university_system;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Professor> professors;
    private List<Course> courses;

    public Department(String name) {
        this.name = name;
        this.professors = new ArrayList<>();
        this.courses = new ArrayList<>();
    }
    //we need to add professor to the department first
    public void addProfessor(Professor professor){
        professors.add(professor);
    }

    //we need to add course to the department
    public void addCourse(Course course){
        courses.add(course);
    }

    public String getName() {
        return name;
    }
}

