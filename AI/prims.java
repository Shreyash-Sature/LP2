import java.util.*;

public class prims {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Vertices: ");
        int V = sc.nextInt();
        System.out.print("Enter Edges: ");
        int E = sc.nextInt();

        int[][] graph = new int[V][V];
        System.out.println("Enter src dest wt:");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
            graph[u][v] = graph[v][u] = w; 
        }

        int[] key = new int[V];
        int[] parent = new int[V];
        boolean[] mst = new boolean[V];
        
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {
            int u = -1;
            // Greedy Step: Pick the minimum weight edge connecting to the tree
            for (int i = 0; i < V; i++)
                if (!mst[i] && (u == -1 || key[i] < key[u])) u = i;

            mst[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !mst[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        int total = 0;
        System.out.println("\nEdge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
            total += graph[i][parent[i]];
        }
        System.out.println("Minimum Cost: " + total);
        sc.close();
    }
}