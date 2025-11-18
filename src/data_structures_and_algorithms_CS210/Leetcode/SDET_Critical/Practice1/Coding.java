package data_structures_and_algorithms_CS210.Leetcode.SDET_Critical.Practice1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Coding {
    public static void main(String[] args) {
        int[] arr = {1, 2, 7, 5, 6};
        int number = 121;
//        System.out.println("Second highest number is: " + secondHighest(arr));
//        System.out.println("Is number a palindrome: " + isPalindrome(number));
        // System.out.println(reverseString1("AlexaSky"));
        System.out.println("The number of words are: " + countNumberOfWords("I will find a job of my dream this year."));
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

    //reverse string
    public static String reverseString(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }

        return reversed;
    }

    public static String reverseString1(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }

        return sb.toString();
    }

    //count num of words in a given string
    public static int countNumberOfWords(String str) {
        //String[] strArr = str.split(" ");
        //return str.trim().isEmpty() ? 0 : str.trim().split("\\s").length;
        return str.split(" ").length;
    }

    //how to find a leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    //remove duplicates from array
    public static int removeDuplicates(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[left] != nums[right]) {
                left++;
                nums[left] = nums[right];
            }
        }
        return left + 1;
    }

    //fibonacci
    public static int fib(int num) {
        if (num <= 1) return num;
        return fib(num - 1) + fib(num - 2);
    }

    //fizzbuzzz
    public static void fizz_buzz(int num) {
        for (int i = 1; i < num; i++) {
            if (num % 15 == 0) {
                System.out.println("FizzBuzz");
            } else if (num % 3 == 0) {
                System.out.println("Fizz");
            } else if (num % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    //replace a&b without
    public static void replaceA_B(int a, int b) {
        //2 5
        a = a + b;
        b = a - b;//2
        a = a - b; //5
        System.out.print(a + "," + b);
    }

    //filter list without C
    public List<String> filterWithoutC(List<String> list) {
        List<String> originalList = Arrays.asList("Apple", "Banana", "Cherry", "Mango", "Peach", "Grape");
        List<String> filteredList = new ArrayList<>();

        for (String item : originalList) {
            if (!item.toLowerCase().contains("c")) {
                filteredList.add(item);
            }
        }
        System.out.println(filteredList);
        return filteredList;
    }

    public static void printWord(int num) {
        if (num % 5 == 0) {
            System.out.println("ABC");
        } else if (num % 3 == 0) {
            System.out.println("other");
        }
    }
}
