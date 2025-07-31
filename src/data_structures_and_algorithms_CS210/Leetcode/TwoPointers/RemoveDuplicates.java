package data_structures_and_algorithms_CS210.Leetcode.TwoPointers;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        /**
         nums = [0,1,2,3,4,2,2,3,3,4]
         nums = [                   ]
         */
        int left = 1;
        for(int right = 1; right<nums.length; right++){
            if(nums[right] != nums[right-1]){
                nums[left] = nums[right];
                left++; //this is our count-answer how many times left didnt equal right
            }

        }

        return left;
    }
}
