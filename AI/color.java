import java.util.Scanner;

public class color {

    static int graph[][];
    static int result[];
    static int n, m;

    // Check whether color can be assigned
    static boolean isSafe(int node, int c) {
        for (int i = 0; i < n; i++) {
            // If there is an edge and the neighbor has the same color
            if (graph[node][i] == 1 && result[i] == c) {
                return false;
            }
        }
        return true;
    }

    // Solve Graph Coloring using Backtracking
    static boolean solve(int node) {
        // Base Case: All vertices are assigned a color
        if (node == n) {
            return true;
        }

        // Try different colors for the current node
        for (int c = 1; c <= m; c++) {
            if (isSafe(node, c)) {
                result[node] = c; // Assign color

                // Recur to assign colors to the rest of the vertices
                if (solve(node + 1)) {
                    return true;
                }

                // Backtrack: Reset if no color works
                result[node] = 0;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        n = sc.nextInt();

        graph = new int[n][n];
        result = new int[n];

        System.out.println("Enter adjacency matrix (0s and 1s):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter number of colors: ");
        m = sc.nextInt();

        if (solve(0)) {
            System.out.println("\nSolution Exists. Vertex Assignments:");
            for (int i = 0; i < n; i++) {
                System.out.println("Vertex " + i + " -> Color " + result[i]);
            }
        } else {
            System.out.println("\nSolution does not exist with " + m + " colors.");
        }

        sc.close();
    }
}