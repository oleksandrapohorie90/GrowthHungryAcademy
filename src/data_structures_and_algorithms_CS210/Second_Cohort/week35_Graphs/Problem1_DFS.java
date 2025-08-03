package data_structures_and_algorithms_CS210.Second_Cohort.week35_Graphs;

import java.util.Scanner;

//compile in ideone.com
public class Problem1_DFS {
    static void dfs(int v, boolean[] visited, int[][] graph) {
        visited[v] = true;
        for (int i = 1; i <= graph.length; i++) {
            if (!visited[i] && graph[v][i] == 1) {
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
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        //n == graph.length
        //Adjency matrix is ready

        //step 2, when doing 1 indexed graph remember that indeces start from 0 so you need +1
        boolean[] visited = new boolean[n + 1];
        dfs(startVertex, visited, graph);

        //step 3
        int answer = 0;
        for (int i = 1; i < n; i++) {
            if (visited[i]) {
                answer += 1;
            }
        }
        System.out.println(answer);
    }
}
