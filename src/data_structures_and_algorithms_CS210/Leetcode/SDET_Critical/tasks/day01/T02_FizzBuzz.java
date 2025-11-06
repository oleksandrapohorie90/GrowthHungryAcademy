package data_structures_and_algorithms_CS210.Leetcode.SDET_Critical.tasks.day01;

public class T02_FizzBuzz {
    public static void main(String[] args) {
        /*
        loop 1- 100
        divisible by 3 and 5 -> FizzBuzz
        divisible by 3 -> Fizz
        divisible by 5 -> Buzz
        print number itself
        */
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}
