import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/*

Get Details in : https://medium.com/competitive/covering-segments-by-points-fc2c56c4b038
You are responsible for collecting signatures from all tenants of a certain build- ing. For each tenant, you know a period of time when he or she is at home. You would like to collect all signatures by visiting the building as few times as possible. The mathematical model for this problem is the following. You are given a set of segments on a line and your goal is to mark as few points on a line as possible so that each segment contains at least one marked point.

Problem Description
Given a set of n segments {[a0, b0], [a1, b1], . . . , [an-1, bn-1]} with integer coordinates on a line, find the minimum number m of points such that each segment contains at least one point. That is, find a set of integers X of the minimum size such that for any segment [ai,bi] there is a point x ∈ X such that ai ≤ x ≤ bi.
Input Format: The first line of the input contains the number n of segments. Each of the following n lines contains two integers ai and bi (separated by a space) defining the coordinates of endpoints of the i-th segment.
Output Format: Output the minimum number m of points on the first line and the integer coordinates of m points (separated by spaces) on the second line. You can output the points in any order. If there are many such sets of points, you can output any set. (It is not difficult to see that there always exist a set of points of the minimum size such that all the coordinates of the points are integers.)
Sample 1: (3 1 3 2 5 3 6)
Input: 3
1 3
2 5
3 6
Output: 1
3
Explanation:
In this sample, we have three segments: [1,3],[2,5],[3,6] (of length 2,3,3 respectively). All of them contain the point with coordinate 3: 1 ≤3 ≤3, 2 ≤3 ≤5, 3 ≤ 3 ≤ 6.

Sample 2: (4 4 7 1 3 2 5 5 6)
Input: 4
4 7
1 3
2 5
5 6
Output: 2
3 6
Explanation:
The second and the third segments contain the point with coordinate 3 while the first and the fourth segments contain the point with coordinate 6. All the four segments cannot be covered by a single point, since the segments [1, 3] and [5, 6] are disjoint.
Solution:
The greedy choice is selecting the minimum right endpoint. Then remove all segments that contains that endpoint. Keep choosing minimum right endpoint and removing segments.

Sample 3:
Input:
100
41 42
52 52
63 63
80 82
78 79
35 35
22 23
31 32
44 45
81 82
36 38
10 12
1 1
23 23
32 33
87 88
55 56
69 71
89 91
93 93
38 40
33 34
14 16
57 59
70 72
36 36
29 29
73 74
66 68
36 38
1 3
49 50
68 70
26 28
30 30
1 2
64 65
57 58
58 58
51 53
41 41
17 18
45 46
4 4
0 1
65 67
92 93
84 85
75 77
39 41
15 15
29 31
83 84
12 14
91 93
83 84
81 81
3 4
66 67
8 8
17 19
86 87
44 44
34 34
74 74
94 95
79 81
29 29
60 61
58 59
62 62
54 56
58 58
79 79
89 91
40 42
2 4
12 14
5 5
28 28
35 36
7 8
82 84
49 51
2 4
57 59
25 27
52 53
48 49
9 9
10 10
78 78
26 26
83 84
22 24
86 87
52 54
49 51
63 64
54 54

Output:
43
1 4 5 8 9 10 14 15 18 23 26 28 29 30 32 34 35 36 40 41 44 46 49 52 54 56 58 61 62 63 65 67 70 74 77 78 79 81 84 87 91 93 95
 */
public class Week3CollectingSignatures {

    public static void main(String[] args) {

        int numberOfPoints = FastScan.nextInt();
        List<Integer> startingPoint = new ArrayList<>();
        List<Integer> endingPoint = new ArrayList<>();
        for (int i = 0; i < numberOfPoints; i++) {
            startingPoint.add(FastScan.nextInt());
            endingPoint.add(FastScan.nextInt());
        }
        List<Integer> optimalNumberOfPoints = getOptimalNumberOfPoints(numberOfPoints, startingPoint, endingPoint);
        System.out.println(optimalNumberOfPoints.size());
        optimalNumberOfPoints.forEach(i -> System.out.print(i + " "));
    }

    private static List<Integer> getOptimalNumberOfPoints(int numberOfPoints, List<Integer> startingPoints, List<Integer> endingPoints) {
        List<Integer> optimalPoints = new ArrayList<>();
        List<Integer> sortedEndPoints = endingPoints.stream().sorted().collect(Collectors.toList());

        int currentOptimalPoint = sortedEndPoints.get(0);

        for (int i = 0; i < numberOfPoints; i++) {

            int endingPoint = sortedEndPoints.get(i);
            int index = endingPoints.indexOf(endingPoint);
            int startingPoint = startingPoints.get(index);

            if (startingPoint > currentOptimalPoint || currentOptimalPoint > endingPoint) {
                currentOptimalPoint = endingPoint;
            }
            if (!optimalPoints.contains(currentOptimalPoint)) optimalPoints.add(currentOptimalPoint);
//            Remove the already processed entries from the list.
            startingPoints.remove(index);
            endingPoints.remove(index);
        }
        return optimalPoints;
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

        static long nextLong() {
            return Long.parseLong(next());
        }
    }
}
