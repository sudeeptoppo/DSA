import java.util.ArrayList;
import java.util.LinkedList;

public class PracticeReordeer {
    public static int util(ArrayList<Integer>[] front, ArrayList<Integer>[] back, int n, boolean[] visited, int city) {
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < front[i].size(); i++) {
                if (!visited[front.get(i)[j]]) {
                    count++;
                    visited[front.get(i)[j]] = true;
                    util()
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < back[i].size(); i++) {
                if (!visited[back.get(i)[j]]) {
                    visited[back.get(i)[j]] = true;
                }
            }
        }
        return count;
    }

    public static int minReorder(int n, int[][] conections, int city) {
        ArrayList<Integer>[] front = new LinkedList[n];
        ArrayList<Integer>[] back = new LinkedList[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            front[i] = new ArrayList<>();
            back[i] = new ArrayList<>();
        }

        for (int[] edge : conections) {
            int a = edge[0];
            int b = edge[1];
            front[a].add(b);
            back[b].add(a);
        }
        return util(front, back, n, visited, city);
    }

    public static void main(String args[]) {
        int n = 6;
        int connections[][] = { { 0, 1 }, { 1, 3 },
                { 2, 3 }, { 4, 0 }, { 4, 5 } };
        System.out.println(minReorder(n, connections, 0));
    }
}
