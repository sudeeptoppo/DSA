import java.util.LinkedList;
import java.util.Queue;

public class Knight {

    static int[][] moves = { { -1, -2 }, { -1, 2 }, { 1, -2 }, { 1, 2 },
            { -2, -1 }, { -2, 1 }, { 2, -1 }, { 2, 1 } };

    public static int bfs(int src_x, int src_y, int tar_x, int tar_y, int n) {
        boolean visited[][] = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { src_x, src_y });
        visited[src_x][src_y] = true;

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                int curr[] = q.poll();
                int curr_x = curr[0];
                int curr_y = curr[1];
                if (curr_x == tar_x && curr_y == tar_y) {
                    return steps;
                }
                for (int i = 0; i < moves.length; i++) {
                    int new_x = curr_x + moves[i][0];
                    int new_y = curr_y + moves[i][1];

                    if (new_x >= 0 && new_y >= 0 && new_x < n && new_y < n && !visited[new_x][new_y]) {
                        visited[new_x][new_y] = true;
                        q.add(new int[] { new_x, new_y });
                    }
                }
                size--;
            }
            steps++;
        }

        return -1;

    }

    public static int minStep(int[] knightPos, int[] targetPos, int n) {
        int src_x = n - knightPos[1];
        int src_y = knightPos[0] - 1;

        int tar_x = n - knightPos[1];
        int tar_y = targetPos[0] - 1;

        return bfs(src_x, src_y, tar_x, tar_y, n);
    }

    public static void main(String args[]) {
        int n = 6;
        int knightPos[] = { 4, 5 };
        int targetPos[] = { 1, 1 };
        System.out.println(minStep(knightPos, targetPos, n));
    }
}
