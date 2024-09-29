package java_intro.week2.school.management;

import java.util.ArrayList;
import java.util.List;

public class CourseManager {
    private List<Student> students;

    public CourseManager() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    public void displayAllStudents(){
        for(Student student: students){
            student.displayDetails();
        }
    }

}
