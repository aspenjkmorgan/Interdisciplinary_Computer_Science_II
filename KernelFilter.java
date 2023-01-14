import java.awt.Color;

public class KernelFilter {

    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {

        int[][] iKernel = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        return help(picture, iKernel, 1);

    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {

        int[][] gKernel = {{1, 2, 1}, {2, 4, 2}, {1, 2, 1}};
        double fraction = (double) 1 / 16;
        return help(picture, gKernel, fraction);
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {

        int[][] sKernel = {{0, -1, 0}, {-1, 5, -1}, {0, -1, 0}};
        return help(picture, sKernel, 1);
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        int[][] lKernel = {{-1, -1, -1}, {-1, 8, -1}, {-1, -1, -1}};
        return help(picture, lKernel, 1);
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        int[][] eKernel = {{-2, -1, 0}, {-1, 1, 1}, {0, 1, 2}};
        return help(picture, eKernel, 1);
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {

        int[][] mKernel = {{1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1}};

        double fraction = (double) 1 / 9;
        return help(picture, mKernel, fraction);
    }

    // private helper function: takes kernel and picture and applies one to the other
    private static Picture help(Picture picture, int[][] kernel, double frac) {
        // Create new picture to hold result
        Picture pic = new Picture(picture.width(), picture.height());

        // iterate over all pixels
        for (int column = 0; column < picture.width(); column++) {
            for (int row = 0; row < picture.height(); row++) {

                double sumR = 0, sumG = 0, sumB = 0;
                int mp = kernel.length / 2;

                for (int j = 0; j < kernel.length; j++) {

                    for (int i = 0; i < kernel.length; i++) {

                        int x = column + i - mp, y = row + j - mp;

                        // boundary conditions
                        if (x < 0) {
                            x += picture.width();
                        }
                        if (y < 0) {
                            y += picture.height();
                        }
                        if (x >= picture.width()) {
                            x -= picture.width();
                        }
                        if (y >= picture.height()) {
                            y -= picture.height();
                        }

                        sumR += frac * kernel[j][i] * picture.get(x, y).getRed();
                        sumG += frac * kernel[j][i] * picture.get(x, y).getGreen();
                        sumB += frac * kernel[j][i] * picture.get(x, y).getBlue();
                    }
                }

                // Clamp red
                if (sumR < 0) sumR = 0;
                else if (sumR > 255) sumR = 255;
                int r = (int) Math.round(sumR);

                // Clamp green
                if (sumG < 0) sumG = 0;
                else if (sumG > 255) sumG = 255;
                int g = (int) Math.round(sumG);

                // Clamp blue
                if (sumB < 0) sumB = 0;
                else if (sumB > 255) sumB = 255;
                int b = (int) Math.round(sumB);

                // Set new pixel color
                Color result = new Color(r, g, b);
                pic.set(column, row, result);
            }
        }

        return pic;
    }


    public static void main(String[] args) {

        // get test image
        String file = args[0];
        Picture pict = new Picture(file);

        // test each function
        identity(pict).show();
        gaussian(pict).show();
        sharpen(pict).show();
        laplacian(pict).show();
        emboss(pict).show();
        motionBlur(pict).show();

    }

}


