public class TrinomialDP {

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {

        // Created 2d array to hold result
        long[][] result = new long[n + 2][n + 2];

        // Make sure k is positive
        if (k < 0) {
            k = Math.abs(k);
        }

        // account for n=0 and k=0 situation
        result[0][0] = 1;

        // find result for other situations
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (k > n || k < -n) {
                    result[n][k] = 0;
                } else if (j == 0) {
                    result[i][j] = result[i - 1][Math.abs(j - 1)]
                            + result[i - 1][j] + result[i - 1][j + 1];
                } else {
                    result[i][j] = result[i - 1][j - 1] + result[i - 1][j] +
                            result[i - 1][j + 1];
                }
            }
        }

        return result[n][k];
    }


    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        StdOut.println(trinomial(n, k));
    }
}
