import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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

Solution:
We will turn [ai, aj] and points [pk] into 3 arrays: [ai, LEFT], [aj, RIGHT], [pk, POINT] with LEFT = 1, POINT = 2, RIGHT = 3.
We try to sort [ai, LEFT] + [aj, RIGHT] + [pk, POINT]. To compare 2 elements [x, LEFT/RIGHT/POINT] and [y, LEFT/RIGHT/POINT],
we compare x and y, if x == y, we compare LEFT/RIGHT/POINT basing on the value of LEFT = L, POINT = P, RIGHT = R.

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

//        int[] theNeareastNumberOfSegment = navieGetTheNeareastNumberOfSegment(segments, numberOfSegments, points, numberOfPoints);

        Arrays.stream(optimalGetTheNeareastNumberOfSegment(segments, numberOfSegments, points, numberOfPoints))
                .forEach(i -> System.out.print(i + " "));
    }

    private static int[] optimalGetTheNeareastNumberOfSegment(int[][] segments, int numberOfSegments, int[] points, int numberOfPoints) {
        int[] result = new int[numberOfPoints];
        Map<Integer, String> combinedMap = new TreeMap<>();

//        Sort and assign all the values
        for (int i = 0; i < numberOfSegments; i++) {
            combinedMap.put(segments[i][0], "L");
            combinedMap.put(segments[i][1], "R");
        }

        for (int i = 0; i < numberOfPoints; i++) {
            combinedMap.put(points[i], "P");
        }

        int left = 0;
        Map<Integer, Integer> pointValueMap = new HashMap<>();
        for (Map.Entry e : combinedMap.entrySet()) {
            if (e.getValue() == "L") left++;
            else if (e.getValue() == "R") left--;
            else {
                pointValueMap.put((Integer) e.getKey(), left);
            }
        }

        for (int i = 0; i < numberOfPoints; i++) {
            result[i] = pointValueMap.get(points[i]);
        }

        return result;
    }

    private static int[] navieGetTheNeareastNumberOfSegment(int[][] segments, int numberOfSegments, int[] points, int numberOfPoints) {
        int[] result = new int[numberOfPoints];

        for (int i = 0; i < numberOfPoints; i++) {
            int currentPoint = points[i];
            result[i] = findCurrentPointSegment(segments, numberOfSegments, currentPoint);
        }
        return result;
    }

    private static int findCurrentPointSegment(int[][] segments, int numberOfSegments, int currentPoint) {
        int found = 0;
        for (int j = numberOfSegments - 1; j >= 0; j--) {
            if (segments[j][0] <= currentPoint && currentPoint <= segments[j][1]) found++;
        }
        return found;
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
