package foundation_pre_course.week11;

public class RemoveDuplicatesFromSortedArray {
    //same idea as in RemoveElement
    //index where we will write down our answers
    //scan the arr from left to right
    //as soon as we find an element that needs to be written down in that positions, we put it there and increment the pointer

    /**
     * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
     * <p>
     * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
     * <p>
     * Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
     * Return k.
     */
    public static void main(String[] args) {
        int[] nums = {1, 1, 2,2,3};

        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates1(int[] nums) {
        // [1,1,1,1,2,2,3,4,4,4]
        //  n d d d n d n n d d

        //we will put non-duplicated numbers at positions
        //0,1,2,3,4, ...., etc. one-by-one

        //Number nums[0] should stay at position 0
        //we will start filling non-duplicated nums
        //from position 2
        int j = 1;

        //iterate starting from i=1
        for (int i = 1; i < nums.length; i++) {
            //if its a duplicate - d, skip it
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            //otherwise (n), put it at index j, and then increment j
            nums[j] = nums[i];
            j++;
        }
        return j;
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0; // Handle edge case for an empty array
        int index = 1; // Start from the second position (first element is always unique)
        for (int i = 1; i < nums.length; i++) { // Start from the second element
            if (nums[i] != nums[index - 1]) { // Compare with the last unique element
                nums[index] = nums[i]; // Place the unique element at the `index` position
                index++;
            }
        }
        return index; // Return the count of unique elements
    }

}
