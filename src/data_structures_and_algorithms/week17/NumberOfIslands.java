package data_structures_and_algorithms.week17;

public class NumberOfIslands {
    private char[][] grid;
    private int n;
    private int m;

    public int numOfIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        this.n = grid.length;
        this.m = grid[0].length;
        this.grid = grid;

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    answer++;
                    dfs(i, j);
                }
            }

        }
        return answer;
    }

    private void dfs(int row, int col) {
        grid[row][col] = '0';
        {
            int up_row = row - 1;
            int up_col = col;
            if (up_row >= 0 && grid[up_row][up_col] == '1') {
                dfs(up_row, up_col);
            }
        }
        {
            int right_row = row;
            int right_col = col + 1;
            if (right_col < m && grid[right_row][right_col] == '1') {
                dfs(right_row, right_col);
            }
        }

        {
            int down_row = row + 1;
            int down_col = col;
            if (down_row < m && grid[down_row][down_col] == '1') {
                dfs(down_row, down_col);
            }

            int left_row = row;
            int left_col = col;
        }
    }
}
