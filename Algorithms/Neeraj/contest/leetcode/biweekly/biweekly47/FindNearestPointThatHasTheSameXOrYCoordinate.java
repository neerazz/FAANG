package biweekly.biweekly47;

/**
 * Created on:  Mar 06, 2021
 * Questions:
 */

public class FindNearestPointThatHasTheSameXOrYCoordinate {

    public static void main(String[] args) {

    }
    public int nearestValidPoint(int x, int y, int[][] points) {
        int idx = -1, dist = Integer.MAX_VALUE;
        for(int i=0; i<points.length; i++){
            int[] cur = points[i];
            if(cur[0] == x || cur[1] == y){
                int curentdistance = Math.abs(cur[0]-x) + Math.abs(cur[1]-y);
                if(dist > curentdistance){
                    idx = i;
                    dist = curentdistance;
                }
            }
        }
        return idx;
    }
}
