public class Minesweeper {
    public static void main(String[] args) {
        /* command line args: */
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        int[][] count = new int[m][n];
        boolean[][] mines = new boolean[m][n];

        /* Place mines in array */
        for (int i = 0; i < k; i++) {
            double x = m * Math.random();
            double y = n * Math.random();
            int a = (int) (x);
            int b = (int) (y);

            if (mines[a][b]) {
                i -= 1;
            } else {
                mines[a][b] = true;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if ((i > 0) && mines[i - 1][j]) {
                    count[i][j] += 1;
                }
                if ((j > 0) && mines[i][j - 1]) {
                    count[i][j] += 1;
                }
                if ((i < m - 1) && mines[i + 1][j]) {
                    count[i][j] += 1;
                }
                if ((j < n - 1) && mines[i][j + 1]) {
                    count[i][j] += 1;
                }
                if ((i > 0) && (j > 0) && mines[i - 1][j - 1]) {
                    count[i][j] += 1;
                }
                if ((i < m - 1) && (j > 0) && mines[i + 1][j - 1]) {
                    count[i][j] += 1;
                }
                if ((i > 0) && (j < n - 1) && mines[i - 1][j + 1]) {
                    count[i][j] += 1;
                }
                if ((i < m - 1) && (j < n - 1) && mines[i + 1][j + 1]) {
                    count[i][j] += 1;
                }
            }
        }

        /* Print the field */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mines[i][j]) {
                    StdOut.print("*");
                    StdOut.print("  ");
                } else {
                    StdOut.print(count[i][j]);
                    StdOut.print("  ");
                }
            }

            StdOut.println();
        }
    }
}
