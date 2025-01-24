package data_structures_and_algorithms_CS210.Second_Cohort.week1_arrays;

public class RangeSumQueryImmutable {
    /**
     * Given an integer array nums, handle multiple queries of the following type:
     * <p>
     * Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
     * Implement the NumArray class:
     * <p>
     * NumArray(int[] nums) Initializes the object with the integer array nums.
     * int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input
     * ["NumArray", "sumRange", "sumRange", "sumRange"] <<RangeSumQueryImmutable for NumArray
     * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
     * Output
     * [null, 1, -1, -3]
     */
    public static void main(String[] args) {
        // Step 1: Create an instance of RangeSumQueryImmutable with a test array
        int[] nums = {-2, 0, 3, -5, 2, -1};
        RangeSumQueryImmutable obj = new RangeSumQueryImmutable(nums);

        // Step 2: Call sumRange for various ranges and print the results
        System.out.println("Sum of range (0, 2): " + obj.sumRange(0, 2)); // Output: 1
        System.out.println("Sum of range (2, 5): " + obj.sumRange(2, 5)); // Output: -1
        System.out.println("Sum of range (0, 5): " + obj.sumRange(0, 5)); // Output: -3
    }

    int[] prefix;

    // arr was 1-indexed, but nums is 0-indexed.
    public RangeSumQueryImmutable(int[] nums) {
        int n = nums.length;

        // `prefix` array is 1-indexed because it greatly simplifies computations.
        // If `prefix` array would be 0-indexed, we'd have to always consider the case
        // when i = 0 or left = 0 separately, so that we don't go out-of-bounds.
        prefix = new int[n + 1]; // prefix[0 .. n]

        //            0  1  2   3  4   5
        // nums =   [-2, 0, 3, -5, 2, -1]

        //            0   1   2   3   4   5   6
        // prefix = [ 0, -2, -2,  1, -4, -2, -3]

        // prefix[0] = 0 because it is semantically equal to an empty prefix (which has zero sum).
        prefix[0] = 0;
        for (int i = 1; i <= n; i++) {
            // prefix[i] =
            //             sum(nums[1 .. i - 1]) +
            //             nums[i]
            prefix[i] = prefix[i - 1] + nums[i - 1];

            // nums[i - 1] (not nums[i]) because `nums` array is 0-indexed.
        }
    }

    public int sumRange(int left, int right) {
        // Increment by 1 because `prefix` array is 1-indexed.
        left++;
        right++;

        // nums[left] + ... nums[right]
        // =
        // sum(nums[1 .. right]) -
        // sum(nums[1 .. left - 1]) =
        // sum(nums[left .. right])
        return prefix[right] - prefix[left - 1];
    }
}
/**
 * Your RangeSumQueryImmutable object will be instantiated and called as such:
 * RangeSumQueryImmutable obj = new RangeSumQueryImmutable(nums);
 * int param_1 = obj.sumRange(left,right);
 */

