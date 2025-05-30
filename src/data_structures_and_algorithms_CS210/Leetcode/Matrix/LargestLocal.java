package data_structures_and_algorithms_CS210.Leetcode.Matrix;

public class LargestLocal {
        public int[][] largestLocal(int[][] grid) {
            int n = grid.length;
            int[][] newMatrix = new int[n - 2][n - 2];

            for (int i = 0; i < n - 2; i++) {
                for (int j = 0; j < n - 2; j++) {
                    int max = 0;
                    for (int x = i; x < i + 3; x++) {
                        for (int y = j; y < j + 3; y++) {
                            max = Math.max(max, grid[x][y]);
                        }
                    }
                    newMatrix[i][j] = max;
                }
            }

            return newMatrix;
        }
    }

