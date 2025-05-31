import java.util.ArrayList;

class Bfs {
    class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void main(String args[]) {
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

    }
}