package data_structures_and_algorithms_CS210.Leetcode.String;

import java.util.HashMap;
import java.util.Map;

public class StringMethods {
//
//    Write a method to reverse a string.**
//    A:
//            ```java
//    public String reverseString(String str) {
//        StringBuilder sb = new StringBuilder(str);
//        return sb.reverse().toString();
//    }
//```
//
//        **Q: Write a class for FizzBuzz**
//            for (int i = 1; i <= 100; i++) {
//        if (i % 3 == 0 && i % 5 == 0) {
//            System.out.println("FizzBuzz");
//        } else if (i % 3 == 0) {
//            System.out.println("Fizz");
//        } else if (i % 5 == 0) {
//            System.out.println("Buzz");
//        } else {
//            System.out.println(i);
//        }
//    }
//
//**Q: Write a method to reverse a sentence.**
//    A:
//            ```java
//    public String reverseSentence(String sentence) {
//        String[] words = sentence.split("\\s+");
//        StringBuilder result = new StringBuilder();
//
//        for (int i = words.length - 1; i >= 0; i--) {
//            result.append(words[i]).append(" ");
//        }
//        return result.toString().trim();
//    }
//```
//
//        **Q: Write a method to find the first non-repeated character.**
//    A:
//            ```java
//"aabccddj" -> b
//    public char firstNonRepeatedChar(String str) {
//        Map<Character, Integer> charCount = new HashMap<>();
//
//        for (char c : str.toCharArray()) {
//            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
//        }
//
//        for (char c : str.toCharArray()) {
//            if (charCount.get(c) == 1) {
//                return c;
//            }
//        }
//        return '\0';
//    }

    //reverse a string
    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();

    }

    //write a class for FizzBuzz
    public static void fizzBuzz(String str) {
        for (int i = 1; i <= 100; i++) { //cant divide by 0
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

    //write a method to reverse a sentence
    public static String reverseSentence(String str) {
        String[] words = str.split("\\s+"); //one or more spaces like \t etc
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]).append(" ");
        }
        return sb.toString().trim();//need a trim since the last word will have a space too
    }

    //write a method to find the first non-repeated character - "aabccddj" -> b
    //If c is in the map → get its count and add 1.
    //If c is not in the map → start from 0 and add 1.
    public static char returnFirstNonRepeated(String str) {
//        Keys → characters in the string
//
//        Values → how many times each character appears
        Map<Character, Integer> countChar = new HashMap<>();

        for (char ch : str.toCharArray()) {
            //charCount.getOrDefault(c, 0) → if c exists in the map, get its count; if not, treat its count as 0.
            //
            //Add 1 to that count.
            //
            //Store the result back into the map.
            countChar.put(ch, countChar.getOrDefault(ch, 0) + 1);
        }
//the first non-repeated character.
// Loop again in original order (important for finding the first one).
//
//Check if the stored count for each char is exactly 1.
//
//As soon as you find it → return it.
//
//In "swiss", counts are {s=3, w=1, i=1}
//
//Check s → count 3 → skip
//
//Check w → count 1 → return 'w'
        for (char ch : str.toCharArray()) {
            if (countChar.get(ch) == 1) {
                return ch;
            }
        }

        return '\0'; //is the null character in Java — a common placeholder to mean “no char found.”
    }

}
