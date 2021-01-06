import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 05, 2021
 * Questions: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/579/week-1-january-1st-january-7th/3591/
 */

public class BeautifulArrangement {

    public static void main(String[] args) {

    }
    int count =0;
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n+1];
        helper(visited,1, n, n);
        return count;
    }
    private void helper(boolean[] visited, int cur, int end, int n){
        if(cur == end +1){
            count++;
        }else{
            for(int i=1;i<=n; i++){
                if(!visited[i] && (i%cur ==0 || cur%i== 0)){
                    visited[i] = true;
                    helper(visited, cur+1, n,n);
                    visited[i] = false;
                }
            }
        }
    }
}
