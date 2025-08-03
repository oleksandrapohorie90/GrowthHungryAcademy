package data_structures_and_algorithms_CS210.Second_Cohort.week35_Graphs;

import java.util.Scanner;

public class Problem1_DFS {
    static void dfs(int v, boolean[] visited, int[][] graph) {
        visited[v] = true;
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                dfs(i, visited, graph);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
        n is num of all nodes
        s is start vertex
        n s
        [0 0 1 ... ]
        [0 0 0 ... ]
        [1 1 1 ... ]
        ...
        [...]
         */
        //step 1
        int n = scanner.nextInt();
        int startVertex = scanner.nextInt();

        //read all the graph
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        //n == graph.length
        //Adjency matrix is ready

        //step 2
        boolean[] visited = new boolean[n];
        dfs(startVertex, visited, graph);

        //step 3
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                answer += 1;
            }
        }
        System.out.println(answer);
    }
}
