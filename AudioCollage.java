/* I used https://www.geeksforgeeks.org/reverse-an-array-in-java/ as
inspiration to reverse my array */

public class AudioCollage {
    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] e = new double[a.length];
        if (alpha > 0) {
            for (int i = 0; i < a.length; i++) {
                e[i] = a[i] * alpha;
            }
        }

        return e;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] reversed = new double[a.length];

        int j = a.length;

        for (double v : a) {
            reversed[j - 1] = v;
            j = j - 1;
        }

        return reversed;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] c = new double[a.length + b.length];

        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);

        return c;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {

        // if array (a) is longer, append zeros to b and call it array c
        // then create d array to hold sum
        int length = Math.max(a.length, b.length);

        double[] c = new double[length];
        double[] d = new double[length];

        // if a > b
        if (a.length > b.length) {
            System.arraycopy(b, 0, c, 0, b.length);

            for (int i = b.length; i < a.length; i++) {
                c[i] = 0.0;
            }

            for (int j = 0; j < length; j++) {
                d[j] = c[j] + a[j];
            }
        }

        // if a < b
        else if (b.length > a.length) {
            System.arraycopy(a, 0, c, 0, a.length);

            for (int i = a.length; i < b.length; i++) {
                c[i] = 0.0;
            }

            for (int j = 0; j < length; j++) {
                d[j] = c[j] + b[j];
            }
        } else {
            for (int j = 0; j < length; j++) {
                d[j] = a[j] + b[j];
            }
        }

        return d;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {

        // create array e with a.length / alpha indexes
        int length = (int) (a.length / alpha);
        double[] e = new double[length];

        // preserve amplitude from a array
        for (int i = 0; i < length; i++) {

            int buf = (int) (i * alpha);
            e[i] = a[buf];
        }

        return e;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {


        double[] one = StdAudio.read("piano.wav");
        double[] two = StdAudio.read("harp.wav");
        double[] three = StdAudio.read("singer.wav");
        double[] four = StdAudio.read("chimes.wav");
        double[] five = StdAudio.read("beatbox.wav");

        // reverse singer
        three = reverse(three);

        // slow down beatbox (ending)
        five = changeSpeed(five, 4);

        // amplify chimes (beginning)
        double[] amp = amplify(four, 2);

        // combine singer and piano
        double[] combo = mix(three, one);
        combo = mix(combo, two);

        // append one to another
        double[] concert = merge(amp, combo);
        concert = merge(concert, five);

        for (int j = 0; j < concert.length; j++) {
            if (concert[j] > 1) {
                concert[j] = 1;
            } else if (concert[j] < -1) {
                concert[j] = -1;
            }
        }

        StdAudio.play(concert);
    }
}
