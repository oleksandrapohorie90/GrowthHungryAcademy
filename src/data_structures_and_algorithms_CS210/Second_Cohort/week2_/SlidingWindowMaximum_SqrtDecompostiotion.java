package data_structures_and_algorithms_CS210.Second_Cohort.week2_;
import java.util.Arrays;

public class SlidingWindowMaximum_SqrtDecompostiotion {
    /*
    You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
//square decomposition is a data structure
        //divide the arr into blocks, for each block we will compute the max number within this block
        //block_max [] - for each block we will compute maximums
        //how to define to which block the current index belong -> int block = i / sqrt;
        // Build sqrt decomposition with operation "max" for nums.
        int n = nums.length;
        int sqrt = (int) Math.ceil(Math.sqrt(n));
        int[] block_max = new int[sqrt];
        Arrays.fill(block_max, Integer.MIN_VALUE);
        for (int i = 0; i < n; i++) {
            int block = i / sqrt;
            block_max[block] = Math.max(block_max[block], nums[i]);
        }

        // Create the array of maximums of each window.
        // When k = 1, its size is n
        // When k = 2, its size is n-1
        // ... and so on ...
        // When k = n, its size is 1
        int[] results = new int[n - k + 1];

        for (int i = 0; i + k - 1 < n; i++) {
            // Current window boundaries a[i .. i+k-1].
            // When k = 1, it is just a[i]
            // When k = 2, it is a[i .. i+1]
            // ... and so on ...
            // When k = n, it is the whole array a[0 .. n-1]
            int l = i;
            int r = i + k - 1;

            // We want to compute max(a[l .. r])
            int result = Integer.MIN_VALUE;
            for (int j = l; j <= r; ) {
                if (j % sqrt == 0 && j + sqrt - 1 <= r) {
                    int block = j / sqrt;
                    result = Math.max(result, block_max[block]);
                    j += sqrt;
                } else {
                    result = Math.max(result, nums[j]);
                    j++;
                }
            }

            // Save max of current window a[i .. i+k-1] to results[i]
            // results[i] = max(a[i .. i+k-1])
            results[i] = result;
        }
        return results;
    }
}

