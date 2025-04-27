package data_structures_and_algorithms_CS210.Second_Cohort.week15_arrays;

import java.util.Arrays;

public class SortColors {

    /**
     * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
     * <p>
     * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
     * <p>
     * You must solve this problem without using the library's sort function.
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [2,0,2,1,1,0]
     * Output: [0,0,1,1,2,2]
     * Example 2:
     * <p>
     * Input: nums = [2,0,1]
     * Output: [0,1,2]
     */
    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        sortColors(arr);
    }

    //Dutch National flag algorithm: red, white, blue
    public static void sortColors(int[] nums) {

        int insert_position = 0;
        System.out.println("Input arr before sort: " + Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 1) {
                swap(nums, i, insert_position);
                insert_position++;
            }
        }

        for (int i = insert_position; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, i, insert_position);
                insert_position++;
            }
        }

        System.out.println("Input arr after sort: " + Arrays.toString(nums));

    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
