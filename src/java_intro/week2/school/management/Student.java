package java_intro.week2.school.management;

import java_intro.week2.school.Person;

public class Student extends Person {

    private int studentID;
    private String[] enrolledCourses;
    private double tuition;

    public Student(String name, int age, int studentID) {
        super(name, age);
        this.studentID = studentID;
    }
}
