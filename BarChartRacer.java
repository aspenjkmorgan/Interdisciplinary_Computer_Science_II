import java.util.Arrays;

public class BarChartRacer {

    public static void main(String[] args) {

        // get command line args for file name and number of bars
        String file = args[0];
        int k = Integer.parseInt(args[1]);

        // read file
        In in = new In(file);

        String title = in.readLine();
        String label = in.readLine();
        String source = in.readLine();

        BarChart chart = new BarChart(title, label, source);
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();

        while (!in.isEmpty()) {

            // create array of type bar with lg elements
            String whiteLine = in.readLine();
            int lg = Integer.parseInt(in.readLine());

            Bar[] list = new Bar[lg];
            String date = "";
            chart.setCaption(date);

            for (int i = 0; i < lg; i++) {
                String line = in.readLine();
                String[] lineArray = line.split(",");
                date = lineArray[0];
                String name = lineArray[1];
                int value = Integer.parseInt(lineArray[3]);
                String category = lineArray[4];

                // add to array
                list[i] = new Bar(name, value, category);
            }

            // sort the array
            Arrays.sort(list);

            // add sorted list to bar chart
            for (int j = lg - 1; j > lg - 1 - k; j--) {
                String nm = list[j].getName();
                int val = list[j].getValue();
                String cat = list[j].getCategory();
                chart.add(nm, val, cat);
            }

            // draw the bar chart
            chart.draw();
            StdDraw.show();
            StdDraw.pause(100);
            chart.reset();
            StdDraw.clear();
        }

    }
}
