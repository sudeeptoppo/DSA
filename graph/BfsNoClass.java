import java.util.Queue;
import java.util.LinkedList;

public class BfsNoClass {
    public static void bfs(int src, int n, int[][] graph) {
        boolean[] visited = new boolean[n];
        Queue<Integer> pq = new LinkedList<>();
        pq.add(src);
        visited[src] = true;
        while (!pq.isEmpty()) {
            int node = pq.poll();
            System.out.println(node);
            for (int nbr : graph[node]) {
                if (!visited[nbr]) {
                    pq.add(nbr);
                    visited[nbr] = true;
                }
            }
        }
    }

    public static void main(String args[]) {
        int v = 5;
        int graph[][] = { { 1, 2 }, { 3 }, { 3 }, { 4 }, {} };
        bfs(0, v, graph);
    }
}
