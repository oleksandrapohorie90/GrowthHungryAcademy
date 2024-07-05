package algos_and_ds.DS_BASIC_SORTING_ALGORITHMS;

public class IfSortedArrayHowManyIntsNotInOrder {

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
        //time complexity in worst case: O()
        //Space complexity in worst case: O()

        int n = heights.length;
        int[] sorted_copy = new int[n];
        for (int i = 0; i < n; i++) {
            sorted_copy[i] = heights[i];
        }
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
