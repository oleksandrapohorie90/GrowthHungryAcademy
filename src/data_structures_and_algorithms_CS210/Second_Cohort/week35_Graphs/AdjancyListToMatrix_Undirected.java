package data_structures_and_algorithms_CS210.Second_Cohort.week35_Graphs;

import java.io.PrintWriter;
import java.util.Scanner;

public class AdjancyListToMatrix_Undirected {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        //read the size of the square matrix(nxn)
        int n = in.nextInt();
        int m = in.nextInt();

        //create a 2D array to store adjacency matrix
        int[][] adjacencyMtrix = new int[n][n];

        //read matrix from the input, one by one
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjacencyMtrix[i][j] = 0; //init all elements to 0
            }
        }

        //read m lines each representing an edge(u,v), in the list of edges each num is represented by two numbers(u and v)
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            //for an undirected graph, if theres an edge btw u and v we set both adjacency matrix[u-1][v-1] and adjacencyMatrix[v-1[u-1] to 1
            //we sub 1 from u and v bc the input vertices are 1 based indexed while matrix is 0 based index
            adjacencyMtrix[u - 1][v - 1] = 1;
            adjacencyMtrix[v - 1][u - 1] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                out.println(adjacencyMtrix[i][j] + " "); //print each element of the matrix followed by a space
            }
            out.println(); //move to next line
        }
        out.flush();
    }
}
