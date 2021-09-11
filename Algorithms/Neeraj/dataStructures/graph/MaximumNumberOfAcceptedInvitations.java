import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created on:  Apr 07, 2021
 * Questions: https://leetcode.com/problems/maximum-number-of-accepted-invitations/
 */

public class MaximumNumberOfAcceptedInvitations {

    static int result;

    public static void main(String[] args) {
//        System.out.println(maximumInvitations(new int[][]{{1,1,1},{1,0,1},{0,0,1}}) + " = 3");
        System.out.println(maximumInvitations(new int[][]{{1, 0, 1, 0}, {1, 0, 0, 0}, {0, 0, 1, 0}, {1, 1, 1, 0}}) + " = 3");
    }

    //    https://brilliant.org/wiki/hungarian-matching/
    public static int maximumInvitations(int[][] grid) {
        result = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int boys = grid.length, girls = boys > 0 ? grid[0].length : 0;
        boolean[] invited = new boolean[girls];
        int maxInvites = 0, max_boy = -1;
        for (int boy = 0; boy < boys; boy++) {
            map.put(boy, new HashSet<>());
            int count = 0;
            for (int girl = 0; girl < girls; girl++) {
                if (grid[boy][girl] == 1) {
                    map.get(boy).add(girl);
                    count++;
                }
            }
            if (count > maxInvites) {
                maxInvites = count;
                max_boy = boy;
            }
        }
        if (max_boy == -1) return 0;
        dfs(map, max_boy, boys, invited, 0);
        return result;
    }

    static void dfs(Map<Integer, Set<Integer>> map, int boy, int boys, boolean[] visited, int total) {
        if (boy == boys) {
            result = Math.max(total, result);
        } else {
            boolean foundAPair = false;
            for (int girl : map.get(boy)) {
                if (!visited[girl]) {
                    visited[girl] = foundAPair = true;
                    dfs(map, boy + 1, boys, visited, total + 1);
                    visited[girl] = false;
                }
            }
            if (!foundAPair) {
//            Then make a dfs call to next boy, without increasing.
                dfs(map, boy + 1, boys, visited, total);
            }
        }
    }
}
