package data_structures_and_algorithms_CS210.Second_Cohort.week35_Graphs;

import java.io.PrintWriter;
import java.util.Scanner;

public class CheckSelfLoopsInGraph {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        //read the size of the square matrix(nxn)
        int n = in.nextInt();

        //create a 2D array to store adjacency matrix
        int[][] adjacencyMtrix = new int[n][n];

        //read matrix from the input, one by one
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjacencyMtrix[i][j] = in.nextInt();//read each element as an integer (0 or 1)
            }
        }

        boolean hasLoops = false;//assume initially graph doesnt contain loops
        //check for loops by examining the diagonal element of the adjacency matrix
        for (int i = 0; i < n; i++) {
            //in an adjacency matrix a loop at vertex 'i' is represented by adjacencyMatrix[i][i] == 1
            if (adjacencyMtrix[i][i] == 1) {
                hasLoops = true; //if we find a 1 on the diagonal the graph has a loop
                break;
            }
        }

        if (hasLoops) {
            out.println("YES");
        } else {
            out.println("NO");
        }
        out.flush(); //flush the output buffer and close the PrintWriter
    }
}
