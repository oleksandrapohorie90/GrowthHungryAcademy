package data_structures_and_algorithms_CS210.week16;

public class FindLeftMostEntryOfNumsXInSortedArr {
    //lets find int x and return its leftmost index or return -1 if it is not present
    public int findLeftMostIndex(int[] nums, int x){
        int answer = -1;
        int n = nums.length;
        int left = nums[0];
        int right = nums[n-1];
        while (left<=right){
            int middle = (left+right)/2;
            if(nums[middle]>x){
                //keep search in the left part[left; middle-1]
                right=middle-1;
            }else if(nums[middle]==x){
                //potential answer, lets save answer=middle and keep searching
                //in the left part[left;middle-1]
                //keep search in the left part[left;middle-1]
                answer = middle;
                right = middle-1;
            }else {
                //nums[middle]<x
                //keep search in the right part [middle+1;right]
                left = middle+1;
            }
        }
        return answer;
    }

}
