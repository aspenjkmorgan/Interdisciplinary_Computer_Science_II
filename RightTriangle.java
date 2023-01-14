public class RightTriangle {
    public static void main(String[] args) {

        /* Create 3 integers from command line args */
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        /* Make sure all sides are positive */
        boolean pos = (a > 0 && b > 0 && c > 0);

        /* Create a boolean conditional to determine if its a valid equation */
        boolean isEqual = ((a * a + b * b == c * c) ||
                (a * a + c * c == b * b) ||
                (b * b + c * c == a * a));

        /* Make sure both isEqual and nonNeg are true */
        boolean isRight = (isEqual && pos);

        /* Print result */
        StdOut.println(isRight);
    }
}
