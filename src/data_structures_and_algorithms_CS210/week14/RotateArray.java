package data_structures_and_algorithms_CS210.week14;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        //rotating k = p*n+q times is equivalent
        //to rotating g just q times. q = k% n.
        //replace k with q, i.e. k = k % n.
        k %= n;

        //let nums = [1,2,3,4,5,6,7]
        //and k = 3
        //reverse the whole array
        //nums = [**t,6,5,4,3,2,1**]

        reverse(nums, 0, nums.length - 1);

        //reverse the first k elements of the array
        //nums= [**5,6,7**,4,3,2,1]
        reverse(nums, 0, k - 1);

        //reverse the rest of the array
        //nums = [5,6,7,**1,2,3,4**]
        reverse(nums, k, nums.length - 1);

        //final result = [5,6,7,1,2,3,4] as intended.
    }

    //simple sub-array reversing algorithm
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            //swap (nums[start], nums[end]);
            int temp = nums[start];
            nums[start] = nums[end];
        }
    }
}
