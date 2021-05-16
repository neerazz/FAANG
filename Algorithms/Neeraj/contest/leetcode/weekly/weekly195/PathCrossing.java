package weekly.weekly195;

import java.util.HashSet;
import java.util.Set;

/**
 * Created on:  Jun 27, 2020
 * Questions: https://leetcode.com/problems/path-crossing
 */
public class PathCrossing {
    public static void main(String[] args) {
        System.out.println(isPathCrossing("NESWW"));
    }
    public static boolean isPathCrossing(String path) {
        Set<String> visited = new HashSet<>();
        int[] cur = {0,0};
        visited.add(cur[0] + "-" + cur[1]);
        for(char c: path.toCharArray()){
            if(c == 'N'){
                cur[0]--;
                cur[1]--;
            }else if(c == 'E'){
                cur[1]++;
            }else if(c == 'W'){
                cur[1]--;
            }else{
                cur[0]++;
                cur[1]++;
            }
            if(!visited.add(cur[0] + "-" + cur[1])){
                return true;
            }
        }
        return false;
    }
}
