package data_structures_and_algorithms.DS_ARRAYS;

public class SingleNumber {
    /*
    arr = [4,1,2,1,2]
    Binary:100-4
           001-1
           010-2
           001-1
           010-2
    aXORa=0 if it is true and every num appears twice
    will be left with num of 4 bc nobody will kill any other number

    XOR -> 0101 either the 1st is true or the 2nd is true but not both
           1001
           ----
           TTFF
           1100
   1XOR1-> 0...01
           0...01
           ------
           000000
    2XOR2=0 bc the same bits cancel each other
     */
    public int singleNumber(int[] nums) {
        //each num appears twice except 1 number
        //4xor1xor2xor1xor2 = 4xor1xor1xor2xor2
        int result = 0; //result var
        for (int i : nums) {
            result ^= i; //xor all the numbers in the array
        }
        return result;
    }
}
