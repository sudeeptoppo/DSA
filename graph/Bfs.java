import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class Bfs {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void create(ArrayList<Edge>[] graph, int detail[][]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();

        }

        for (int i = 0; i < detail.length; i++) {
            for (int ele : detail[i]) {
                graph[i].add(new Edge(i, ele));
            }
        }
    }

    public static void bfs(int src, int v, ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[v];
        Queue<Integer> q = new LinkedList<>();
        visited[src] = true;
        q.add(src);
        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.println(curr);
            for (Edge ele : graph[curr]) {
                if (!visited[ele.dest]) {
                    visited[ele.dest] = true;
                    q.add(ele.dest);
                }
            }
        }
    }

    public static void main(String args[]) {
        int v = 5;
        int detail[][] = { { 1, 2 }, { 3 }, { 3 }, { 4 }, {} };
        ArrayList<Edge> graph[] = new ArrayList[v];
        create(graph, detail);
        bfs(0, v, graph);
    }
}