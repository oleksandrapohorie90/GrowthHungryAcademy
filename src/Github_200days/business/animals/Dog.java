package Github_200days.business.animals;

import Github_200days.business.model.Pet;

import java.time.LocalDate;

public class Dog extends Pet {
    /*
    dog is a type of pet, dog will inherit a property of pet because dog extends property of pet
      */

    public Dog() {
    }

    public Dog(String name, LocalDate dob) {
        super(name, dob);
    }
}