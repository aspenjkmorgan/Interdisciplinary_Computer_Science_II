public class RandomWalkers {
    public static void main(String[] args) {

        /* Initialize variables */
        int r = Integer.parseInt(args[0]);
        double trials = Integer.parseInt(args[1]);
        double average;
        double totalCount = 0;

        for (int i = 0; i <= trials; i++) {

            double oneStep;
            double count = 0;

            int x = 0;
            int y = 0;
            int dis = 0;

            /* While loop to simulate walking */
            while (dis < r) {

                oneStep = Math.random();

                /* Conditionals to connect random with direction */
                if (oneStep <= 0.25) {
                    x += 1;
                } else if (oneStep <= 0.5) {
                    y += 1;
                } else if (oneStep <= 0.75) {
                    x -= 1;
                } else {
                    y -= 1;
                }

                dis = Math.abs(x) + Math.abs(y);

                count += 1;

            }

            totalCount += count;
        }

        average = totalCount / (trials + 1);
        StdOut.println("average number of steps = " + average);

    }
}
