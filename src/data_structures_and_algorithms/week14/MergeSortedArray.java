package data_structures_and_algorithms.week14;

public class MergeSortedArray {
    //Idea: we maintain 3 pointers
    //1st - at the end of numbers here, starts with 3 in this case
    //nums1 = [1, 2, 3, 0, 0, 0], m = 3, nums2 = [2, 5, 6], m = 3(i=m-1)
    //2nd pointer nums2 = [2, 5, 6], n = 3
    //we start with the largest numbers from both arrays and the 3rd pointer is where we are going to write the next number

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}
