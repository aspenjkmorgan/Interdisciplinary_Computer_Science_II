public class RandomWalker {

    public static void main(String[] args) {

        /* Initialize variables */
        int r = Integer.parseInt(args[0]);
        int dis = 0;
        double oneStep;

        int x = 0;
        int y = 0;
        StdOut.println("(" + x + ", " + y + ")");
        int count = 0;

        /* While loop to simulate walking */
        while (dis < r) {
            oneStep = Math.random();

            /* Conditionals to connect random with direction */
            if (oneStep < 0.25) {
                x += 1;
            } else if (oneStep < 0.5) {
                y += 1;
            } else if (oneStep < 0.75) {
                x -= 1;
            } else {
                y -= 1;
            }

            StdOut.println("(" + x + ", " + y + ")");

            dis = Math.abs(x) + Math.abs(y);

            count += 1;
        }

        StdOut.println("steps = " + count);
    }
}

