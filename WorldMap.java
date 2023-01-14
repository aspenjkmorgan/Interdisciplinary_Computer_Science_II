public class WorldMap {
    public static void main(String[] args) {
        // Save width and height
        int width = StdIn.readInt();
        int height = StdIn.readInt();

        // Use width and height to define canvas
        StdDraw.setCanvasSize(width, height);

        // Set scale based on width and height
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);

        while (!StdIn.isEmpty()) {

            // Save region name
            String region = StdIn.readString();

            // Save vertices count
            int count = StdIn.readInt();

            // Define arrays for x and y components of vertices
            double[] x = new double[count];
            double[] y = new double[count];

            // Save each subsequent vertex into component arrays
            for (int i = 0; i < count; i++) {
                x[i] = StdIn.readDouble();
                y[i] = StdIn.readDouble();
            }

            // Draw polygon
            double rn = Math.random();

            if (rn < 0.25) {
                StdDraw.setPenColor(StdDraw.BLUE);
            } else if (rn < 0.5) {
                StdDraw.setPenColor(StdDraw.CYAN);
            } else if (rn < 0.75) {
                StdDraw.setPenColor(StdDraw.GREEN);
            } else {
                StdDraw.setPenColor(StdDraw.YELLOW);
            }

            StdDraw.filledPolygon(x, y);
        }
    }
}
