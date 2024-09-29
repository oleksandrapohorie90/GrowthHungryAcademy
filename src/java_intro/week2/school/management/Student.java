package java_intro.week2.school.management;

import java_intro.week2.school.Person;

import java.util.Arrays;

public class Student extends Person {

    private int studentID;
    private String[] enrolledCourses;
    private double tuition;

    public Student(String name, int age, int studentID) {
        super(name, age);
        this.studentID = studentID;
        this.enrolledCourses = new String[10];
    }

    public double getTuition() {
        return tuition;
    }

//    public void setTuition(double tuition) {
//        this.tuition = tuition;
//    }

    public void calculateTuition() {
        int numberOfCourses = 0;
        for (String course : this.enrolledCourses) {
            if (course != null) {
                numberOfCourses++;
            }
        }
        this.tuition = numberOfCourses * 500;
    }

    public void enrollCourse(String[] enrolledCourses) {
        for (String course : enrolledCourses) {
            enrollCourse(course);
        }
    }

    public void enrollCourse(String courseName) {
        for (int i = 0; i < enrolledCourses.length; i++) {
            if (enrolledCourses[i] == null) {
                this.enrolledCourses[i] = courseName;
                break;
            }
        }
        calculateTuition();
        System.out.println("Student was enrolled in the course " + courseName);
    }

    public void dropCourse(String courseName) {
        for (int i = 0; i < enrolledCourses.length; i++) {
            if (courseName.equals(enrolledCourses[i])) {
                enrolledCourses[i] = null;
                calculateTuition();
                System.out.println("Student was removed from the course " + courseName);
                return; // Exit the method once the course is found and removed
            }
        }
        System.out.println("Course " + courseName + " not found for this student.");

    }

    public void displayTuition() {
        System.out.println("Tuition: $" + getTuition());
    }

    public void displayEnrolledClasses() {
        System.out.println("Student: " + name + " is enrolled in these courses: " + Arrays.toString(enrolledCourses));
    }

}
