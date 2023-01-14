public class ColorHSB {

    // declare scope and type of constructor variables
    private final int h, s, b;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {

        // error check
        if (h > 359 || h < 0) {
            throw new IllegalArgumentException("Hue is out of bounds.");
        }
        if (s > 100 || s < 0) {
            throw new IllegalArgumentException("Saturation is out of bounds.");
        }
        if (b > 100 || b < 0) {
            throw new IllegalArgumentException("Brightness is out of bounds.");
        }

        this.h = h;
        this.s = s;
        this.b = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return " (" + this.h + ", " + this.s + ", " + this.b + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return this.s == 0 || this.b == 0;
    }

    // Returns the squared distance between the two colors. Make sure angle is minimum
    public int distanceSquaredTo(ColorHSB that) {

        if (that == null) {
            throw new IllegalArgumentException("Argument is null");
        }

        double deg1 = Math.pow(360 - Math.abs(this.h - that.h), 2);
        double deg2 = Math.pow((this.h - that.h), 2);
        double min = Math.min(deg1, deg2);
        double dis = min + Math.pow((this.s - that.s), 2) +
                Math.pow((this.b - that.b), 2);


        return (int) Math.round(dis);
    }

    // Sample client (see below).
    public static void main(String[] args) {

        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);

        ColorHSB color1 = new ColorHSB(h, s, b);

        // Read standard input
        int smallestDis = 1000000;
        String name = "";
        int fHue = 0, fSat = 0, fBri = 0;

        while (!StdIn.isEmpty()) {

            String colorName = StdIn.readString();
            int hue = StdIn.readInt();
            int sat = StdIn.readInt();
            int bri = StdIn.readInt();

            ColorHSB color2 = new ColorHSB(hue, sat, bri);

            int buf = color1.distanceSquaredTo(color2);

            if (buf < smallestDis) {
                smallestDis = buf;
                name = colorName;
                fHue = hue;
                fSat = sat;
                fBri = bri;

            }
        }

        ColorHSB bestMatch = new ColorHSB(fHue, fSat, fBri);

        // Print to user
        StdOut.println(name + bestMatch);


    }

}
