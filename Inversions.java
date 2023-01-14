public class Inversions {
    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {

        long ct = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    ct++;
                }
            }
        }
        return ct;
    }


    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {

        // define variables
        int max = n - 1;
        int min = 0;
        long buf = k;
        int high = n - 1;
        int invers = 0;

        // create an array
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = i;
        }

        // use the count function as we go
        for (int j = 0; j < n; j++) {

            if (invers < k && buf - max >= 0) {
                result[j] = high;
                buf = buf - max;
                high--;
                invers++;

            } else {
                result[j] = min;
                min++;
            }

            max--;
        }

        return result;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);

        for (int i = 0; i < n; i++) {
            StdOut.print(generate(n, k)[i] + " ");
        }
    }
}
