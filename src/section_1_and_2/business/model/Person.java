package section_1_and_2.business.model;

import java.time.LocalDate;

public class Person {
    /* OOP
     */
    public Person() {

    }

    private String firstName;
    private String lastName;
    private LocalDate dob;
    private Address address;
    private Person spouse;
    private Pet pet;
    private String middleName = "Christopher";
//methods that do not return any values - constructors
    //no inputs needed
    //not good to use no arg constructor, must have arguments
    //private Person() {  }

    //Java will give free no arg default constructor, asap you create any other constr with arguments-java won't create a no arg constr for me

    public Person(String firstName, String lastName, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }


    public static void main(String[] args) {
        Person p1 = new Person();
        p1.firstName = "Jake";
        p1.lastName = "Smith";
    }

    public String getFirstName() {
        return firstName.substring(0,1).toUpperCase()+firstName.substring(1);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.substring(0,1).toUpperCase() + lastName.substring(1);
    }//internal to the class - this

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Person getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    //standard method that comes automatically with Java, will print memory location, but we want to override
    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", address=" + address +
                ", spouse=" + spouse +
                ", pet=" + pet +
                '}';
    }
}
