package specific.animals;

import model.Pet;

import java.time.LocalDate;

public class Cat extends Pet {

    public void meow() {
        System.out.println("Meow meow");
    }

    //override a toString method
    @Override
    public String toString() {
        return "Cat - name: tony";
    }

    //all classes extend from one parent class if they are not already extending from other.
    //That class is Object-class above all other classes
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        System.out.println(cat1);
    }
}
