public class Birthday {
    public static void main(String[] args) {
        /* Take int command args for n and trials */
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        boolean[] birthday = new boolean[n];

        /* Create double array to hold number of people who enter before duplicate */
        int[] peopleInRoom = new int[n + 2];

        for (int i = 0; i < trials; i++) {

            /* Default birthday values to false, represent empty room */
            for (int m = 0; m < n; m++) {
                birthday[m] = false;
            }

            for (int j = 0; j <= n; j++) {
                /* Generate random birthday */
                int rnBday = (int) ((n - 1) * Math.random());

                /* Compare to the room */
                if (birthday[rnBday]) {
                    peopleInRoom[j] += 1;
                    break;

                } else {
                    birthday[rnBday] = true;
                }
            }
        }

        int[] sum = new int[n + 2];
        sum[0] = 0;
        sum[1] = peopleInRoom[0];

        /* Sum the times x people entered the room before shared bday */
        StdOut.println(1 + "\t" + peopleInRoom[0] + "\t" + ((double) sum[1] / trials));

        for (int p = 2; p < n + 2; p++) {
            sum[p] = sum[p - 1] + peopleInRoom[p - 1];
            double dSum = sum[p];

            StdOut.println(p + "\t" + peopleInRoom[p - 1] + "\t" + (dSum / trials));

            if ((dSum / trials) >= 0.5) {
                break;
            }
        }
    }
}
