import java.util.LinkedList;
import java.util.Queue;

public class Floodfill2 {
    int dx[] = { -1, 0, 1, 0 };
    int dy[] = { 0, 1, 0, -1 };
    int r;
    int c;

    public void bfs(int sr, int sc, int originalColor, int color, int[][] image) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { sr, sc });
        image[sr][sc] = color;

        while (!q.isEmpty()) {
            int curr[] = q.remove();

            int i = curr[0], j = curr[1];

            for (int k = 0; k < 4; k++) {
                int ii = i + dx[k];
                int jj = j + dy[k];
                if (ii < 0 || jj < 0 || ii >= r || jj >= c || image[ii][jj] != originalColor) {
                    continue;
                }
                q.add(new int[] { ii, jj });
                image[ii][jj] = color;
            }

        }

    }

    public void floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        r = image.length;
        c = image[0].length;

        if (originalColor == color) {
            return;
        }
        bfs(sr, sc, originalColor, color, image);
    }

    public static void main(String args[]) {
        int image[][] = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int sr = 1, sc = 1, color = 2;
        Floodfill2 obj = new Floodfill2();

        obj.floodFill(image, sr, sc, color);

        for (int[] row : image) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }

    }

}
