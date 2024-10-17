package java_intro.week4.university_system;

public class Main {
    public static void main(String[] args) {
        Department compSci = new Department("Computer Science");

        FullTimeProfessor profSmith = new FullTimeProfessor("Dr. John Smith", compSci, 4000);
        AdjunctProfessor profJones = new AdjunctProfessor("Prof. Emily Jones", compSci, 3);

        compSci.addProfessor(profSmith);
        compSci.addProfessor(profJones);

        Course dataStructures = new Course("Data Structures", 3);
        Course algorithms = new Course("Algorithms", 4);

        compSci.addCourse(dataStructures);
        compSci.addCourse(algorithms);

        Student studentJane = new Student("Jane Doe", "ED1001");
        Student studentMark = new Student("Mark Lee", "NI1002");

        dataStructures.registerStudent(studentJane);
        dataStructures.registerStudent(studentMark);

        dataStructures.assignGrade(studentJane, 85);
        dataStructures.assignGrade(studentMark, 90);

        studentJane.registerCourse(dataStructures);
        studentMark.registerCourse(dataStructures);

    }
}
