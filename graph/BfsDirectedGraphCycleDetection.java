import java.util.LinkedList;
import java.util.Queue;

public class BfsDirectedGraphCycleDetection {
    public static boolean sort(int[][] adj) {
        int n = adj.length;
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            for (int nbr : adj[i]) {
                indegree[nbr]++;
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
            for (int nbr : adj[curr]) {
                indegree[nbr]--;
                if (indegree[nbr] == 0) {
                    q.add(nbr);
                }
            }
        }

        for (int ele : indegree) {
            if (ele != 0) {
                return true;
            }
        }
        return false;

    }

    public static void main(String args[]) {
        // int adj[][] = { { 2 }, { 2 }, { 3, 4 }, { 6 }, { 6 }, { 4 }, {} };
        int adj[][] = { { 2 }, { 2 }, { 3 }, { 6 }, { 2 }, { 4 }, { 4 } };
        if (sort(adj)) {
            System.out.println("cycle exist");
        } else {
            System.out.println("no cycle");
        }
    }
}
