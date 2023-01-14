public class GreatCircle {

    public static void main(String[] args) {

        /* Constant */
        double twoRad = 12742.0;

        /* Create 4 double variables using command line args */
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));

        /* Find sin^2((x2-x1)/2) and cosx1 * cosx2 * sin^2((y2-y1)/2) */
        double part1 = Math.pow((Math.sin((x2 - x1) / 2)), 2);
        double part2 = Math.cos(x1) * Math.cos(x2) *
                Math.pow((Math.sin((y2 - y1) / 2)), 2);

        /* Use haversine formula to find approximate distance */
        double dis = twoRad * Math.asin(Math.sqrt(part1 + part2));

        /* Print result */
        StdOut.println(dis + " kilometers");
    }
}
