import java.util.*;

class HTreeConstruction {
    static public void main(String[] args) {
        System.out.println("Should draw 3 Lines");
        drawHTree(1.0, 1);
        System.out.println("Should draw 15 Lines");
        drawHTree(2.0, 2);
    }

    static void drawHTree(double length, int depth) {
        drawHTreeHelper(length, depth, 0.0, 0.0);
    }

    static void drawHTreeHelper(double length, int depth, double x, double y) {
        if (depth == 0) return;
        double[][] result = helper(x, y, length, depth--);
        length = Math.sqrt(length);
        for (double[] cordinates : result) {
            drawHTreeHelper(length, depth, cordinates[0], cordinates[1]);
        }
    }

    // Draw 3 lines from a given point
    static double[][] helper(double x, double y, double length, int count) {
        double[][] op = new double[4][2];
        double innerLength = length / 2;
        double xMin = x - innerLength;
        double xMax = x + innerLength;
        double yMin = y - innerLength;
        double yMax = y + innerLength;
        // Draw the horizontal Line
        drawLine(xMin, y, xMax, y);
        // Draw two vertical lines
        drawLine(xMin, yMin, xMin, yMax);
        drawLine(xMax, yMin, xMax, yMax);
        // Assign output of the new vertices.
        op[0] = new double[]{xMin, yMax};
        op[1] = new double[]{xMin, yMin};
        op[2] = new double[]{xMax, yMax};
        op[3] = new double[]{xMax, yMin};
        return op;
    }

    static void drawLine(double x1, double y1, double x2, double y2) {
        System.out.println("Drawing Line:\t" + "from:" + x1 + " " + y1 + " to:" + x2 + " " + y2);
    }
}
