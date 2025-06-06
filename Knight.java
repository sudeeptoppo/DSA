import java.util.LinkedList;
import java.util.Queue;

public class Knight {

    private static int[][] coordinates = {
            { -1, -2 }, { -1, 2 }, { 1, -2 }, { 1, 2 },
            { -2, -1 }, { -2, 1 }, { 2, -1 }, { 2, 1 }
    };

    private static int helper(int src_x, int src_y, int dest_x, int dest_y, int n) {
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] { src_x, src_y });
        visited[src_x][src_y] = true;

        int steps = 0;

        while (!q.isEmpty()) {
            int qSize = q.size();
            while (qSize > 0) {
                int[] currentPos = q.remove();
                int x = currentPos[0];
                int y = currentPos[1];

                if (x == dest_x && y == dest_y) {
                    return steps;
                }

                for (int k = 0; k < coordinates.length; k++) {
                    int new_x = x + coordinates[k][0];
                    int new_y = y + coordinates[k][1];

                    if (new_x >= 0 && new_y >= 0 && new_x < n && new_y < n && !visited[new_x][new_y]) {
                        visited[new_x][new_y] = true;
                        q.add(new int[] { new_x, new_y });
                    }
                }
                qSize--;
            }
            steps++;
        }
        return -1; // If the target is unreachable
    }

    public static int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
        // Convert to 0-based index considering counting starts from the bottom
        int src_x = n - knightPos[0]; // Changed to n - knightPos[0]
        int src_y = knightPos[1] - 1; // Keep y-coordinate as is

        int dest_x = n - targetPos[0]; // Changed to n - targetPos[0]
        int dest_y = targetPos[1] - 1; // Keep y-coordinate as is

        return helper(src_x, src_y, dest_x, dest_y, n);
    }

    public static void main(String args[]) {
        int n = 6; // Size of the chessboard
        int knightPos[] = { 4, 5 }; // Knight's starting position
        int targetPos[] = { 1, 1 }; // Target position
        System.out.println(minStepToReachTarget(knightPos, targetPos, n)); // Output the result
    }
}
