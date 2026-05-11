
import java.util.*;

public class krushkal {

    static int find(int parent[], int i) {
        if (parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }

    static void union(int parent[], int x, int y) {
        parent[x] = y;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        int[][] edges = new int[E][3]; 

        System.out.println("Enter edges (src dest weight):");
        for (int i = 0; i < E; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }

        
        for (int i = 0; i < E - 1; i++) {
            for (int j = 0; j < E - i - 1; j++) {
                if (edges[j][2] > edges[j + 1][2]) {
                    int[] temp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = temp;
                }
            }
        }

        int[] parent = new int[V];
        for (int i = 0; i < V; i++)
            parent[i] = i;

        int count = 0, totalCost = 0;

        System.out.println("\nEdge \tWeight");

        for (int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            int x = find(parent, u);
            int y = find(parent, v);

            if (x != y) {
                System.out.println(u + " - " + v + "\t" + w);
                totalCost += w;
                union(parent, x, y);
                count++;
            }

            if (count == V - 1)
                break;
        }

        System.out.println("Total Cost = " + totalCost);
        sc.close();
    }
}
