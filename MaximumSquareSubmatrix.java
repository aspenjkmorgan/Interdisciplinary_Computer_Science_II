public class MaximumSquareSubmatrix {

    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {

        // Create new array so we don't mutate original
        int[][] b = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            System.arraycopy(a[i], 0, b[i], 0, a.length);
        }

        // Hold total count of size
        int count = 0;
        int buf = 0;

        // scan array for squares
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a.length; j++) {

                boolean together = false;
                // Check that the element is one
                if (b[i][j] != 0) {
                    buf = 1;
                    together = true;
                }

                // check north, north-west, and west
                if (!together || b[i - 1][j] == 0) {
                    together = false;
                }

                if (!together || b[i][j - 1] == 0) {
                    together = false;
                }

                if (!together || b[i - 1][j - 1] == 0) {
                    together = false;
                }

                if (together) {

                    // Find Min
                    int min = b[i - 1][j];
                    if (min > b[i][j - 1]) {
                        min = b[i][j - 1];
                    } else if (min > b[i - 1][j - 1]) {
                        min = b[i - 1][j - 1];
                    }

                    // Change element in matrix
                    b[i][j] = min + 1;

                    // adjust count to be max
                    if (b[i][j] > count) {
                        count = b[i][j];
                    }
                }
            }
        }


        if (count == 0 && buf == 0) {
            // scan top row and column
            for (int[] ints : a) {
                if (ints[0] != 0) {
                    count = 1;
                    break;
                }
            }

            for (int m = 0; m < a.length; m++) {
                if (b[0][m] != 0) {
                    count = 1;
                    break;
                }
            }
        } else if (count == 0) {
            count = buf;
        }

        return count;
    }

    public static void main(String[] args) {

        // read in 2d matrix
        int sz = StdIn.readInt();
        int[][] a = new int[sz][sz];

        for (int i = 0; i < sz; i++) {
            for (int j = 0; j < sz; j++) {
                a[i][j] = StdIn.readInt();
            }
        }

        // Call on size function
        StdOut.println(size(a));

    }
}
