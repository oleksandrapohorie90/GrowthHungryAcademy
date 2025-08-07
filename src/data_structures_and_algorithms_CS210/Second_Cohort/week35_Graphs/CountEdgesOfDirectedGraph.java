package data_structures_and_algorithms_CS210.Second_Cohort.week35_Graphs;

import java.io.PrintWriter;
import java.util.Scanner;

public class CountEdgesOfDirectedGraph {
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
        int edgeCount = 0;//init the edge count to 0

        //iterate through the entire adjacency matrix to count edges, for a directed graph, each '1' in the matrix represents a directed edge

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                //if adjacency matrix[i][j] is 1 it means there is an edge between vertex i and vertex j
                if (adjacencyMtrix[i][j] == 1) {
                    edgeCount++;//increment edge count
                }
            }
        }

        out.println("Total edges: " + edgeCount);
        out.flush(); //flush the output buffer and close the PrintWriter
    }
}
