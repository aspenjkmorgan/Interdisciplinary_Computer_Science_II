public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {

        // Define variables
        String sub;
        int count = 0;
        int max = 0;
        boolean consecutive = true;

        // start to reduce String after finding each CAG
        int i = dna.indexOf('C');
        if (i == -1) return 0;

        while (i < dna.length()) {

            // make sure search is staggered correctly
            if (dna.charAt(i) != 'C' || i + 2 >= dna.length()) {
                consecutive = false;
                sub = "";
            } else {
                sub = dna.substring(i, i + 3);
            }

            if (!consecutive) {
                count = 0;
            }

            if (sub.equals("CAG")) {
                consecutive = true;
                count++;
                i += 3;
            } else {
                consecutive = false;
                i++;
            }

            // keep track of the largest ongoing count
            if (max < count) {
                max = count;
            }
        }

        return max;
    }

    // 2. Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    // use replace all
    public static String removeWhitespace(String s) {

        s = s.replace(" ", "");
        s = s.replace("\t", "");
        s = s.replace("\n", "");

        return s;
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats < 10 || maxRepeats > 180) {
            return "not human";
        } else if (maxRepeats <= 35) {
            return "normal";
        } else if (maxRepeats <= 39) {
            return "high risk";
        } else {
            return "Huntington's";
        }
    }

    // Sample client (see below).
    public static void main(String[] args) {

        // Read in String
        String file = args[0];
        String s = new In(file).readAll();

        // Remove white spaces
        s = removeWhitespace(s);

        // count repeats and print
        int count = maxRepeats(s);
        StdOut.println("max repeats = " + count);

        // Diagnose
        StdOut.println(diagnose(count));
    }
}
