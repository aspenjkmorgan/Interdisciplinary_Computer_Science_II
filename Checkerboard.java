public class Checkerboard {
    public static void main(String[] args) {
        /* Take command line arg */
        int n = Integer.parseInt(args[0]);

        /* Set scale based on n */
        StdDraw.setScale(0, n);

        /* Use filled squares to draw checkerboard */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((j % 2 == 0) && (i % 2 != 0)) {
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                    StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
                } else if ((j % 2 != 0) && (i % 2 == 0)) {
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                    StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
                } else {
                    StdDraw.setPenColor(StdDraw.BLUE);
                    StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
                }
            }

        }
    }
}

