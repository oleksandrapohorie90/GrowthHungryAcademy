package foundation_pre_course.week12;

import java.util.Arrays;

public class PartitionArrayAccordingToGivenPivot {
    //partition an array into 3 blocks according to pivot
    /*
    You are given a 0-indexed integer array nums and an integer pivot. Rearrange nums such that the following conditions are satisfied:

Every element less than pivot appears before every element greater than pivot.
Every element equal to pivot appears in between the elements less than and greater than pivot.
The relative order of the elements less than pivot and the elements greater than pivot is maintained.
More formally, consider every pi, pj where pi is the new position of the ith element and pj is the new position of the jth element. For elements less than pivot, if i < j and nums[i] < pivot and nums[j] < pivot, then pi < pj. Similarly for elements greater than pivot, if i < j and nums[i] > pivot and nums[j] > pivot, then pi < pj.
Return nums after the rearrangement.

Example 1:
Input: nums = [9,12,5,10,14,3,10], pivot = 10
Output: [9,5,3,10,10,12,14]
Explanation:
The elements 9, 5, and 3 are less than the pivot so they are on the left side of the array.
The elements 12 and 14 are greater than the pivot so they are on the right side of the array.
The relative ordering of the elements less than and greater than pivot is also maintained. [9, 5, 3] and [12, 14] are the respective orderings.
     */
    public static void main(String[] args) {
        int [] arr = {9,12,5,10,14,3,10};
        int pivot = 10;

        System.out.println(Arrays.toString(pivotArray(arr, pivot)));
    }

    public int[] pivotArray2(int[] nums, int pivot) {
        int n = nums.length;

        int[] result = new int[n];
        int insertPosition = 0;

        // The idea is that after partitioning,
        // the array will be split into three blocks:
        // [(numbers < pivot), (numbers == pivot), (numbers > pivot)].

        // Firstly, put all (numbers < pivot)
        // at the beginning of the result array.
        // Count the # of (numbers == pivot) in the process.
        int pivotFreq = 0;
        for (int num : nums) {
            if (num < pivot) {
                result[insertPosition] = num;
                insertPosition++;
            } else if (num == pivot) {
                pivotFreq++;
            }
        }

        // After all (numbers < pivot), we shall
        // insert all pivots [now that we know the
        // # of (numbers == pivot), it is easy to do].
        while (pivotFreq > 0) {
            result[insertPosition] = pivot;
            insertPosition++;
            pivotFreq--;
        }

        // After that, insert the rest, i.e. all (numbers > pivot).
        for (int num : nums) {
            if (num > pivot) {
                result[insertPosition] = num;
                insertPosition++;
            }
        }

        return result;
    }

    public static int[] pivotArray(int[] nums, int pivot) {
        int insert_position = 0;
        int pivotFrequency = 0;
        int[] result = new int[nums.length];

        //we neeed to count nums that are equal to pivot
        for (int n : nums) {
            if (n < pivot) {
                result[insert_position] = n;
                insert_position++;
            } else if (n == pivot) {
                pivotFrequency++;
            }
        }

        //to account for nums that equal pivot
        while (pivotFrequency > 0) {
            result[insert_position] = pivot;
            insert_position++;
            pivotFrequency--;
        }

        for (int n : nums) {
            if (n > pivot) {
                result[insert_position] = n;
                insert_position++;
            }
        }
        return result;
    }
}
