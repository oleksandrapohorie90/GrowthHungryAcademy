package data_structures_and_algorithms.week19;

import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TowersOfHanoi {
    //for recursion you have to define base case
    //it can be divided by subproblems and subproblems can be solved in the same way as
    private void hanoi(int n, int from, int to) {
        if (n == 0) return;
        int aux = (1 + 2 + 3) - (from + to);
        hanoi(n - 1, from, aux);
        System.out.println(n + " " + from + " " + to);
        hanoi(n - 1, aux, to);
    }

    public void run(InputStreamReader in, PrintWriter out) {
        //int n = in.nextInt();
        //hanoi(n, 1, 3);
    }
}
