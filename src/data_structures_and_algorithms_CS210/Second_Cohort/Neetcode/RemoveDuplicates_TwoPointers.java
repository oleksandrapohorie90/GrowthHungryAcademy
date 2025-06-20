package data_structures_and_algorithms_CS210.Second_Cohort.Neetcode;

public class RemoveDuplicates_TwoPointers {
    public int removeDuplicates(int[] nums) {
        //start both at 1 since the first element wont change
        int left = 1;//be a result
        //int right will just traverse
        //nums=[1,1,2,3,4]
        //[1,2,3,4]
        for(int right = 1; right<nums.length; right++){
            if(nums[right] != nums[right-1]){//check the next with prev
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}
