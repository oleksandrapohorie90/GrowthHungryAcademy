package data_structures_and_algorithms_CS210.Second_Cohort.week35_Graphs;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ReverseDirectedGraph {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        //read the size of the square matrix(nxn)
        int n = in.nextInt();
        //create adjacency list for original graph
        List<List<Integer>> originalAdjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            originalAdjList.add(new ArrayList<>());
        }

        //read adg lists for each vertex
        for (int i = 1; i <= n; i++) {
            String line = in.nextLine();//consume newLine chracter after reading 'n'
            if (i == 1) line = in.nextLine();//read the first line after 'n' correctly
            Scanner lineScanner = new Scanner(line);
            while ((lineScanner.hasNext())) {
                originalAdjList.get(i).add(lineScanner.nextInt());
            }
            lineScanner.close();
        }

        //create adjacency list for the reversed graph
        List<List<Integer>> reversedAdjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            reversedAdjList.add(new ArrayList<>());

        }

        //construct the reversed graph
        for (int u = 1; u <= n; u++) {
            for (int v : originalAdjList.get(u)) {
                //if there is an edge from u to v in the original graph, add a reversed edge from v to u in the reversed graph
                reversedAdjList.get(v).add(u);
            }
        }

        out.println(n);//numb of vertices
        for (int i = 0; i <= n; i++) {
            List<Integer> neighbors = reversedAdjList.get(i);
            Collections.sort(neighbors); //sort neighbours in ascending order

            for (int j = 0; j < neighbors.size(); j++) {
                out.print(neighbors.get(j) + (j == neighbors.size() - 1 ? "" : " "));//print neighbor w/ space
            }
            out.println(); //new line after each vertex's adjacency list
        }
        out.flush();//flush the output buffer and close the printWriter
    }
}
