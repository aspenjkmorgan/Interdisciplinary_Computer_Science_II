public class deck {
    public static void main(String[] args) {

        String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] suit = {"♣", "♦", "♥", "♠"};
        String[] deck = new String[52];

        /* Switch between ordering by denom or by suit by switching 4*i + j with
        13*j +i  */
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                deck[13 * j + i] = rank[i] + suit[j];
            }
        }

        for (int k = 0; k < 52; k++) {
            StdOut.print(deck[k] + " ");
        }


    }
}

