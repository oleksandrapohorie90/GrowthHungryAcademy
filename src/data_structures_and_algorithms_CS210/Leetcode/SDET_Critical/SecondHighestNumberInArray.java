package data_structures_and_algorithms_CS210.Leetcode.SDET_Critical;

public class SecondHighestNumberInArray {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6};

        System.out.println(secondHighestNumberInArray(arr));
        System.out.println(secondMax(arr));
    }

    public static int secondHighestNumberInArray(int[] arr) {

        int highestNumber = Integer.MIN_VALUE, secondHighestNumber = Integer.MIN_VALUE;

        for (int j : arr) {
            if (j > highestNumber) {
                highestNumber = j;
            }
        }

        for (int i : arr) {
            if (i > secondHighestNumber && i < highestNumber) {
                secondHighestNumber = i;
            }
        }
        return secondHighestNumber;
    }

    public static int secondMax(int[] nums) {
        //1, 2, 3, 4, 5, 6
        int max = Integer.MIN_VALUE, second = Integer.MIN_VALUE;

        for (int i : nums) {
            if (i > max) {
                second = max;
                max = i;
            } else if (i > second && i != max) {
                second = i;
            }
        }
        return second;
    }

    /*
     if (arr.length < 2) return -1;

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
        return secondLargest;
    }
     */

}
