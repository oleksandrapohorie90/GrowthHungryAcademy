package data_structures_and_algorithms_CS210.Second_Cohort.week1_arrays;

import java.util.Arrays;

public class SortArrayByParityII {

    /**
     * Given an array of integers nums, half of the integers in nums are odd, and the other half are even.
     * <p>
     * Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.
     * <p>
     * Return any answer array that satisfies this condition.
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [4,2,5,7]
     * Output: [4,5,2,7]
     * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
     * Example 2:
     * <p>
     * Input: nums = [2,3]
     * Output: [2,3]
     */
    public static void main(String[] args) {
        int[] nums = {4, 2, 5, 7};
        System.out.println(Arrays.toString(sortArrayByParityII(nums)));

        /**
         * nums = [4, 1, 2, 3]
         * Initial State:
         *
         * i = 0, n = 4.
         * First Iteration:
         *
         * nums[0] = 4, and 4 % 2 == 0 (even, valid).
         * Move to the next even index: i += 2 → i = 2.
         * Second Iteration:
         *
         * nums[2] = 2, and 2 % 2 == 0 (even, valid).
         * Move to the next even index: i += 2 → i = 4.
         * End of Loop:
         *
         * i = 4, which is equal to n.
         * The loop stops.
         */
    }

    public static int[] sortArrayByParityII(int[] nums) {

        int i = 0;
        int j = 1;
        int n = nums.length;

        while (i < n && j < n) {
            while (i < n && nums[i] % 2 == 0) {
                i += 2;
            }
            while (j < n && nums[j] % 2 == 1) {
                j += 2;
            }
            /**
             * Why is if (i < n && j < n) Necessary?
             * Avoid Index Out of Bounds Errors:
             *
             * Both i and j are incremented within the loops (i += 2, j += 2).
             * It's possible for i or j to go out of bounds (become greater than or equal to n) while searching for invalid indices.
             * If either index is out of bounds and we try to access nums[i] or nums[j], it will cause an ArrayIndexOutOfBoundsException.
             * Ensure Valid Indices for Swapping:
             *
             * The program should only attempt to swap values if both i and j point to valid indices within the array.
             * If one of them is out of bounds, a swap isn't needed or possible.
             */
            if (i < n && j < n) {
                swap(nums, i, j);
            }
            /**
             * Why Is if (i < n && j < n) Important?
             * At this point:
             *
             * i = 4 (equal to n, out of bounds).
             * j = 5 (greater than n, out of bounds).
             * Without the guard condition:
             *
             * java
             * Copy
             * Edit
             * if (i < n && j < n) {
             *     swap(nums, i, j);
             * }
             * The program would attempt:
             *
             * java
             * Copy
             * Edit
             * swap(nums, 4, 5); // Invalid indices!
             * This would cause an ArrayIndexOutOfBoundsException.
             */
        }



        return nums;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
