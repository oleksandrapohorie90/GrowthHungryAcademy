package Business;

import Business.business.Company;

public class Person {
    //constant
    private final double PI = 3.14;
    private final String MY_BIG_CONSTANT = "Hi , this is my constant message";
    private String firstName = "Jerry";
    private int age;
    private long id; //primitive
    private char middleInitial = 'J';
    private byte myByte;
    private Company company = new Company(); //reference to the company/reference that we use is the address, java system is building the object, company holds the address of where that object lives
    private NewsAgency agency; //reference to an object
    private Company company1 = new Company();

    public void myTestMethod(){
        //only can do for local variables not for instance variables
        var age = 21;
        var name = "Jake";
   }
    //type a string and hold alt + ENTER - to introduce a var
    //alt shift o

}
