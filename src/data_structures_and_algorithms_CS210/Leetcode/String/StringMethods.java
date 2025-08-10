package data_structures_and_algorithms_CS210.Leetcode.String;

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
}
