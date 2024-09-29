package java_intro.week2.school.management;

public class Main {

    public static void main(String[] args) {

        Student student1 = new Student("Alex",18, 12345);
        Student student2 = new Student("Jenna",17, 54321);
        Student student3 = new Student("Olga",15, 98765);

        student1.enrollCourse("Algebra");
        student2.enrollCourse("Computer Science");
        student3.enrollCourse("Algebra");

        student1.enrollCourse(new String[]{"Computer Systems", "Discrete Math"});

        student1.displayDetails();


    }



}
