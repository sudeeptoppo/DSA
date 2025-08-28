import java.util.ArrayList;

public class Reorderer {
    static int ans = 0;

    public static void dfs(int n, boolean[] visited, ArrayList<Integer>[] forward, ArrayList<Integer>[] backward,
            int city) {
        visited[city] = true;
        for (int nbr : forward[city]) {
            if (!visited[nbr]) {
                ans++;
                dfs(n, visited, forward, backward, nbr);
            }
        }
        for (int nbr : backward[city]) {
            if (!visited[nbr]) {
                dfs(n, visited, forward, backward, nbr);
            }
        }
    }

    public static int minReorder(int n, int connections[][]) {
        ArrayList<Integer>[] forward = new ArrayList[n];
        ArrayList<Integer>[] backward = new ArrayList[n];
        boolean visited[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            forward[i] = new ArrayList<>();
            backward[i] = new ArrayList<>();
        }
        for (int i = 0; i < connections.length; i++) {
            int a = connections[i][0];
            int b = connections[i][1];
            forward[a].add(b);
            backward[b].add(a);
        }

        dfs(n, visited, forward, backward, 0);
        return ans;
    }

    public static void main(String args[]) {
        int n = 6;
        int connections[][] = { { 0, 1 }, { 1, 3 },
                { 2, 3 }, { 4, 0 }, { 4, 5 } };
        System.out.println(minReorder(n, connections));
    }
}
