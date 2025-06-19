package data_structures_and_algorithms_CS210.Second_Cohort.Neetcode;

public class ClimbingStairs {
    public int climbStairs(int n) {
        return dfs(n, 0);
    }

    public int dfs(int n, int i) {
        if (i >= n) return i == n ? 1 : 0;
        return dfs(n, i + 1) + dfs(n, i + 2);
    }
}
