import java.util.*;
import java.util.stream.Collectors;

/*
A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 */
public class PartitionLabels {
    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(partitionLabels("caedbdedda"));
    }
    public static List<Integer> partitionLabels_optimal(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.length(); ++i)
            last[S.charAt(i) - 'a'] = i;

        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < S.length(); ++i) {
            j = Math.max(j, last[S.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }
    public static List<Integer> partitionLabels(String S) {
        List<String> output = new ArrayList<>();
        Map<Character,Integer> characterMap = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            characterMap.put(S.charAt(i),i);
        }

        int p1 = 0, p2 = 0;
        for (int i = 0; i < S.length(); ++i) {
            p1 = Math.max(p1, characterMap.get(S.charAt(i)));
            if (i == p1) {
                output.add(S.substring(p2,p1+1));
                p2 = i + 1;
            }
        }
//        System.out.println(output);
        return output.parallelStream().map(String::length).collect(Collectors.toList());
    }
}
