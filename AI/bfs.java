import java.util.*;

public class bfs {

    static boolean first = true;
    static int front = 0, rear = 0;

    // Recursive BFS Function
    static void bfs(int[][] graph, boolean[] visited, int[] queue, int v) {
        
        // Base case: if queue is empty
        if (front == rear) {
            return;
        }

        // Dequeue node
        int node = queue[front++];

        // Formatting output
        if (!first)
            System.out.print(" -> ");

        System.out.print(node);
        first = false;

        // Visit all adjacent vertices
        for (int i = 0; i < v; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                visited[i] = true;
                queue[rear++] = i; // Enqueue
            }
        }

        // Recursive call
        bfs(graph, visited, queue, v);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int v = sc.nextInt();

        int[][] graph = new int[v][v];

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        System.out.println("Enter edges (source destination):");
        for (int i = 0; i < e; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();

            // Undirected graph
            graph[src][dest] = 1;
            graph[dest][src] = 1;
        }

        boolean[] visited = new boolean[v];
        int[] queue = new int[v];

        System.out.print("Enter starting node: ");
        int start = sc.nextInt();

        // Setup starting point
        visited[start] = true;
        queue[rear++] = start;

        System.out.println("BFS Traversal:");
        bfs(graph, visited, queue, v);

        sc.close();
    }
}