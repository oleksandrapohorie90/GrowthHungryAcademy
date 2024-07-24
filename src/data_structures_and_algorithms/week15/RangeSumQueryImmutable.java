package data_structures_and_algorithms.week15;

public class RangeSumQueryImmutable {

    //initial array
    int[] nums;

    //apply the prefix sums
    public RangeSumQueryImmutable(int[] nums) {
        //transfor nums array into prefix sum array
        for (int i = 0; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        return nums[right] - (left == 0 ? 0 : nums[left - 1]);
    }
}
