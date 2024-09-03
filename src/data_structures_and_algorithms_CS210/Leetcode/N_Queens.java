package data_structures_and_algorithms_CS210.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class N_Queens {
    private int dimension;

    private int[] row;
    private int[] diag_aux;
    private int[] diag_main;

    private List<List<String>> answers;
    private char[][] current;

    public List<List<String>> solveNQueens(int n) {
        dimension = n;

        row = new int[n];
        diag_main = new int[2 * n];
        diag_aux = new int[2 * n];

        answers = new ArrayList<>();

        current = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                current[i][j] = '.';
            }
        }

        backtrack(0);
        return answers;
    }

    private void backtrack(int c) {
        if (c == dimension) {
            List<String> result = new ArrayList<>();
            for (int i = 0; i < dimension; i++) {
                result.add(new String(current[i]));
            }
            answers.add(result);
            return;
        }
        for (int r = 0; r < dimension; r++) {
            if (row[r] > 0 || diag_aux[r + c] > 0 || diag_main[r - c + dimension - 1] > 0) {
                continue;
            }
            current[r][c] = 'Q';
            row[r] = diag_aux[r + c] = diag_main[r - c + dimension - 1] = 1;
            backtrack(c + 1);
            current[r][c] = '.';
            row[r] = diag_aux[r + c] = diag_main[r - c + dimension - 1] = 0;
        }
    }
}
