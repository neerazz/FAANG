import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Organizing a Lottery
Problem Introduction
You are organizing an online lottery. To participate, a person bets on a single
integer. You then draw several ranges of consecutive integers at random.
A participant’s payoff then is proportional to the number of ranges that
contain the participant’s number minus the number of ranges that does not
contain it. You need an efficient algorithm for computing the payoffs for all
participants. A naive way to do this is to simply scan, for all participants, the
list of all ranges. However, you lottery is very popular: you have thousands
of participants and thousands of ranges. For this reason, you cannot afford
a slow naive algorithm.

Sample 1.
Input:
2 3
0 5
7 10
1 6 11
Output:
1 0 0
Explanation: Here, we have two segments and three points. The first point lies only in the first segment while the
remaining two points are outside of all the given segments.
Sample 2.
Input:
1 3
-10 10
-100 100 0
Output:
0 0 1
Sample 3.
Input:
3 2
0 5
-3 2
7 10
1 6
Output:
2 0

 */

public class Week4OrganizingALottery {
    public static void main(String[] args) {
        int numberOfSegments = FastScan.nextInt();
        int numberOfPoints = FastScan.nextInt();
        int[][] segments = new int[numberOfSegments][2];

        for (int i = 0; i < numberOfSegments; i++) {
            segments[i][0] = FastScan.nextInt();
            segments[i][1] = FastScan.nextInt();
        }

        int[] points = new int[numberOfPoints];
        for (int i = 0; i < numberOfPoints; i++) {
            points[i] = FastScan.nextInt();
        }

        int[] theNeareastNumberOfSegment = getTheNeareastNumberOfSegment(segments, numberOfSegments, points, numberOfPoints);
        for (int i = 0; i < numberOfPoints; i++) {
            System.out.print(theNeareastNumberOfSegment[i] + " ");
        }
    }

    private static int[] getTheNeareastNumberOfSegment(int[][] segments, int numberOfSegments, int[] points, int numberOfPoints) {
        int[] result = new int[numberOfPoints];

        for (int i = 0; i < numberOfPoints; i++) {
            int currentPoint = points[i];
            result[i] = findCurrentPointSegment(segments, numberOfSegments, currentPoint);
        }
        return result;
    }

    private static int findCurrentPointSegment(int[][] segments, int numberOfSegments, int currentPoint) {
        for (int j = numberOfSegments - 1; j >= 0; j--) {
            if (segments[j][0] <= currentPoint && currentPoint <= segments[j][1]) return j + 1;
        }
        return 0;
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

        static double nextDouble() {
            return Double.parseDouble(next());
        }

        static double nextLong() {
            return Long.parseLong(next());
        }
    }
}
