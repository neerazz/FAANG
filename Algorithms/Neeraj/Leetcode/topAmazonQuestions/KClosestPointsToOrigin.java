package topAmazonQuestions;

import java.util.*;
import java.util.stream.Collectors;

/*
We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
(Here, the distance between two points on a plane is the Euclidean distance.)
You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

Example 1:
Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:
Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)
 */
public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(kClosest(new int[][]{{0,1}, {1,0}}, 1)));
        System.out.println(Arrays.deepToString(kClosest(new int[][]{{1, 3}, {-2, 2}}, 1)));
        System.out.println(Arrays.deepToString(kClosest(new int[][]{{3, 3}, {5,-1},{-2,4}}, 2)));
    }
    public static int[][] kClosest(int[][] points, int K) {
        HashMap<Double, List<Integer>> map = new HashMap<>();
        Set<Double> doubleList = new HashSet<>();
        int[][] result = new int[K][2];
//        Calculate the distance of all the points and store in hash map.
        for (int i = 0; i < points.length; i++) {
            Double distance = getDistance(points[i]);
            doubleList.add(distance);
            if (map.containsKey(distance)){
                List<Integer> integers = map.get(distance);
//                TODO Correct this.
                integers.add(i);
            }else {
                map.put(distance, Collections.singletonList(i));
            }
        }
//        Sorting the set of distances.
        List<Double> sortedList = doubleList.stream().sorted().collect(Collectors.toList());
//        Get the corresponding coordinated from distances.
        for (int i = 0; i < K; i++) {
            Double poll = sortedList.get(i);
            List<Integer> integers = map.get(poll);
            for (int j = 0; j < integers.size(); j++) {
                result[i++] = points[integers.get(j)];
            }
            i--;
        }
        return result;
    }

    private static Double getDistance(int[] point) {
        double sum = 0.0;
        for (int value : point) {
            sum += value * value;
        }
        return Math.sqrt(sum);
    }
}
