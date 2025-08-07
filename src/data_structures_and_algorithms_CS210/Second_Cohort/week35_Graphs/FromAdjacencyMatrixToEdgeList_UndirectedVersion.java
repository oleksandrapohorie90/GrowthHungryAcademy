package data_structures_and_algorithms_CS210.Second_Cohort.week35_Graphs;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FromAdjacencyMatrixToEdgeList_UndirectedVersion {
    //helper class to represent a pair of integers used for edges list
    static class Pair {
        int u, v;

        public Pair(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

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
        //Create a list to store the edges, we will store each edge as a pair of vertex numbers
        List<Pair> edges = new ArrayList<>(); //not an adjency list

        //iterate through the upper triangle of the adjacency matrix to edges, we iterate for i from 0 to n-1 and for j from i+1 to n-1 to avoid double counting and self-loops
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                //if adjacency matrix[i][j] is 1 it means there is an edge between vertex i and vertex j
                if (adjacencyMtrix[i][j] == 1) {
                    //for output vertices are expected to be 1-based indexed, so we use i+1 and j+1
                    //create a Pair object to represent the edge(vertex i+1, vertex j+1)
                    edges.add(new Pair(i + 1, j + 1));
                }
            }
        }
        //output the list of edges
        for (Pair edge : edges) {
            out.println(edge.u + " " + edge.v);//print the vertex nums of the edge
        }
        out.flush();
    }
}
