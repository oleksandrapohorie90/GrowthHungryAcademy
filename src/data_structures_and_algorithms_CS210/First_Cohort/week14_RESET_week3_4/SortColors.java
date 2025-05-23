package data_structures_and_algorithms_CS210.First_Cohort.week14_RESET_week3_4;

public class SortColors {
    //classic problem
    //Dijkstra dutch national flag algorithm
    //problem of sorting for only 3 distinct numbers

    public void sortColors(int[] nums) {
        //we want to insert 0s one by one into their positions
        //starting from index 0
        int zeroInsertPos = 0;

        //we want to insert 2s one by one into their positions
        //starting from the last index (nums.length - 1).
        int twoInsertPos = nums.length - 1;

        //initialize iterator
        int i = 0;

        //everything to the right of twoInsertPos is rightfully
        //filled with 2s. When iterator goes into the territory of
        //2s, stop
        while (i <= twoInsertPos) {
            if (nums[i] == 0) {
                //if we see a 0, put it into its respective position,
                //ie we do swap(nums[zeroInsertPos], nums[i]).
                swap(nums, zeroInsertPos, i);
                zeroInsertPos++;
                i++;
            } else if (nums[i] == 1) {
                //if we see a 1, just leave it to be where it is
                i++;
            } else {//nums[i]==2
                //if we see a 2, put it into its respective position,
                //ie we do swap(nums[i], nums[twoInsertPos]).
                swap(nums, i, twoInsertPos);
                twoInsertPos--;
                //dont advance i to (i+1) because if nums[i] AFTER SWAP
                //equals 0, then we should put that 0 to its respective position,
                //so dont advance yet - wait until the next iteration on i

            }
        }
    }
//helper method
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }

}
