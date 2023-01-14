public class Clock {

    // this needs to be able to change
    private int h, m;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        if (h < 0 || h > 23) {
            throw new IllegalArgumentException("Hour input is out of bounds.");
        }
        if (m < 0 || m > 59) {
            throw new IllegalArgumentException("Minute input is out of bounds.");
        }

        this.h = h;
        this.m = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        if (s.length() != 5 || s.indexOf(':') != 2) {
            throw new IllegalArgumentException("Time format is invalid.");
        }

        if ((int) s.charAt(0) < 48 || (int) s.charAt(0) > 57) {
            throw new IllegalArgumentException("Time format is invalid.");
        } else if ((int) s.charAt(1) < 48 || (int) s.charAt(1) > 57) {
            throw new IllegalArgumentException("Time format is invalid.");
        } else if ((int) s.charAt(3) < 48 || (int) s.charAt(3) > 57) {
            throw new IllegalArgumentException("Time format is invalid.");
        } else if ((int) s.charAt(4) < 48 || (int) s.charAt(4) > 57) {
            throw new IllegalArgumentException("Time format is invalid.");
        }

        // need to parse string using split
        String[] hr_min = s.split(":");

        int hour = Integer.parseInt(hr_min[0]);
        int min = Integer.parseInt(hr_min[1]);

        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("Hour input is out of bounds.");
        }
        if (min < 0 || min > 59) {
            throw new IllegalArgumentException("Minute input is out of bounds.");
        }

        this.h = hour;
        this.m = min;
    }


    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {

        String hourRep = String.valueOf(this.h);
        String minRep = String.valueOf(this.m);

        if (this.h < 10) {
            hourRep = "0" + hourRep;
        }

        if (this.m < 10) {
            minRep = "0" + minRep;
        }

        return hourRep + ":" + minRep;
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (this.h < that.h) {
            return true;
        } else return this.h == that.h && this.m < that.m;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {

        if (this.h == 23 && this.m == 59) {
            this.h = 0;
            this.m = 0;
        } else if (this.m == 59) {
            this.m = 0;
            this.h += 1;
        } else {
            this.m += 1;
        }
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {

        if (delta < 0) {
            throw new IllegalArgumentException("Delta cannot be negative.");
        }

        // get hours and minutes
        int hr = delta / 60;
        int mn = delta % 60;

        this.h += hr;

        while (this.h >= 24) {
            this.h -= 24;
        }

        for (int i = 0; i < mn; i++) {
            tic();
        }

    }

    // Test client (see below).
    public static void main(String[] args) {

        Clock clockOne = new Clock(0, 0);
        Clock clockTwo = new Clock("HH:MM");

        StdOut.println("Is first time earlier than second time? " + clockOne.isEarlierThan(clockTwo));

        int add = 30000;
        clockOne.toc(add);
        StdOut.println("In " + add + " minutes it will be " + clockOne);

    }
}
