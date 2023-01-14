public class InClass {
    public static void main(String[] args) {
        double x = StdIn.readDouble();
        double max = x;
        double min = x;

        while (!StdIn.isEmpty()) {
            x = StdIn.readDouble();

            if (x > max) {
                max = x;
            } else if (x < min) {
                min = x;
            }
        }

        StdOut.println("The largest number is : " + max);
        StdOut.println("The smallest number is : " + min);
    }
}
