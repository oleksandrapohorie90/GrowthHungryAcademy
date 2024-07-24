package data_structures_and_algorithms.week15;

public class RangeSumQueryWithSqrtDecomposition {

    int n;
    int sqrt;
    int[] nums;
    int[] block_sum;

    public RangeSumQueryWithSqrtDecomposition(int n, int sqrt, int[] nums, int[] block_sum) {
        this.n = nums.length;
        this.sqrt = (int) Math.ceil(Math.sqrt(nums.length));
        this.nums = nums;
        this.block_sum = new int[sqrt];

        for (int i = 0; i < n; i++) {
            block_sum[i / sqrt] += nums[i];
        }
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            if (i % sqrt == 0 && i + sqrt - 1 <= right) {
                sum += block_sum[i / sqrt];
                i += sqrt;
            } else {
                sum += nums[i];
                i++;
            }
        }
        return sum;
    }
}
