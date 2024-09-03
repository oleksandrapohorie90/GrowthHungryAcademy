package data_structures_and_algorithms_CS210.DS_BASIC_SORTING_ALGORITHMS;

public class HeightChecker_CountSort {

    public int heightChecker(int[] heights) {//count sort
        int n = heights.length;
        int[] sorted_copy = new int[n];

        for (int i = 0; i < n; i++) {
            sorted_copy[i] = heights[i];
        }

        //Example: [1,1,4,2,1,3]
        //frequency[0..100]
        //After the 1st loop
        //frequency[1] = 3
        //frequency[2] = 1
        //frequency[3] = 1
        //frequency[4] = 1
        //frequency[5..100] = 0
        //In the 2nd loop
        //i=1 -> we check if frequency is bigger than 0
        //  frequency[1] (3) > 0 -> true
        //      sorted_copy[0]=1 the min number
        //      frequency[1]--; becomes 2
        //      j++; becomes 1
        //  frequency[1] (2) >0 -> true
        //      sorted_copy[1] = 1
        //      frequency[1]-- becomes 1
        //      j++;  becomes 2
        //  frequency[1] (2) >0 -> true
        //      sorted_copy[2] = 1
        //      frequency[1]-- becomes 0
        //      j++;  becomes 3

        int[] frequency = new int[101]; //indices 0...100
        for (int i = 0; i < n; i++) {
            frequency[sorted_copy[i]]++;
        }
        for (int i = 1, j = 0; i <= 100; i++) {
            while (frequency[i] > 0) {
                sorted_copy[j] = i;
                frequency[i]--;
                j++;
            }
        }

        int asnwer = 0;
        for (int i = 0; i < n; i++) {
            if (sorted_copy[i] != heights[i]) {
                asnwer++;
            }
        }
        return asnwer;
    }
}
