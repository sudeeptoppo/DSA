import java.util.Queue;
import java.util.LinkedList;

public class GeeksVillageAndWells {
    public int[][] findWells(int n, int m, char[][] grid) {
        int[][] direction = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        int[][] result = new int[n][m];

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'W') {
                    q.add(new int[] { i, j });
                }
            }
        }
        int counter = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                int[] current = q.poll();
                int row = current[0], col = current[1];
                for (int[] dir : direction) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && (grid[newRow][newCol] == 'H')) {
                        if (grid[newRow][newCol] == 'H') {
                            result[newRow][newCol] = 2 * counter;
                        }
                        grid[newRow][newCol] = 'X';
                        q.add(new int[] { newRow, newCol });
                    }
                }
                size--;
            }
            counter++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'H') {
                    result[i][j] = -1;
                }
            }
        }
        return result;

    }

    public static void main(String args[]) {
        // Initialize a sample grid with Wells (W), Houses (H), and empty spaces (.)
        char[][] grid = {
                { 'H', 'W', 'H', '.' },
                { 'H', 'H', '.', 'W' },
                { '.', 'H', 'H', '.' },
                { 'W', '.', '.', 'H' }
        };
        int n = grid.length;
        int m = grid[0].length;
        GeeksVillageAndWells g = new GeeksVillageAndWells();
        int[][] result = g.findWells(n, m, grid);

        // Print the result matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
