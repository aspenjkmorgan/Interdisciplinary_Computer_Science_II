public class FinalAssignment {
    public static void main(String[] args) {
        // take command line arguments: k=order and m=number of pseudo-random characters
        int k = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        // read in text file as training input and put pieces into graph
        String file = args[2];
        In in = new In(file);
        MarkovChain theChain = new MarkovChain();
        String text = in.readAll().trim();
        String[] piece = new String[text.length()];

        for (int i = 0; i < text.length(); i++) {
            // remember periodic boundary condition
            if (i + (k - 1) < text.length()) {
                piece[i] = text.substring(i, i + k);
            } else {
                int buf = k - Math.abs((text.length() - i));
                piece[i] = text.substring(i).concat(text.substring(0, buf));
            }
        }

        for (int i = 0; i < piece.length - 1; i++) {
            theChain.addTransition(piece[i], piece[i + 1]);
        }

        // print out start of chain! Then do m - k calls to next(v)
        String current = piece[0];
        StdOut.print(current);

        int calls = m - k;
        while (calls > 0) {
            StdOut.print(current.substring(k - 1));
            current = theChain.next(current);

            calls--;
        }


    }
}
