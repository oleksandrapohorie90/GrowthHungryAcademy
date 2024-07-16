package data_structures_and_algorithms.Leetcode;

import java.util.Arrays;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int index = 0;

        // Move all non-zero elements to the beginning
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        // Fill the remaining elements with zeroes
        while (index < nums.length) {
            nums[index++] = 0;
        }

        System.out.println(Arrays.toString(nums));
    }
}
