package java_intro.week7;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private String filePath;

    private void saveStudentsToFile(List<Student> students) throws IOException {
        /**
         * Accept a file path and a list of students.
         * ■ Write each student's data to the specified file, with each student on a
         * new line, separated by commas (e.g., id,name,grade).
         */
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Student student : students) {
                writer.write(student.toString());
                writer.newLine();
            }
        }
    }

    private List<Student> loadStudentsFromFile() throws IOException {
        /**
         * Reads data from the specified file line by line.
         * ■ Parses each line to create a Student object.
         * ■ Adds each Student object to a list and returns the list
         */
        List<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                students.add(Student.fromString(line));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Starting fresh.");
        }
        return students;
    }

    public void displayStudents() throws IOException {
        List<Student> students = loadStudentsFromFile();
        if (students.isEmpty()) {
            System.out.println("No students found");
        } else {
            for (Student student : students) {
                System.out.println("Student's name " + student.getName() + "\nStudent's grade " + student.getGrade() + "\nStudent's ID " + student.getId());
            }
        }
    }

    public void updateGrade(int id, double newGrade) throws IOException {
        /**
         * Loads the list of students from the file.
         * ■ Searches for a student by ID.
         * ■ Updates the student’s grade if the student is found.
         * ■ Saves the updated list back to the file
         */
        List<Student> students = loadStudentsFromFile();
        boolean isFound = false;
        for (Student student : students) {
            if (student.getId() == id) {
                student.setGrade(newGrade);
                isFound = true;
                break;
            }
        }
        if (isFound) {
            saveStudentsToFile(students);
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    //copied
    public void deleteStudent(int id) throws IOException {
        List<Student> students = loadStudentsFromFile();
        students.removeIf(student -> student.getId() == id);
        saveStudentsToFile(students);
        System.out.println("Student with ID " + id + " deleted successfully.");
    }
}
