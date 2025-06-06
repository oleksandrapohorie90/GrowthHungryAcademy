package data_structures_and_algorithms_CS210.Second_Cohort.week19_twoPointers_slidingWindow;

import java.util.Arrays;

public class MoveZeroes {
    /**
     * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     * <p>
     * Note that you must do this in-place without making a copy of the array.
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     * Example 2:
     * <p>
     * Input: nums = [0]
     * Output: [0]
     */
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
    }

    public static void moveZeroes(int[] nums) {
        //you will have 2 pointers, 1 is at the beginning and up, 2nd is pointing at the position where next non zero element should land, so I see a 0-skip, then I see non zero - insert in nums[0] position and increment, so just overwrite
        if (nums == null || nums.length == 0) {
            return;
        }

        int insertPosition = 0;
        //fill out all the non zeroes elements in the beginning
        for (int x : nums) {
            if (x != 0) {
                nums[insertPosition] = x;
                insertPosition++;
            }
        }
        //take care of 0's and put them at the end
        while (insertPosition < nums.length) {
            nums[insertPosition] = 0;
            insertPosition++;
        }

        System.out.println(Arrays.toString(nums));
    }

//    public static void swap(int i, int j) {
//        int a = i;
//        i = j;
//        j = a;
//    }
}
