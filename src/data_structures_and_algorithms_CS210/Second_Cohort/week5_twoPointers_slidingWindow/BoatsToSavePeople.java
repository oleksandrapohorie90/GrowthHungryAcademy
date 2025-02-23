package data_structures_and_algorithms_CS210.Second_Cohort.week5_twoPointers_slidingWindow;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BoatsToSavePeople {
    public static void main(String[] args) {
        int[] people = {3, 2, 2, 1};
        int limit = 3;
        System.out.println(numRescueBoats(people, limit));
    }

    public static int numRescueBoats(int[] people, int limit) {
        /**
         * You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.
         *
         * Return the minimum number of boats to carry every given person.
         *
         * Example 1:
         *
         * Input: people = [1,2], limit = 3
         * Output: 1
         * Explanation: 1 boat (1, 2)
         * Example 2:
         *
         * Input: people = [3,2,2,1], limit = 3
         * Output: 3
         * Explanation: 3 boats (1, 2), (2) and (3)
         * Example 3:
         *
         * Input: people = [3,5,3,4], limit = 5
         * Output: 4
         * Explanation: 4 boats (3), (3), (4), (5)
         */
        //Sort the arr first
        //left people[0] and right people.length-1
        //take sum of both indexes and compare with limit,
        // if its bigger than the limit, then we add the boat
        // if equal to limit then we put 1 pointer and 2nd pointer to the boat and we move first to the right and last to the left
        //if they exceed the limit then the last one goes in the boat and then we move right to the left and dont touch the left one and still increase the boat
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int boats = 0;
        while (left <= right) {
            //if left == right, then there is only 1 person, we only need to add people right if left is less than right, but if its equal then 0, bc we dont want to add to the boat the same person twice
            int sum = people[left] + (left < right ? people[right] : 0);
            if (sum <= limit) {
                boats++;
                left++;
                right--;
            } else {
                boats++;
                right--;
            }
        }

        return boats;
    }
}
