public class ShannonEntropy {
    public static void main(String[] args) {
        /* Take in command line arg */
        int m = Integer.parseInt(args[0]);
        int entry;
        int amount = 0;
        int max = 0;

        int[] xi = new int[m + 1];
        double pSubI;
        double sum = 0.0;

        /* Read each int and count the number of repetitions */
        while (!StdIn.isEmpty()) {
            entry = StdIn.readInt();
            amount++;

            if (entry > max) {
                max = entry;
            }

            xi[entry]++;
        }

        for (int i = 1; i <= max; i++) {

            pSubI = ((double) xi[i]) / amount;

            if (pSubI == 0) {
                sum += 0;
            } else {
                sum += pSubI * (Math.log(pSubI) / Math.log(2));
            }
        }

        /* Sum each piece according to the formula */
        StdOut.printf("%.4f\n", -sum);
    }
}
