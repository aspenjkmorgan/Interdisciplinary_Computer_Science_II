public class RecursiveSquares {

    // Draws a square centered on (x, y) of the given side length
    // with a light gray background and a black border.
    public static void drawSquare(double x, double y, double length) {

        double halfLength = length / 2;
        // Draw light gray squares
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, halfLength);

        // Draw black outlines around squares
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, halfLength);

    }

    // Draws a recursive square pattern of order n, centered on (x, y)
    // of the given side length.
    public static void draw(int n, double x, double y, double length) {
        if (n != 0) {

            // Draw back two squares
            draw(n - 1, x + (length / 2), y + (length / 2), length / 2);
            draw(n - 1, x - (length / 2), y + (length / 2), length / 2);

            // Draw main square
            drawSquare(x, y, length);

            // Draw front squares
            draw(n - 1, x - (length / 2), y - (length / 2), length / 2);
            draw(n - 1, x + (length / 2), y - (length / 2), length / 2);
        }

    }

    // Takes an integer command-line argument n and draws a recursive
    // square pattern of order n, centered on (0.5, 0.5) with side length 0.5.
    public static void main(String[] args) {

        // get order n
        int n = Integer.parseInt(args[0]);

        // call draw function
        draw(n, 0.5, 0.5, 0.5);

    }
}
