public class HelloGoodbye {
    public static void main(String[] args) {
        /* Take in 3 command line arguments for the names */
        String a = args[0];
        String b = args[1];

        /* Print greetings to each person */
        StdOut.println("Hello " + a + " and " + b + ".");

        StdOut.println("Goodbye " + b + " and " + a + ".");


    }
}
