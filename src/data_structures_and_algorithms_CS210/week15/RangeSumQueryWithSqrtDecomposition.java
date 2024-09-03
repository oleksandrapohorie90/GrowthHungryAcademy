package data_structures_and_algorithms_CS210.week15;

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

    //T prefix sums: O(n)
    //T sqrt decomposition: O(1)
//    public void update(int index, int new_value) {
//        //in case of prefix sums
//        nums[index] = new_value;
//        pref[0] = nums[0];
//        for i = 1...n - 1
//        pref[i] = pref[i - 1] + nums[i];
//
//        //in case of SQRT decomp - T: O(1)
//        int old_value = nums[index];
//        int block = index / sqrt;
//        block_sum[block] -= old_value;
//        block_sum[block] += new_value;
//        nums[index] = new_value;
//    }

    //T(prefix sums): O(1)
    //T(sqrt decomposition): O(sqrt(n))
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
