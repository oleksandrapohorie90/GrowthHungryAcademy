package data_structures_and_algorithms.week14;

public class MergeSortedArray {
    //Idea: we maintain 3 pointers
    //1st - at the end of numbers here, starts with 3 in this case
    //nums1 = [1, 2, 3, 0, 0, 0], m = 3, nums2 = [2, 5, 6], n = 3(i=n-1)
    //2nd pointer nums2 = [2, 5, 6], n = 3
    //3rd pointer at the end of nums1 = [1, 2, 3, 0, 0, 0] -> which is 0
    //we start with the largest numbers from both arrays and the 3rd pointer is where we are going to write the next number, so start with 2 lasrgest nums and we already know we will put 3rd pointer at the very last nums1
    //we compare 3 and 6 and 6 is larger, so we put 6 at the 3rd pointer position -> [1, 2, 3, 0, 0, 6] , next decrement 3rd pointer(k) to point to the next position
    //we decrement the 2nd pointer since we wrote 6 already
    //next 3 and 5, 5 is larger -> [1, 2, 3, 0, 5, 6]

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0) {//when we are finished with 2nd array than we stop
            if (i >= 0 && nums1[i] > nums2[j]) {//if num from 1st arr is bigger than num from 2nd arr
                nums1[k] = nums1[i];//then at position k we write nums1 element
                k--;
                i--;
            } else {//if they are equal or nums2 element is larger nums2 element
                nums1[k] = nums2[j];
                k--;
                j--;
            }
            //can also delete k from above and paste here k--;
            //come up with a diff example on paper and come up with diff algorithm
        }
    }
}
