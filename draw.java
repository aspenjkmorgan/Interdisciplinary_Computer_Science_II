import java.awt.*;

public class draw {
    public static void main(String[] args) {

        StdDraw.setPenColor(Color.green);
        StdDraw.filledSquare(0.0, 0.0, 1);

        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(Color.red);
        StdDraw.line(0.0, 0.0, 0.5, 1.0);
        StdDraw.line(0.5, 1.0, 1.0, 0.0);
        StdDraw.line(0.25, 0.5, 0.75, 0.5);

    }
}
