public class PracticeSafeState {
    
    public static boolean dfs(boolean[] path, int[][] adj, boolean[] visited, int node)  {
        visited[node] = true;
        path[node] = true;

        for(int i = 0; i < adj[node].length; i++) {
            if(!visited[i]) {
                if(dfs(path, adj, visited, adj[node][i])) {
                    return true;
                }else {
                    if(path[adj[node][i]]) {
                        return true;
                    }
                }
            }
        }

        path[node] = false;
        return false;
    }
    
    public static boolean isSafeState(int n, int[][] adj, boolean[] path, boolean[] visited) {
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                if(dfs(path, adj, visited, i)) {
                    return true;
                }
            }
        }
        
        return false;
    }

    public static void main(String args[]) {
        int n = 8;
        int adj[][] = {{ 4 }, { 5, 2 }, { 3 }, { 1 }, { 8 }, { 6 }, { 7 }, { 1 }, {}};
        boolean[] visited = new boolean[n];
        boolean[] path = new boolean[n];
        isSafeState(n, adj, visited, path);

        int count = 0;
        for(int i = 0; i < path.length; i++) {
            if(!path[i]) {
                count++;
                System.out.println(i);
            }
        }
        System.out.print("safenodes = " + (n - count) );
        
    }
}
