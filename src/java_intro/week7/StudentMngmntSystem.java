package java_intro.week7;

import java.io.IOException;
import java.util.Scanner;

public class StudentMngmntSystem {
    public static void main(String[] args) {
        String filePath = "/Users/alexasky111/IdeaProjects/GrowthHungryAcademy/src/java_intro/week7/AllStudents.txt";
        StudentManager manager = new StudentManager(filePath);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = scanner.nextInt();
                        System.out.print("Enter name: ");
                        String name = scanner.next();
                        System.out.print("Enter age: ");
                        int age = scanner.nextInt();
                        System.out.print("Enter grade: ");
                        double grade = scanner.nextDouble();
                        Student newStudent = new Student(id, name, age, grade);
                        manager.addStudent(newStudent);
                        System.out.println("Student added successfully.");
                        break;
                    case 2:
                        manager.displayStudents();
                        break;
                    case 3:
                        System.out.print("Enter ID of student to update: ");
                        id = scanner.nextInt();
                        System.out.print("Enter new age: ");
                        age = scanner.nextInt();
                        System.out.print("Enter new grade: ");
                        grade = scanner.nextDouble();
                        manager.updateGrade(id, grade);
                        break;
                    case 4:
                        System.out.print("Enter ID of student to delete: ");
                        id = scanner.nextInt();
                        manager.deleteStudent(id);
                        break;
                    case 5:
                        System.out.println("Exiting the system. Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option. Please choose again.");
                }
            } catch (IOException e) {
                System.err.println("Error managing students: " + e.getMessage());
            }
        }
    }
}
