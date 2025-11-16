package data_structures_and_algorithms_CS210.Leetcode.SDET_Critical.Practice1;

public class Coding {
    public static void main(String[] args) {
        int[] arr = {1, 2, 7, 5, 6};
        int number = 121;
        System.out.println("Second highest number is: " + secondHighest(arr));
        System.out.println("Is number a palindrome: "+ isPalindrome(number));
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

    //av of 3 nums
}
