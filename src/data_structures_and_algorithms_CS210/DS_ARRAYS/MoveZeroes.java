package data_structures_and_algorithms_CS210.DS_ARRAYS;

public class MoveZeroes {
    public void moveZeroes(int[] nums){

        //move zeroes to end without a copy of an array
        int j = 0;// will point to indexes
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0) continue;
            nums[j] = nums[i]; //assigning to position 0 numbers if not zero
            j++;//to move forward
        }
        while(j< nums.length){
        //This loop is used to fill the remaining positions in the array with 0s
            nums[j] = 0;//this sets the current position nums[j] to 0
            j++;
        }
        /*
        swap(nums,i,j)
        t= nums[i]
        nums[i] = nums[j]
        nums[j] = t
         */
    }
}
