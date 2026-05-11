import java.util.*;

public class dij {

    static void printPath(int parent[], int j) {

        if (j == -1)
            return;

        printPath(parent, parent[j]);

        System.out.print(j + " ");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int v = sc.nextInt();

        int graph[][] = new int[v][v];

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        System.out.println("Enter source destination weight:");

        // Input edges
        for (int i = 0; i < e; i++) {

            int s = sc.nextInt();
            int d = sc.nextInt();
            int w = sc.nextInt();

            graph[s][d] = w;
            graph[d][s] = w;
        }

        // Source and Destination
        System.out.print("Enter source vertex: ");
        int src = sc.nextInt();

        System.out.print("Enter destination vertex: ");
        int dest = sc.nextInt();

        int dist[] = new int[v];
        int parent[] = new int[v];

        boolean visited[] = new boolean[v];

        // Initialize
        for (int i = 0; i < v; i++) {

            dist[i] = 999;
            parent[i] = -1;
        }

        dist[src] = 0;

        // Dijkstra Logic
        for (int i = 0; i < v - 1; i++) {

            int min = 999;
            int u = -1;

            // Find minimum distance vertex
            for (int j = 0; j < v; j++) {

                if (!visited[j] && dist[j] < min) {

                    min = dist[j];
                    u = j;
                }
            }

            visited[u] = true;

            // Update distances
            for (int j = 0; j < v; j++) {

                if (graph[u][j] != 0 &&
                    !visited[j] &&
                    dist[u] + graph[u][j] < dist[j]) {

                    dist[j] = dist[u] + graph[u][j];

                    parent[j] = u;
                }
            }
        }

        // Output
        System.out.println("\nShortest Distance = " + dist[dest]);

        System.out.print("Shortest Path = ");

        printPath(parent, dest);
    }
}