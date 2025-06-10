
//undirected graph
import java.util.ArrayList;

public class DfsCycleDetection {
    public static boolean dfs(int node, ArrayList<Integer>[] list, boolean[] visited, int parent) {
        visited[node] = true;
        for (int nbr : list[node]) {
            if (!visited[nbr]) {
                if (dfs(nbr, list, visited, node)) {
                    return true;
                }
            } else if (visited[nbr] && parent != nbr) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCycle(int v, ArrayList<Integer>[] list) {
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                boolean ans = dfs(i, list, visited, -1);
                if (ans) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int v = 4;
        ArrayList<Integer>[] list = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            list[i] = new ArrayList<>();
        }

        // Convert the 2D array to an ArrayList structure
        int[][] edges = { { 1 }, { 0, 2, 3 }, { 1 }, { 1, 2 } };
        for (int i = 0; i < v; i++) {
            for (int j : edges[i]) {
                list[i].add(j);
            }
        }

        // Check for cycles
        boolean hasCycle = isCycle(v, list);
        System.out.println("Graph has cycle: " + hasCycle);
    }
}
