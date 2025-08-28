import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {
    public static void sort(int[][] adj) {
        int n = adj.length;
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < adj[i].length; i++) {
                indegree[adj[i][j]]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");
            System.out.println();
            for (int nbr : adj[curr]) {
                indegree[nbr]--;
                if (indegree[nbr] == 0) {
                    q.add(nbr);
                }
            }
        }

    }

    public static void main(String args[]) {
        int adj[][] = { { 2 }, { 2 }, { 3, 4 }, { 6 }, { 6 }, { 4 }, {} };
        sort(adj);
    }
}
