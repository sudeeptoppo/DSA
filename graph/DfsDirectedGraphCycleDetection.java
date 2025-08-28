public class DfsDirectedGraphCycleDetection {
    public static boolean dfs(int node, boolean visited[], boolean path[], int adj[][]) {
        visited[node] = true;
        path[node] = true;
        for (int nbr : adj[node]) {
            if (!visited[nbr]) {
                if (dfs(nbr, visited, path, adj)) {
                    return true;
                }
            } else {
                if (path[nbr]) {
                    return true;
                }
            }
        }
        path[node] = false;
        return false;

    }

    public static boolean isCycle(int v, int[][] adj) {
        boolean visited[] = new boolean[v];
        boolean path[] = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, path, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        int v = 8;
        int adj[][] = { { 1 }, { 2 }, { 3 }, { 4, 5 }, {}, { 4, 6 }, { 7 }, { 5 } };
        System.out.println(isCycle(v, adj));
    }
}
