import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class BfsCycleDetection {

    public static boolean bfs(ArrayList<Integer>[] list, boolean[] visited, int node, int v) {
        Queue<Integer> q = new LinkedList<>();
        int parent[] = new int[v];
        Arrays.fill(parent, -1);

        q.add(node);
        visited[node] = true;

        while (!q.isEmpty()) {
            int curr = q.remove();

            for (int nbr : list[curr]) {
                if (!visited[nbr]) {
                    q.add(nbr);
                    parent[nbr] = curr;
                    visited[nbr] = true;
                } else if (visited[nbr] && nbr != parent[curr]) {
                    return true;
                }
            }

        }
        return false;

    }

    public static boolean isCycle(ArrayList<Integer>[] list, int v) {
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (bfs(list, visited, i, v)) {
                    return true;
                }
            }
        }
        return false;

    }

    public static void main(String args[]) {
        int v = 4;
        int edges[][] = { { 1 }, { 0, 2, 3 }, { 1 }, { 1, 2 } };

        ArrayList<Integer>[] list = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            list[i] = new ArrayList<>(); // Initialize each ArrayList
        }

        for (int i = 0; i < v; i++) {
            for (int j : edges[i]) {
                list[i].add(j);
            }

        }

        boolean hasCycle = isCycle(list, v);
        System.out.println("Graph has cycle: " + hasCycle);
    }
}
