package java_intro.week2.school.management;

import java_intro.week2.school.Person;

public class Student extends Person {

    private int studentID;
    private String[] enrolledCourses;
    private double tuition;

    public Student(String name, int age, int studentID) {
        super(name, age);
        this.studentID = studentID;
        this.enrolledCourses = new String[100];
    }

    public double getTuition() {
        return tuition;
    }

    private void setTuition(double tuition) {
        this.tuition = tuition;
    }

    public void calculateTuition(){
        int numberOfCourses = 0;
        for(String course: enrolledCourses){
            if(course!=null){
                numberOfCourses++;
            }
        }
        this.tuition = numberOfCourses * 500;
    }

    public void enrollCourse(String[] enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
        calculateTuition();
    }

    public void enrollCourse(String courseName) {
        for (int i = 0; i < enrolledCourses.length; i++) {
            if(enrolledCourses != null) {
                this.enrolledCourses[i] = courseName;
                break;
            }
        }
        calculateTuition();
    }

}
