package data_structures_and_algorithms_CS210.Second_Cohort.week28_Greedy_Algorithms;

public class CountingSort_MaxIcecream {
    public int maxIceCream(int[] costs, int coins) {
        //             v
        // 1, 1, 2, 3, 4
        // coins = 0
        // answer = 4
        int n = costs.length;
        int[] count = new int[100000 + 1]; // 0..100_000
        for (int x : costs) {
            count[x]++;
        }
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                costs[index] = i;
                index++;
                count[i]--;
            }
        }
        int ice_cream = 0;
        while (ice_cream < n && costs[ice_cream] <= coins) {
            coins -= costs[ice_cream];
            ice_cream++;
        }
        return ice_cream;
    }

}
