package java_intro.week5;

public class Student {
    private String name;
    private int age;

    public Student(String name, int age) throws InvalidNameException, InvalidAgeException , CourseFullException{

        if (name == null || name.isEmpty()) {
            throw new InvalidNameException("Name cannot be null or empty.");
        }
        if (age < 18 || age > 60) {
            throw new InvalidAgeException("Age must be between 18 and 60.");
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}


