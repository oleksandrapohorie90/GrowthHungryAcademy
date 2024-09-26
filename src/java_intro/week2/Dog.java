package java_intro.week2;

public class Dog extends Animal{

    public Dog() {
        super();
    }

    @Override
    public void eat() {
        System.out.println("Dog is eating");
    }
}
