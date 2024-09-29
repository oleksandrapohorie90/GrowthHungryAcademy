package java_intro.week2.school;

public class Person {
    public String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayDetails() {
        System.out.println("This is the student's name: " + name + "\nThis is the student's age: " + age);
    }
}
