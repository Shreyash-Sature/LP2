import java.util.*;

public class dfs {

    static boolean first = true;

    // Recursive DFS Function
    static void dfs(int node, int[][] graph, boolean[] visited) {

        visited[node] = true;

        // Formatting output
        if (!first)
            System.out.print(" -> ");

        System.out.print(node);
        first = false;

        // Visit all adjacent vertices
        for (int i = 0; i < graph.length; i++) {

            if (graph[node][i] == 1 && !visited[i]) {

                dfs(i, graph, visited);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input number of vertices
        System.out.print("Enter number of vertices: ");
        int v = sc.nextInt();

        // Adjacency matrix
        int[][] graph = new int[v][v];

        // Input number of edges
        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        // Input edges
        System.out.println("Enter edges (source destination):");

        for (int i = 0; i < e; i++) {

            int src = sc.nextInt();
            int dest = sc.nextInt();

            // Undirected graph
            graph[src][dest] = 1;
            graph[dest][src] = 1;
        }

        boolean[] visited = new boolean[v];

        // Input starting node
        System.out.print("Enter starting node: ");
        int start = sc.nextInt();

        // DFS Traversal
        System.out.println("DFS Traversal:");
        dfs(start, graph, visited);

        sc.close();
    }
}