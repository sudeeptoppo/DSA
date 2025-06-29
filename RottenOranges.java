import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    int dx[] = { -1, 0, 1, 0 };
    int dy[] = { 0, 1, 0, -1 };

    public int RottenOrange(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int ans = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[] { i, j });
                }
            }
        }

        while (!q.isEmpty()) {
            int temp = 0;
            int size = q.size();
            while (size != 0) {
                int[] curr = q.remove();
                for (int k = 0; k < 4; k++) {
                    int i = curr[0] + dx[k];
                    int j = curr[1] + dy[k];
                    if (i >= 0 && j >= 0 && i < r && j < c && grid[i][j] == 1) {
                        grid[i][j] = 2;
                        temp = 1;
                        q.add(new int[] { i, j });
                    }
                }
                size--;
            }
            ans += temp;
        }

        for (int[] row : grid) {
            for (int val : row) {
                if (val == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        int grid[][] = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        RottenOranges obj = new RottenOranges();
        System.out.println(obj.RottenOrange(grid));
    }
}
