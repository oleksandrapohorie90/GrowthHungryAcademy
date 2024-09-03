package data_structures_and_algorithms_CS210.Leetcode;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
    /*
    Variable Initialization:

n is initialized to the length of the input array nums.
An integer array res of length n is initialized to store the resulting product array.
Forward Pass:

Initialize res[0] to 1 because the product of all elements to the left of the first element is 1.
Traverse the array from index 1 to n - 1.
At each index i, calculate res[i] by multiplying res[i - 1] (the product of all elements to the left of index i) with nums[i - 1] (the value of the element at index i - 1).
Backward Pass:

Initialize a variable right to 1. This variable keeps track of the product of all elements to the right of the current element.
Traverse the array from index n - 1 to 0.
At each index i, update res[i] by multiplying it with right. This accounts for the product of all elements to the left of the current element.
Update right by multiplying it with nums[i]. This incorporates the contribution of the current element to the product of all elements to the right.
By performing the forward pass followed by the backward pass, each element of the resulting array res will contain the product of all elements of the input array nums except for the element itself. Finally, the resulting array res is returned. This algorithm achieves a linear time complexity of O(n), where n is the length of the input array nums.
     */
}
