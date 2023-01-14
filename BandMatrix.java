public class BandMatrix {
    public static void main(String[] args) {

        /* Create two command line arg ints */
        int n = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);

        /* Define distance from diagonal */


        /* For loop to create n by n matrix */
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                int dis = Math.abs(j - i);

                if (dis <= width) {
                    StdOut.print("*");
                    StdOut.print("  ");

                } else {
                    StdOut.print("0");
                    StdOut.print("  ");
                }
            }

            StdOut.println();
        }
    }
}
