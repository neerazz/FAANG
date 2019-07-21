import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

/*
Problem Description
Task. Given 𝑛 points on a plane, find the smallest distance between a pair of two (different) points. Recall
that the distance between points (𝑥1, 𝑦1) and (𝑥2, 𝑦2) is equal to √︀
(𝑥1 − 𝑥2)
2 + (𝑦1 − 𝑦2)
2.
Input Format. The first line contains the number 𝑛 of points. Each of the following 𝑛 lines defines a point
(𝑥𝑖
, 𝑦𝑖).
Constraints. 2 ≤ 𝑛 ≤ 105
; −109 ≤ 𝑥𝑖
, 𝑦𝑖 ≤ 109 are integers.
Output Format. Output the minimum distance. The absolute value of the difference between the answer
of your program and the optimal value should be at most 10−3
. To ensure this, output your answer
with at least four digits after the decimal point (otherwise your answer, while being computed correctly,
can turn out to be wrong because of rounding issues).
Sample 1.
Input:
2
0 0
3 4
Output:
5.0
There are only two points here. The distance between them is 5.
Sample 2.
Input:
4
7 7
1 100
4 8
7 7
Output:
0.0
There are two coinciding points among the four given points. Thus, the minimum distance is zero.
Sample 3.
Input:
11
4 4
-2 -2
-3 -4
-1 3
2 3
-4 0
1 1
-1 -1
3 -1
-4 2
-2 4
Output:
1.414213

Sample 4:
Input:
4
0 0
5 6
3 4
7 2
Output:
2.828427125

Solution: https://www.geeksforgeeks.org/closest-pair-of-points-using-divide-and-conquer-algorithm/
 */
public class Week4ClosestPoints {

    private static Double distance = Double.MAX_VALUE;

    public static void main(String[] args) {
        int numberOfCoordinates = FastScan.nextInt();
        Coordinate[] coordinates = new Coordinate[numberOfCoordinates];
        for (int i = 0; i < numberOfCoordinates; i++) {
            Coordinate coordinate = new Coordinate(FastScan.nextInt(), FastScan.nextInt());
            coordinates[i] = coordinate;
        }
        findClosestPoint(coordinates, numberOfCoordinates);
        DecimalFormat df = new DecimalFormat("0.000######");
        df.setRoundingMode(RoundingMode.CEILING);
        System.out.println(df.format(distance));
    }

    private static void findClosestPoint(Coordinate[] coordinates, int n) {
        if (n == 1) checkDistance(coordinates[0], coordinates[1]);
        if (n < 2) {
            return;
        }
        int mid = n / 2;

//            Split it into 2 and assign values.
        Coordinate[] left = new Coordinate[mid];
        Coordinate[] right = new Coordinate[n - mid];

        for (int i = 0; i < mid; i++) left[i] = coordinates[i];
        for (int i = mid; i < n; i++) right[i - mid] = coordinates[i];

        findClosestPoint(left, left.length - 1);
        findClosestPoint(coordinates, right.length - 1);

//        Merge the array.
        findClosestMergePoint(left, right);
    }

    private static void findClosestMergePoint(Coordinate[] left, Coordinate[] right) {

        for (int i = 0; i < left.length; i++) {
            for (int j = 0; j < right.length; j++) {
                checkDistance(left[i], right[j]);
            }
        }
    }

    private static void checkDistance(Coordinate coordinate1, Coordinate coordinate2) {
        Double calculatedDistance = calculateDistance(coordinate1, coordinate2);
        if (calculatedDistance < distance) distance = calculatedDistance;
    }

    private static Double calculateDistance(Coordinate coordinate1, Coordinate coordinate2) {
        long x = (long) (coordinate1.x - coordinate2.x) * (coordinate1.x - coordinate2.x);
        long y = (long) (coordinate1.y - coordinate2.y) * (coordinate1.y - coordinate2.y);
        return Math.sqrt(x + y);
    }

    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class FastScan {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st;

        static String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        static int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
