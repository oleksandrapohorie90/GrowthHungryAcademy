package java_intro.week5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CourseRegistration courseRegistration = new
                CourseRegistration();
        while (courseRegistration.getRegisteredCount() < 5) {
            System.out.println("Enter student name: ");
            String name = scanner.nextLine();
            System.out.println("Enter student age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            try {
                Student student = new Student(name, age);
                courseRegistration.registerStudent(student);
            } catch (InvalidNameException | InvalidAgeException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (CourseFullException ce) {
                System.err.println("An error occurred while registering a student to the course. " + ce.getMessage());
            }
        }
        System.out.println("Registration process completed.");
        scanner.close();
    }
}

