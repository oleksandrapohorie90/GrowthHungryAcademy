package java_intro.week2.school.management;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        CourseManager courseManager = new CourseManager();

        Student student1 = new Student("Alex", 18, 12345);
        Student student2 = new Student("Jenna", 17, 54321);
        Student student3 = new Student("Olga", 15, 98765);

        courseManager.addStudent(student1);
        courseManager.addStudent(student2);
        courseManager.addStudent(student3);

        student1.enrollCourse("Algebra");
        student2.enrollCourse("Computer Science");
        student3.enrollCourse("Algebra");

        student1.enrollCourse(new String[]{"Computer Systems", "Discrete Math"});

        student1.displayDetails();
        student1.displayTuition();
        student1.displayEnrolledClasses();

        student2.displayDetails();
        student2.displayTuition();
        student2.displayEnrolledClasses();

        courseManager.displayAllStudents();
        courseManager.removeStudent(student3);
        courseManager.displayAllStudents();

        student1.dropCourse("Algebra");
        student1.displayTuition();
        student1.displayEnrolledClasses();
    }


}
