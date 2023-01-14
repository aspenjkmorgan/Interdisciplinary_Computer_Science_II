public class GeneralizedHarmonic {
    public static void main(String[] args) {

        /* Take int command line args */
        int n = Integer.parseInt(args[0]);
        int r = Integer.parseInt(args[1]);

        /* Create double to find result */
        double result = 1;

        /* Use for-loop to calculate harmonic numbers */
        for (int i = 2; i <= n; i++) {
            result = result + 1 / (Math.pow(i, r));
        }

        /* Print result */
        StdOut.println(result);
    }
}
