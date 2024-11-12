package java_intro.week7;

public class Student {
    private int id;
    private String name;
    private double grade;
    private int age;

    public Student(int id, String name, int age, double grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", age=" + age +
                '}';
    }

    public static Student fromString(String data) {
        String[] fields = data.split(","); //to separate values from fields
        int id = Integer.parseInt(fields[0]);
        String name = fields[1];
        int age = Integer.parseInt(fields[2]);
        double grade = Double.parseDouble(fields[3]);
        return new Student(id, name, age, grade);
    }
}
