package data_structures_and_algorithms_CS210.Second_Cohort.week22_Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n == 0) {
            return 0; // Base Condition
        }

        int maxArea = 0;
        int left[] = new int[n]; // fill left boundary
        int right[] = new int[n]; // fill right boundary

        left[0] = -1;
        right[n - 1] = n;

        for (int i = 1; i < n; i++) {
            int prev = i - 1; // previous for comparing the heights
            while (prev >= 0 && heights[prev] >= heights[i]) {
                prev = left[prev]; // we have done this to minimise the jumps we make to the left
            }
            left[i] = prev;
        }

        // Similarly we do for right
        for (int i = n - 2; i >= 0; i--) {
            int prev = i + 1;
            while (prev < n && heights[prev] >= heights[i]) {
                prev = right[prev];
            }
            right[i] = prev;
        }

        // once we have these two arrays fill we need width & area
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            maxArea = Math.max(maxArea, heights[i] * width);
        }
        return maxArea;
    }
}

/*
Here's the intuition to understand p = lessFromLeft[p];

Consider the test case
indices.......... :  0 1 2 3 4 5 6 7 8 9 10 11  .
heights.......... :  4 9 8 7 6 5 9 8 7 6  5  4  .
lessFromLeft      : -1 0 0 0 0 0 5 5 5 5  .  .  .

In this, when we reach 5 at index 10, we start searching for idx=9, i.e. p points at 6.
6 > 5.
Now, we want something which is smaller than 5, so it should definitely be smaller than 6. So 6 says to 5:

I've already done the effort to find the nearest number that's smaller than me and you needn't traverse the array again till that point. My lessFromLeft points at index 5 and all the elements between that and me are greater than me so they are surely greater than you. So just jump to that index and start searching from there.

So you next p directly points at idx = 5, at value 5.

There, this 5 again says the same statement to current 5 and asks it to jump directly to idx = 0. So in the second iteration itself, our search has reached idx=0 and that's our answer for the current element.

Similarly, for the next element 4, it'll take 3 steps.

And for all the elements following 4, if they are greater than 4, their search will stop at 4 itself.

Bottom line: we are not traversing the array again and again. it's O(n).
*/
