package data_structures_and_algorithms_CS210.First_Cohort.week18;

public class MoveZeroes {

    //2 pointers, 1 is looking through each element in the array-usual one
    //and the 2nd one is always pointing at the position where the next non-zero element should land
    //2nd pointer points at the beg of arr bc its the 1st place where non zero element should be, so move each time the 2nd pointer where the next non zero should be
    //iterate through array, when there is a non zero(ex.1) I will overwrite nums[0] = 1, so I push a number infront asap I find non zero
    //so 2nd pointer is on the 2nd position now -> nums[1] and I keep itterating w/ 1st pointer if its 0-skip if not then overwrite and push forward asap when I find the 2nd non num element
    //

    public void moveZeroes(int[] nums){
        if(nums == null || nums.length == 0){
            return; //??nothing since void
        }
//it is where my next non-zero element should be - 2nd pointer
        int insertPosition = 0;
        for(int x : nums){
            if (x != 0){
                //if element is not 0 - put it into its respective position/OVERWRITE
                nums[insertPosition] = x;
                insertPosition++; //now increment to point to the next position where non zero element should be
            }
        }
        //Now we found non zero elements and now from the insert position till the end it should all fill w/ zeroes
        for (; insertPosition < nums.length; insertPosition++) { //;???
            nums[insertPosition] = 0;
        }

    }
}
