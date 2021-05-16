package biweekly.biweekly23;

/**
 * Crated on:  Apr 04, 2020
 */
public class CircleAndRectangleOverlapping {
    public static void main(String[] args) {

    }

    public static boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
//        Find the closest value from circle vertex.
        int closest_x = closest(x_center, x1, x2);
        int closest_y = closest(y_center, y1, y2);

//        Get the distance from the center and the closest point.
        int distance_x = x_center - closest_x;
        int distance_y = y_center - closest_y;

//       Calculate the distance from the closest point and the radius
//       If the distance from closest point is less then or equal to radius then there is a overlap.
        return (distance_x * distance_x) + (distance_y * distance_y) <= radius * radius;
    }

    private static int closest(int center, int v1, int v2) {
//        v1 will always less then v2.
//        To get the closes value, get max(v1, min(v2,center))
        return Math.max(v1, Math.min(v2, center));
    }
}
