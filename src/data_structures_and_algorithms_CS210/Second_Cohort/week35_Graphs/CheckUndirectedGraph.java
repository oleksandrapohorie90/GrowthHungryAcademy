package data_structures_and_algorithms_CS210.Second_Cohort.week35_Graphs;

import java.io.PrintWriter;
import java.util.Scanner;

public class CheckUndirectedGraph {

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

        //assume matrix represents valid adjacency matrix of a simple undirected graph
        boolean isUndirected = true;
        //check for a condition for a simple undirected graph's adjacency matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adjacencyMtrix[i][j] != adjacencyMtrix[j][i]) {
                    isUndirected = false;//if its not symmetric then its not undirected graph
                    break;
                }
                //2nd condition 0 diagonal - adjacency matrix[i][j] must be 0 for a simple graph(no self loops)
                if (i == j && adjacencyMtrix[i][j] != 0) {
                    isUndirected = false;//if diagonal element is not 0 it is not a simple graph
                    break;
                }
            }
            if (!isUndirected) {
                break; //we found a violation in the inner loop no need to continue
            }
        }

        if (isUndirected) {
            out.println("YES");
        } else {
            out.println("NO");
        }
        out.flush(); //flush the output buffer and close the PrintWriter
    }
}
