public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {

        long a = 1;
        int count = 0;

        // keep track of duplicates
        double buf = 0;

        while (a < Math.cbrt(n)) {
            double b = Math.cbrt(n - a * a * a);

            // check if cube roots are ints
            if (b == (int) b && b != buf) {
                count++;
                buf = a;
            }

            a++;
        }

        return count >= 2;
    }


    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        StdOut.println(isRamanujan(n));
    }
}
