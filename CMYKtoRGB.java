public class CMYKtoRGB {
    public static void main(String[] args) {
        /* Take 4 doubles from command line args */
        double cyan = Double.parseDouble(args[0]);
        double mag = Double.parseDouble(args[1]);
        double yel = Double.parseDouble(args[2]);
        double black = Double.parseDouble(args[3]);

        /* Use equations to convert */
        double white = 1.0 - black;
        double red = 255.0 * white * (1 - cyan);
        double green = 255.0 * white * (1 - mag);
        double blue = 255.0 * white * (1 - yel);

        /* Round from double to float */
        long rd = Math.round(red);
        long gr = Math.round(green);
        long bl = Math.round(blue);

        /* Type cast to integers */
        int iRed = (int) rd;
        int iGreen = (int) gr;
        int iBlue = (int) bl;


        /* Print RGB values */
        StdOut.println("red = " + iRed);
        StdOut.println("green = " + iGreen);
        StdOut.println("blue = " + iBlue);
    }
}
