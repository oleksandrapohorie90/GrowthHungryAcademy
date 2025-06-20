package data_structures_and_algorithms_CS210.Second_Cohort.Neetcode;

public class RemoveElement_TwoPointers {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        //int count = 0;

        for(int right = 0; right<nums.length; right++){
            if(nums[right] != val){
                nums[left] = nums[right];
                left++;
                //count++;
            }
        }
        return left;
    }
}
