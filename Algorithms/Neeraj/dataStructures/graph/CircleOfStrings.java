/*
Given an array of lowercase strings A[] of size N, determine if the strings can be chained together to form a circle.
A string X can be chained together with another string Y if the last character of X is same as first
character of Y. If every string of the array can be chained, it will form a circle.
Example:
INPUT: N=3
       Arr={"ab","cde","bd"}
OUTPUT: 0
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class CircleOfStrings {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String A[] = in.readLine().trim().split(" ");
        int N = Integer.parseInt(A[0]);
        A = in.readLine().trim().split(" ");

        Solution ob = new Solution();
        System.out.println(ob.isCircle(N, A));
    }

    static class Solution {
        int isCircle(int N, String arr[]) {

            boolean[] hasAlpha = new boolean[26];
            HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

            int[] in = new int[26];
            int[] out = new int[26];

            for (String str : arr) {

                int src = str.charAt(0) - 'a';
                int dest = str.charAt(str.length() - 1) - 'a';

                hasAlpha[src] = hasAlpha[dest] = true;

                in[dest]++;
                out[src]++;

                if (!graph.containsKey(src)) graph.put(src, new ArrayList<>());
                graph.get(src).add(dest);

            }

            for (int i = 0; i < 26; i++) {
                if (in[i] != out[i]) return 0;
            }

            boolean[] visited = new boolean[26];
            dfs(arr[0].charAt(0) - 'a', graph, hasAlpha, visited);

            for (int i = 0; i < 26; i++) {
                if (hasAlpha[i] && !visited[i]) return 0;
            }
            return 1;
        }

        private static void dfs(int node, HashMap<Integer, ArrayList<Integer>> graph, boolean[] hasAlpha, boolean[] visited) {

            visited[node] = true;

            for (Integer nbr : graph.get(node)) {
                if (hasAlpha[nbr] && !visited[nbr]) dfs(nbr, graph, hasAlpha, visited);
            }

        }
    }
}
