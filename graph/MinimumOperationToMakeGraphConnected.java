import java.util.ArrayList;

public class MinimumOperationToMakeGraphConnected {
    public static void dfs(int node, ArrayList<Integer>[] graph, boolean visited[]) {
        visited[node] = true;
        for (int nbr : graph[node]) {
            if (!visited[nbr]) {
                dfs(nbr, graph, visited);
            }
        }
    }

    public static int minimumOperations(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] ele : connections) {
            graph[ele[0]].add(ele[1]);
            graph[ele[1]].add(ele[0]);
        }
        boolean visited[] = new boolean[n];
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;
                dfs(i, graph, visited);
            }
        }
        return components - 1;
    }

    public static void main(String args[]) {
        int n = 4;
        int connections[][] = { { 0, 1 }, { 0, 2 }, { 1, 2 } };
        System.out.println(minimumOperations(n, connections));
    }
}
