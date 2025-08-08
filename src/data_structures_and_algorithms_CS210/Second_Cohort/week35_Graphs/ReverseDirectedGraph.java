package data_structures_and_algorithms_CS210.Second_Cohort.week35_Graphs;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReverseDirectedGraph {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        //read the size of the square matrix(nxn)
        int n = in.nextInt();
        List<List<Integer>> originalAdjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            originalAdjList.add(new ArrayList<>());
        }

        //read adg lists for each vertex
        for (int i = 1; i <= n; i++) {
            String line = in.nextLine();
        }
    }
}
