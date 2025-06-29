class Floodfill {
    int dx[] = { -1, 0, 1, 0 };
    int dy[] = { 0, 1, 0, -1 };
    int r;
    int c;

    public void dfs(int i, int j, int originalColor, int color, int[][] image) {
        if (i < 0 || j < 0 || i >= r || j >= c || image[i][j] != originalColor) {
            return;
        }
        image[i][j] = color;

        for (int k = 0; k < 4; k++) {
            int ii = i + dx[k];
            int jj = j + dy[k];
            dfs(ii, jj, originalColor, color, image);
        }
    }

    public void floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        r = image.length;
        c = image[0].length;

        if (originalColor == color) {
            return;
        }
        dfs(sr, sc, originalColor, color, image);
    }

    public static void main(String args[]) {
        int image[][] = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int sr = 1, sc = 1, color = 2;
        Floodfill obj = new Floodfill();

        obj.floodFill(image, sr, sc, color);

        for (int[] row : image) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }

    }

}