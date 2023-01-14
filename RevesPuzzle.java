// Used hanoi.java from FAQ

public class RevesPuzzle {
    private static void reves(int n, String from, String to, String buf,
                              String buf2) {

        // Calculate k each time reves is called
        int k = n + 1 - (int) Math.round(Math.sqrt(2 * n + 1));

        // Base case
        if (k == 0) {
            StdOut.println("Move disc " + n + " from " + from + " to "
                    + buf2);
        }

        // Induction step
        else {
            hanoi(n - 1, from, to, buf);
            StdOut.println("Move disc " + n + " from " + from + " to " + to);
            reves(n - k, buf, from, to, buf2);
        }

    }


    private static void hanoi(int n, String from, String temp, String to) {
        if (n == 0) return;

        hanoi(n - 1, from, to, temp);
        StdOut.println("Move disc " + n + " from " + from + " to " + to);
        hanoi(n - 1, temp, from, to);

    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        reves(n, "A", "B", "C", "D");
    }
}
