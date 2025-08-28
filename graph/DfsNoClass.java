public class DfsNoClass {
    public static void dfs(int src, boolean visited[], int graph[][]) {
        System.out.println(src);
        visited[src] = true;
        for (int i = 0; i < graph[src].length; i++) {
            if (!visited[graph[src][i]]) {
                dfs(graph[src][i], visited, graph);
            }
        }
    }

    public static void main(String args[]) {
        int v = 5;
        int graph[][] = { { 1, 2 }, { 3 }, { 3 }, { 4 }, {} };
        dfs(0, new boolean[v], graph);// Start DFS from vertex 0
    }
}
