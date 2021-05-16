package biweekly.biweekly50;

/**
 * Created on:  Apr 17, 2021
 * Questions: https://leetcode.com/contest/biweekly-contest-50/problems/queries-on-number-of-points-inside-a-circle/
 */

public class QueriesOnNumberOfPointsInsideACircle {

    public static void main(String[] args) {

    }
    public int[] countPoints(int[][] points, int[][] queries) {
        int len = queries.length, i =0;
        int[] result = new int[len];
        for(int[] query: queries){
            int count =0;
            for(int[] point: points){
                double dist = dist(point, query[0], query[1]);
                if(dist <= query[2]) count++;
            }
            result[i++] = count;
        }
        return result;
    }
    double dist(int[] a, int p1,int p2){
        double x = a[0] - p1, y = a[1] - p2;
        x *=x;
        y *=y;
        return Math.sqrt(x+y);
    }
}
