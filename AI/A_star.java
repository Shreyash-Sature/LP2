import java.util.*;

public class A_star {
    static int[][] goal = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};

    // h(n): Misplaced tiles heuristic
    static int getH(int[][] s) {
        int h = 0;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (s[i][j] != 0 && s[i][j] != goal[i][j]) h++;
        return h;
    }

    static class Node {
        int[][] mat;
        int g, f;
        Node(int[][] m, int g) {
            this.mat = m;
            this.g = g;
            this.f = g + getH(m);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] start = new int[3][3];
        System.out.println("Enter 3x3 Initial State (0 for blank):");
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) start[i][j] = sc.nextInt();

        // Priority Queue sorts by f(n) = g(n) + h(n)
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.f));
        Set<String> visited = new HashSet<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            String stateStr = Arrays.deepToString(curr.mat);
            if (visited.contains(stateStr)) continue;
            visited.add(stateStr);

            // Print current state details
            System.out.println("\n--- g=" + curr.g + ", h=" + (curr.f - curr.g) + ", f=" + curr.f + " ---");
            for (int[] row : curr.mat) System.out.println(Arrays.toString(row));

            if (Arrays.deepEquals(curr.mat, goal)) {
                System.out.println("\nSUCCESS: Goal state reached!");
                break;
            }

            // Logic to move the blank space (0)
            int x = 0, y = 0;
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    if (curr.mat[i][j] == 0) { x = i; y = j; }

            int[][] moves = {{1,0}, {-1,0}, {0,1}, {0,-1}};
            for (int[] m : moves) {
                int nx = x + m[0], ny = y + m[1];
                if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
                    int[][] nextMat = new int[3][3];
                    for (int i = 0; i < 3; i++) nextMat[i] = curr.mat[i].clone();
                    
                    nextMat[x][y] = nextMat[nx][ny];
                    nextMat[nx][ny] = 0;
                    pq.add(new Node(nextMat, curr.g + 1));
                }
            }
        }
        sc.close();
    }
}