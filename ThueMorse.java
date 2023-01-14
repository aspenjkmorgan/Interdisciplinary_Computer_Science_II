public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        /* Create array to represent the series */
        int[] series = new int[n * n];

        for (int q = 0; q < n * n; q++) {

            if (q == 0) {
                series[q] = 0;
            } else if (q % 2 == 0) {
                series[q] = series[q / 2];
            } else {
                series[q] = 1 - series[q - 1];
            }
        }

        /* Print out the field using logic: if series[j] == series[i], print + */
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (series[i] == series[j]) {
                    StdOut.print("+");
                    StdOut.print("  ");
                } else {
                    StdOut.print("-");
                    StdOut.print("  ");
                }
            }

            StdOut.println();

        }
    }
}
