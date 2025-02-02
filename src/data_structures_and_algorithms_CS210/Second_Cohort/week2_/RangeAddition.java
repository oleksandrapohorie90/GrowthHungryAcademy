package data_structures_and_algorithms_CS210.Second_Cohort.week2_;

public class RangeAddition {
    //Algo_Monster
    // Method to compute the modified array after a sequence of updates
    public int[] getModifiedArray(int length, int[][] updates) {
        // Create an array 'difference' initialized to zero, with the given length
        int[] difference = new int[length];

        // Apply each update in the updates array
        for (int[] update : updates) {
            int startIndex = update[0]; // Start index for the update
            int endIndex = update[1];   // End index for the update
            int increment = update[2];  // Value to add to the subarray

            // Apply increment to the start index
            difference[startIndex] += increment;

            // If the end index is not the last element,
            // apply the negation of increment to the element after the end index
            if (endIndex + 1 < length) {
                difference[endIndex + 1] -= increment;
            }
        }

        // Convert the 'difference' array into the actual array 'result'
        // where each element is the cumulative sum from start to that index
        for (int i = 1; i < length; i++) {
            difference[i] += difference[i - 1];
        }

        // Return the resultant modified array
        return difference;
    }
}
