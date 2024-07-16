package data_structures_and_algorithms.DS_BASIC_SORTING_ALGORITHMS;

public class HeightChecker_BubbleSort {

    public int heightChecker(int[] heights) {
        //Bubble sort
        //Iterate over the array(possibly multiple times, up to [n-1] times)
        //if a[i] > a[i+1]
        //swap(a[i],a[i+1])
        //swapped=true
        //after iterating over the array, check swapped
        //if swapped is true
        //iterate over the array again
        //else
        //stop the algorithm, array is sorted
        //time complexity in worst case: O(n^2)
        //Space complexity in worst case: O() - in normal case you dont need to create a copy of sorted_copy array


        int n = heights.length;
        int[] sorted_copy = new int[n];
        for (int i = 0; i < n; i++) {
            sorted_copy[i] = heights[i];
        }

        //worst case: a decreasing (nondecreasing) array
        //example: [5,4,3,2,1]
        //i=0 ->4 5 3 2 1
        //i=1 ->4 3 5 2 1
        //i=2 ->4 3 2 5 1
        //i=3 ->4 3 2 1 5
        while (true) {
            boolean swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (sorted_copy[i] > sorted_copy[i + 1]) {
                    swap(sorted_copy,i,i+1);
                    swapped = true;
                }
            }
            if (!swapped){//the array is sorted
                break;
            }
        }
        int asnwer = 0;
        for (int i = 0; i < n; i++) {
            if(sorted_copy[i] != heights[i]){
                asnwer++;
            }
        }
        return asnwer;
    }

    private void swap(int [] a, int i, int j){
        int temp = a[i];
        a[i] = a[j]; //lost what was in a[i]
        a[j] = temp; //assign save val of a[i] to a[j]
    }
}
