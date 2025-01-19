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
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 1) {
                swap(nums, i, pos);
                pos++;
            }
        }

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
