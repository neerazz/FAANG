import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  Aug 10, 2021
 * Ref : https://leetcode.com/problems/find-and-replace-in-string/
 */
public class FindAndReplaceInString {
    public static void main(String[] args) {
        System.out.println(findReplaceString("abcd", new int[]{0, 2}, new String[]{"a", "cd"}, new String[]{"eee", "ffff"}) + " = eeebffff");
        System.out.println(findReplaceString("abcd", new int[]{0, 2}, new String[]{"ab", "ec"}, new String[]{"eee", "ffff"}) + " = eeecd");
    }

    public static String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, Replace> replaces = new HashMap<>();
        int len = indices.length;
        for (int i = 0; i < len; i++) {
            Replace replace = new Replace(indices[i], sources[i], targets[i]);
            replaces.put(replace.idx, replace);
        }
        for (int i = 0; i < s.length(); i++) {
            if (replaces.containsKey(i)) {
                Replace rep = replaces.get(i);
                if (s.substring(i).startsWith(rep.source)) {
                    sb.append(rep.target);
                    i += rep.source.length() - 1;
                } else {
                    sb.append(s.charAt(i));
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    static class Replace {
        int idx;
        String source, target;

        Replace(int idx, String s, String t) {
            this.idx = idx;
            source = s;
            target = t;
        }
    }
}
