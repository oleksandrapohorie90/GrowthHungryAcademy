package data_structures_and_algorithms_CS210.Second_Cohort.week19_twoPointers_slidingWindow;

public class TrappingRainWater_Hardd {
    //Prefix/Suffix Max
    public int trap(int[] height) {
        int n = height.length;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        int answer = 0;
        for (int i = 1; i <= n - 2; i++) {
            int limit = Math.min(leftMax[i], rightMax[i]);
            if (limit > height[i]) {
                answer += limit - height[i];
            }
        }
        return answer;
    }

    //TWO Pointers
    public int trap2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 1;
        int right = height.length - 2;

        int maxLeft = height[0];
        int maxRight = height[height.length - 1];

        int totalWater = 0;
        while (left <= right) {
            // Water could, potentially, fill everything from left to right, if there is nothing in between.
            if (maxLeft < maxRight) {
                if (height[left] > maxLeft) {
                    // If the current elevation is greater than the previous maximum, water cannot occupy that point at all.
                    // However, we do know that everything from maxLeft to the current index, has been optimally filled, as we've
                    // been adding water to the brim of the last maxLeft.
                    //
                    // So, we say we've found a new maximum, and look to see how much water we can fill from this point on.
                    maxLeft = height[left];
                } else {
                    // If we've yet to find a maximum, we know that we can fill the current point with water up to the previous
                    // maximum, as any more will overflow it. We also subtract the current height, as that is the elevation the
                    // ground will be at.
                    totalWater += maxLeft - height[left];
                }

                // Increment left, we'll now look at the next point.
                left++;
            } else {
                // If the height at the left is NOT greater than height at the right, we cannot fill from left to right without over-
                // flowing; however, we do know that we could potentially fill from right to left, if there is nothing in between.

                if (height[right] > maxRight) {
                    // Similarly to above, we see that we've found a height greater than the max, and cannot fill it whatsoever, but
                    // everything before is optimally filled.

                    // We can say we've found a new maximum and move on.
                    maxRight = height[right];
                } else {
                    // If we haven't found a greater elevation, we can fill the current elevation with maxRight - height[right]
                    // water.
                    totalWater += maxRight - height[right];
                }

                // Decrement right, we'll look at the next point.
                right--;
            }
        }

        // Return the sum we've been adding to.
        return totalWater;
    }


}
