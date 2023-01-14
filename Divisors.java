public class Divisors {

    // Returns the greatest common divisor of a and b.
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        if (a == 0 && b == 0) {
            return 0;
        }

        while (b != 0) {
            int buf = b;
            b = a % b;
            a = buf;
        }

        return a;
    }

    // Returns the least common multiple of a and b.
    public static int lcm(int a, int b) {

        if (a == 0 && b == 0) {
            return 0;
        }

        // Find the denominator by calling on gcd function
        int denom = gcd(a, b);

        // Get abs of a and b
        a = Math.abs(a);
        b = Math.abs(b);

        // Divide then multiply
        int part1 = a / denom;
        return part1 * b;
    }

    // Returns true if a and b are relatively prime; false otherwise.
    public static boolean areRelativelyPrime(int a, int b) {
        return gcd(a, b) == 1;
    }

    // Returns the number of integers between 1 and n that are
    // relatively prime with n.
    public static int totient(int n) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (areRelativelyPrime(i, n)) {
                count++;
            }
        }

        return count;
    }

    // Takes two integer command-line arguments a and b and prints
    // each function, evaluated in the format (and order) given below.
    public static void main(String[] args) {

        // Take in two int command line arguments
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);

        // Print results by passing x and y through each function
        StdOut.println("gcd(" + x + ", " + y + ") = " + gcd(x, y));
        StdOut.println("lcm(" + x + ", " + y + ") = " + lcm(x, y));
        StdOut.println("areRelativelyPrime(" + x + ", " + y + ") = " +
                areRelativelyPrime(x, y));
        StdOut.println("totient(" + x + ") = " + totient(x));
        StdOut.println("totient(" + y + ") = " + totient(y));
    }
}
