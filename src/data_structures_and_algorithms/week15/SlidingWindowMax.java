package data_structures_and_algorithms.week15;

import java.util.Arrays;

public class SlidingWindowMax {

    public static void main(String[] args) {
        int[] nums = {5,6,7,8,91,2,3,4,5,4};
        int k = 10;
        //debugged
        maxSlidingWindow(nums, k);

    }

    //TODO: go over again line 25-51
    public static int[] maxSlidingWindow(int[] nums, int k) {
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
                if (j % sqrt == 0 && j + sqrt - 1 <= r)  {
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
