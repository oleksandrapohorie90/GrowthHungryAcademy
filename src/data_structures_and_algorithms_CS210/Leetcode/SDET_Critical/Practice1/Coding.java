package data_structures_and_algorithms_CS210.Leetcode.SDET_Critical.Practice1;

import java.util.Random;

public class Coding {
    public static void main(String[] args) {
        int[] arr = {1, 2, 7, 5, 6};
        int number = 121;
        System.out.println("Second highest number is: " + secondHighest(arr));
        System.out.println("Is number a palindrome: " + isPalindrome(number));
    }

    //2nd highest number in array
    public static int secondHighest(int[] nums) {
        int highestNumber = Integer.MIN_VALUE;
        int secondHighestNumber = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > highestNumber) {
                secondHighestNumber = highestNumber;
                highestNumber = num;
            } else if (num > secondHighestNumber && num != highestNumber) {
                secondHighestNumber = num;
            }
        }

        return secondHighestNumber;
    }

    //if given number is a palindrome
    public static boolean isPalindrome(int x) {
        int original = x;
        int reversed = 0;

        while (x > 0) {
            reversed = reversed * 10 + x % 10; //give us 1 in the first iteration
            x = x / 10;//to take away the last number
        }
        return original == reversed;
    }

    //av of 3 numbers
    public static double findAverageOfThree(int a, int b, int c) {
        return (a + b + c) / 3.0;
    }

    //is even or odd
    public static boolean isEvenOrOdd(int num) {
        return num % 2 == 0;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    //convertFtoC
    public static int FahrenheitToCelsius(int num) {
        return (num - 32) * 5 / 9;
    }

    //generate random num
    public static int generateRandom(int num) {
        return new Random().nextInt(1, 100);
    }
}
