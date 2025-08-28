import java.util.ArrayList;

public class SafeState {
    public static boolean dfs(int node, boolean visited[], boolean path[], int adj[][], boolean safe[]) {
        visited[node] = true;
        path[node] = true;
        for (int nbr : adj[node]) {
            if (!visited[nbr]) {
                if (dfs(nbr, visited, path, adj, safe)) {
                    safe[node] = false;
                    return true;
                }
            } else {
                if (path[nbr]) {
                    safe[node] = false;
                    return true;
                }
            }
        }
        path[node] = false;
        safe[node] = true;
        return false;
    }

    public static void findSafeNodes(int v, int[][] adj) {
        boolean visited[] = new boolean[v];
        boolean path[] = new boolean[v];
        boolean safe[] = new boolean[v];
        for (int i = 0; i < v; i++) {
            safe[i] = false;
        }
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs(i, visited, path, adj, safe);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            if (safe[i]) {
                ans.add(i);
            }
        }
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }

    public static void main(String args[]) {
        int v = 9;
        int adj[][] = { { 4 }, { 5, 2 }, { 3 }, { 1 }, { 8 }, { 6 }, { 7 }, { 1 }, {} };
        findSafeNodes(v, adj);
    }
}
