package data_structures_and_algorithms.week14;

public class RangeSumQueryImmutable {
    /**
     * NOTE: need to revisit, not clear
     */

    int[] prefix;

    //IDEA: prefix sums -> O(n)
    //prefix is some number of 1st characters of the word
    //arr was 1-indexed, but nums is 0-indexed
    public RangeSumQueryImmutable(int[] nums) {
        int n = nums.length;
        //prefix array is 1-indexed because it greatly simplifies computations.
        //If prefix array would be 0-indexed, we'd have to always consider the case
        //when i=0 or left=0 separately, so that we dont go out-of-bounds
        prefix = new int[n + 1];
        //       0 1 2 3 4 5
        //nums= -2 0 3-5 2-1
        //prefix=


        //prefix [0] = 0 bc its semantically equal to an empty prefix(which has zero sum)
        prefix[0] = 0;
        for (int i = 1; i <= n; i++) {
            //prefix[i] =
            //            sum(nums[1..i-1])+
            //            nums[i]
            prefix[i] = prefix[i - 1] + nums[i - 1];

            //nums[i-1] (not nums[i]) because 'nums' array is 0-indexed
        }
    }

    public int sumRange(int left, int right) {
        //increment by 1 because 'prefix' array is 1-indexed
        left++;
        right++;

        //sum(nums[1..right]) -
        //sum(nums[1..left-1]) =
        //sum(nums[left..right])
        return prefix[right] - prefix[left - 1];
    }

}
