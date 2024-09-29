package java_intro.week2.school.management;

import java.util.ArrayList;
import java.util.List;

public class CourseManager {
    private final List<Student> students;

    public CourseManager() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    public void displayAllStudents(){
        System.out.println("There are "+students.size()+" students in total");
        for(Student student: students){
            student.displayDetails();
        }
    }

    public void removeStudent(Student student){
        students.remove(student);
    }
}
