package business;

public class Person {
    //object is an instance of the class
    //class is a blueprint of an object
    //type a string and hold alt + ENTER - to introduce a var
    //alt shift o
    //method - block of code where work gets done, line of code btw curly braces, can take 0,1 inputs and one output
    //method is a function, all code has to live in a class, a method is a function that a part of the class
    //function within a class-method
    private String middleName = "Christopher";
    public static double PI = 3.14; //constant, it will never change, no matter how many instances we create of the class, PI will never change
    //classes get one copy of the static variable, they share the same copy
    public static int[] nums = initNums();

    static {
        nums = new int[5];
        nums[0] = 3;
        nums[1] = 3;
        nums[2] = 3;
        nums[3] = 3;
        nums[4] = 3;
    }

    public static int[] initNums() {
        int[] nums = new int[5];
        nums[0] = 3;
        nums[1] = 3;
        nums[2] = 3;
        nums[3] = 3;
        nums[4] = 3;
        return nums;
    }

    public void sayHello() {
        System.out.println("Hello"); //statement/command
        //void - doesn't return any data
        //no output from the method
    }

    public void saySomething(String message) {
        System.out.println(message);
    }

    public char getMiddleInitial() {
        return middleName.charAt(0);
    }

    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public void test(String[] words) {
        // do smth clever with words
    }

    public void test1(String... words) {
        // do smth clever data type var
    }

    //var args is really just an arrays
    public static void main(String[] args) {
        Person p1 = new Person(); //store reference of an obj to p1
        p1.sayHello(); //I refer to this person and want to execute it
        p1.saySomething("My groovy message");
        char middleInitial = p1.getMiddleInitial();
        System.out.println(p1.getMiddleInitial());
        System.out.println(p1.add(5, 3));
        String[] words = new String[]{"one", "two"};
        p1.test(words);
        p1.test1("one", "two", "three");
        System.out.println(PI);
    }


}
