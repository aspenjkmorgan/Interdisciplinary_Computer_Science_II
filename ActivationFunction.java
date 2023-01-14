public class ActivationFunction {

    // Heaviside Function
    public static double heaviside(double x) {
        if (x < 0) {
            return 0;
        } else if (x == 0) {
            return 0.5;
        } else if (x > 0) {
            return 1;
        } else {
            return Double.NaN;
        }
    }

    // Sigmoid Function
    public static double sigmoid(double x) {
        if (Double.isNaN(x)) {
            return Double.NaN;
        } else {
            return 1 / (1 + Math.exp(-x));
        }
    }

    // Hyperbolic Tangent Function
    public static double tanh(double x) {
        if (Double.isNaN(x)) {
            return Double.NaN;
        } else if (x > -20 && x < 20) {
            return (Math.exp(x) - Math.exp(-x)) / (Math.exp(x) + Math.exp(-x));
        } else if (x <= -20) {
            return -1.0;
        } else {
            return 1.0;
        }
    }

    // Softsign Function
    public static double softsign(double x) {
        if (Double.isNaN(x)) {
            return Double.NaN;
        } else if (x == Double.POSITIVE_INFINITY) {
            return 1.0;
        } else if (x == Double.NEGATIVE_INFINITY) {
            return -1.0;
        } else {
            return x / (1 + Math.abs(x));
        }
    }

    // Square Nonlinearity Function
    public static double sqnl(double x) {
        if (x <= -2) {
            return -1;
        } else if (x > -2 && x < 0) {
            return x + ((x * x) / 4);
        } else if (x >= 0 && x < 2) {
            return x - ((x * x) / 4);
        } else if (x >= 2) {
            return 1;
        } else {
            return Double.NaN;
        }

    }

    // Main (test) function
    public static void main(String[] args) {
        double i = Double.parseDouble(args[0]);

        // Print values for each function when i = input

        StdOut.println("heaviside(" + i + ") = " + heaviside(i));

        StdOut.println("sigmoid(" + i + ") = " + sigmoid(i));

        StdOut.println("tanh(" + i + ") = " + tanh(i));

        StdOut.println("softsign(" + i + ") = " + softsign(i));

        StdOut.println("sqnl(" + i + ") = " + sqnl(i));
    }
}
