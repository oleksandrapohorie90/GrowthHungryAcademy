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
    public static int find2ndMaxNumInArray(int[] array) {

        if (array.length < 2) return -1;

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : array) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num < largest) { //or !=
                secondLargest = num;
            }
        }
        return secondLargest;
    }

    //write a method to implement bubble sort
//    We compare two adjacent elements at a time (arr[j] and arr[j+1]).
//
//    If the left one is bigger, we swap them.
//
//    After the first pass, the largest element will be at the end.
//
//    We repeat for the remaining part of the array, but each time we need one less comparison because the end portion is already sorted.
    public static void bubbleSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {//That’s why each pass needs fewer comparisons — because the largest elements are already at the right end.
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
