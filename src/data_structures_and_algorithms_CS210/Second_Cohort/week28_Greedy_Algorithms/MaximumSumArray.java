package data_structures_and_algorithms_CS210.Second_Cohort.week28_Greedy_Algorithms;

public class MaximumSumArray {
    public int maxSubArray(int[] nums) {
        //                 0   1    2   3   4    5    6    7   8
        // nums        = [     2,  -3,  4, -2,  -3,   1,  -1,  4]
        // prefix_sums = [ 0,  2,  -1,  3,  1,  -2,  -1,  -2,  2]
        //
        // index = 0  ->  prefix_sums[0] =  0; // []
        // index = 1  ->  prefix_sums[1] =  2; // [2]
        // index = 2  ->  prefix_sums[2] = -1; // [2, -3]

        // index = 3  ->  prefix_sums[3] =  3; // [2, -3, 4]
        //    improvable: prefix_sums[3] - prefix_sums[2] = 3 - (-1) = 4
        //                [2, -3, 4] - [2, -3] = [4]

        // index = 4  ->  prefix_sums[4] =  1; // [2, -3, 4, -2]
        //    improvable: prefix_sums[4] - prefix_sums[2] = 1 - (-1) = 2
        //                [2, -3, 4, -2] - [2, -3] = [4, -2]

        // index = 5  ->  prefix_sums[5] = -2; // [2, -3, 4, -2, -3]
        //    improvable: prefix_sums[5] - prefix_sums[2] = -2 - (-1) = -1
        //                [2, -3, 4, -2, -3] - [2, -3] = [4, -2, -3]

        // index = 6  ->  prefix_sums[6] = -1; // [2, -3, 4, -2, -3, 1]
        //    improvable: prefix_sums[6] - prefix_sums[5] = -1 - (-2) = 1
        //                [2, -3, 4, -2, -3, 1] - [2, -3, 4, -2, -3] = [1]

        /*
        int n = nums.length;
        int[] prefix_sums = new int[n + 1];

        prefix_sums[0] = 0;
        for (int i = 1; i <= n; i++) {
            prefix_sums[i] = prefix_sums[i - 1] + nums[i - 1];
        }

        int answer = Integer.MIN_VALUE; // -2147483648 == -2^31
                                        //  2147483647 ==  2^31 - 1
                                        // [-2^31; 2^31 - 1] => exactly 2^32 numbers in that range
                                        // long
                                        // [-2^63; 2^63 - 1] => exactly 2^64 numbers in that range
        int min_prefix_sum_so_far = prefix_sums[0];
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, prefix_sums[i] - min_prefix_sum_so_far);
            min_prefix_sum_so_far = Math.min(min_prefix_sum_so_far, prefix_sums[i]);
        }
        */

        int best_sum = Integer.MIN_VALUE;
        int current_sum = 0;
        for (int num : nums) {
            current_sum += num;
            best_sum = Math.max(best_sum, current_sum);
            if (current_sum < 0) {
                current_sum = 0;
            }
        }
        return best_sum;
    }
}
