import java.util.*;

public class tsp {
    static int n = 4;
    static int[][] graph = {
        {0, 10, 15, 20},
        {10, 0, 35, 25},
        {15, 35, 0, 30},
        {20, 25, 30, 0}
    };

    // h(n): A simple heuristic (min edge from current to any unvisited)
    static int getH(int curr, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        boolean allVisited = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && graph[curr][i] < min) {
                min = graph[curr][i];
                allVisited = false;
            }
        }
        return allVisited ? graph[curr][0] : min; 
    }

    static class Node {
        int curr, g, f, count;
        boolean[] visited;
        String path;

        Node(int curr, int g, int count, boolean[] v, String p) {
            this.curr = curr;
            this.g = g;
            this.count = count;
            this.visited = v.clone();
            this.visited[curr] = true;
            this.path = p + " -> " + curr;
            this.f = g + getH(curr, this.visited);
        }
    }

    public static void main(String[] args) {
        // PriorityQueue sorts by f(n) = g(n) + h(n)
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.f));
        
        pq.add(new Node(0, 0, 1, new boolean[n], "0"));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            // All cities visited, return to start
            if (node.count == n) {
                System.out.println("Best Path: " + node.path + " -> 0");
                System.out.println("Minimum Cost: " + (node.g + graph[node.curr][0]));
                break;
            }

            for (int i = 0; i < n; i++) {
                if (!node.visited[i]) {
                    pq.add(new Node(i, node.g + graph[node.curr][i], node.count + 1, node.visited, node.path));
                }
            }
        }
    }
}