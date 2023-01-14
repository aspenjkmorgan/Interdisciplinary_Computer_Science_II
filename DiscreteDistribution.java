/* Used
https://introcs.cs.princeton.edu/java/14array/DiscreteDistribution.java.html
for help to start. (I didn't understand the prompt.*/

public class DiscreteDistribution {
    public static void main(String[] args) {
        int i = 0;
        int n = args.length - 1;

        /* Take first command line int */
        int m = Integer.parseInt(args[0]);

        /* Create array of command line integers */
        int[] list = new int[n];

        for (int j = 0; j < n; j++) {
            list[j] = Integer.parseInt(args[j + 1]);
        }

        /* Define cumulative sums as an int value*/
        int sum = 0;

        for (int k = 0; k < n; k++) {
            sum += list[k];
        }

        /* Pick a random integer between 0 and Sn - 1 */
        for (int q = 0; q < m; q++) {
            int r = (int) (Math.random() * sum);

            /* Reset sum to zero */
            sum = 0;

            /* Find the unique index i */
            for (int p = 0; p < n && sum <= r; p++) {
                sum += list[p];
                i = p;
            }
            /* Print output, add 1 to i to get rid of zero indexes */
            StdOut.print((i + 1) + " ");
        }

    }

}

