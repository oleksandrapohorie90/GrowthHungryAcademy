package data_structures_and_algorithms_CS210.Leetcode.Arrays;

public class ArrayMethods {
//    **Q: Write a method to find the maximum number in an array.**
//    A:
//            ```java
//    public int findMaxNumber(int[] arr) {
//        if (arr.length == 0) return -1;
//
//        int max = arr[0];
//        for (int num : arr) {
//            if (num > max) {
//                max = num;
//            }
//        }
//        return max;
//    }
//```
//
//        **Q: Write a method to find the second largest number in an array.**
//    A:
//            10, 4, 5, 7, 0 -> 7
//            ```java
//    public int findSecondLargest(int[] arr) {
//        if (arr.length < 2) return -1;
//
//        int largest = Integer.MIN_VALUE;
//        int secondLargest = Integer.MIN_VALUE;
//
//        for (int num : arr) {
//            if (num > largest) {
//                secondLargest = largest;
//                largest = num;
//            } else if (num > secondLargest && num != largest) {
//                secondLargest = num;
//            }
//        }
//        return secondLargest;
//    }
//```
//
//        **Q: Write a method to implement bubble sort.**
//    A:
//            ```java
//    public void bubbleSort(int[] arr) {
//        int n = arr.length;
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = 0; j < n - i - 1; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }
//    }

    //write a method to find max num in the array
    public static int findMaxNumInArray(int[] array) {

        if (array.length == 0) return -1;
        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    //write a method to find the second largest number in an array.
}
