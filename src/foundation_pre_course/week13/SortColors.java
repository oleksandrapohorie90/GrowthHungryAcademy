package foundation_pre_course.week13;

import java.util.Arrays;

public class SortColors {
    /*
    Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
     */
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
    }

    public static void sortColors(int[] nums) {

        int pos = 0;
        //First Pass (Placing 0s):
        //
        //Initial pos = 0.
        //Iteration 1 (i = 0): nums[0] = 2 (not < 1), no swap.
        //Iteration 2 (i = 1): nums[1] = 0 (< 1), swap nums[1] and nums[0], resulting in [0, 2, 2, 1, 1, 0], increment pos to 1.
        //Iteration 3 (i = 2): nums[2] = 2 (not < 1), no swap.
        //Iteration 4 (i = 3): nums[3] = 1 (not < 1), no swap.
        //Iteration 5 (i = 4): nums[4] = 1 (not < 1), no swap.
        //Iteration 6 (i = 5): nums[5] = 0 (< 1), swap nums[5] and nums[1], resulting in [0, 0, 2, 1, 1, 2], increment pos to 2.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 1) {
                swap(nums, i, pos);
                pos++;
            }
        }
        //Starting pos = 2.
        //Iteration 1 (i = 2): nums[2] = 2 (not 1), no swap.
        //Iteration 2 (i = 3): nums[3] = 1 (== 1), swap nums[3] and nums[2], resulting in [0, 0, 1, 2, 1, 2], increment pos to 3.
        //Iteration 3 (i = 4): nums[4] = 1 (== 1), swap nums[4] and nums[3], resulting in [0, 0, 1, 1, 2, 2], increment pos to 4.
        //Iteration 4 (i = 5): nums[5] = 2 (not 1), no swap.
        //Output: [0, 0, 1, 1, 2, 2]
        for (int i = pos; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, i, pos);
                pos++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }
}
