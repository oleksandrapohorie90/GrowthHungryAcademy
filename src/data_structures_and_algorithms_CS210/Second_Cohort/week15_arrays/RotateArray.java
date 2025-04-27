package data_structures_and_algorithms_CS210.Second_Cohort.week15_arrays;

import java.util.Arrays;

public class RotateArray {

    /**
     * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [1,2,3,4,5,6,7], k = 3
     * Output: [5,6,7,1,2,3,4]
     * Explanation:
     * rotate 1 steps to the right: [7,1,2,3,4,5,6]
     * rotate 2 steps to the right: [6,7,1,2,3,4,5]
     * rotate 3 steps to the right: [5,6,7,1,2,3,4]
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 4;

        rotate(nums, k);
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n; //length=7, 3*2=6, 7-6=1 remainder
        System.out.println("Initial array is " + Arrays.toString(nums));
        //rotate the whole arr first
        reverse(nums, 0, nums.length - 1);
        System.out.println("Rotated whole array: "+ Arrays.toString(nums));
        //rotate only first k numbers
        reverse(nums, 0, k - 1);
        System.out.println("Rotated k-th number of array: "+Arrays.toString(nums));
        //rotate the rest of the array after last number of k number
        reverse(nums, k, nums.length - 1);
        System.out.println("Rotated the rest of the array after k-th number: "+Arrays.toString(nums));
    }


    public static void reverse(int[] nums, int start, int end) {
        //why start<end and not start<=end
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }


    }


}
