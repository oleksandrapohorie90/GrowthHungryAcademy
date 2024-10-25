package java_intro.week5;

import java.util.ArrayList;

public class CourseRegistration {
    ArrayList<Student> registeredStudents = new ArrayList<>();
    public void registerStudent(Student student){
        try{
            if(registeredStudents.size()>5){
                throw new CourseFullException("This course is full!");

            }
        }catch (CourseFullException ce){
            System.err.println("An error occurred while registering a student to the course. "+ce.getMessage());
        }
    }
}
