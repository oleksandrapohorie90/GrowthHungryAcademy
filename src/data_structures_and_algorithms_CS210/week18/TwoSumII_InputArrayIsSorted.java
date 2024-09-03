package data_structures_and_algorithms_CS210.week18;

public class TwoSumII_InputArrayIsSorted {
    //the idea of 2 pointers that run from the beginning and from the end
    //sorted array
    //only 1 solution
    //sum of 2 cant be the same number
    //1st pointer at the 1st el in array
    //2nd pointer at the 2nd el in array
    //if sum is less than target then move left pointer one forward(increment)-increase sum by moving left pointer
    //if sum is more then target then move right pointer one back()-decrease sum by moving right pointer to the left
public int[] twoSum(int[] numbers, int target){
    int left = 0; //beg
    int right = numbers.length-1;//ending

    while(numbers[left]+numbers[right] !=target){
        if(numbers[left] +numbers[right] < target){
            left++;
        }else{
            right--;
        }
    }
    return new int[] {left+1, right+1}; //??? get bc we return indexes but why +1
    //sorted griddy algorithm
}

}
