package weekly.weekly182;

import java.util.*;

public class FindAllGoodStrings {
    public static void main(String[] args) {
        System.out.println(findGoodStrings(2, "aa", "da", "b"));
        Solution_Copied solution_copied = new Solution_Copied();
        System.out.println(solution_copied.findGoodStrings(2, "aa", "da", "b"));
        System.out.println(solution_copied.findGoodStrings(8, "leetcode", "leetgoes", "leet"));
    }

    public static int findGoodStrings(int n, String s1, String s2, String evil) {
        if(s1.contains(evil) && s2.contains(evil)) return 0;
        if(s1.equals(s2)) return 1;
        int result =0;
        for (int i = 0; i < n; i++) {
            int a = s1.charAt(i), b = s2.charAt(i);
            char changed = (char) (a+1);
            while(++a <= b){
                result++;
            }
        }
        return result;
    }

    static class Solution_Copied {
        int MOD = 1_000_000_000 + 7;
        String[][] cache;
        Map<String, Integer> memo = new HashMap<>();

        public int findGoodStrings(int n, String s1, String s2, String evil) {
            cache = new String[2][n];
            return f(n, s1, s2, evil, Collections.emptyList());
        }

        private int f(int n, String s1, String s2, String evil, List<Integer> evilCandidates) {
            // if prefixed with evil word
            if (!evilCandidates.isEmpty() && evilCandidates.get(0) == evil.length()) {
                return 0;
            }
            // single character
            if (n == 0) {
                return 1;
            }

            // cache by start+end+potential evil beginning
            String key = s1 + "_" + s2 + "_" + evilCandidates;
            if (memo.containsKey(key)) {
                return memo.get(key);
            }

            String as = g(n-1, 'a');
            String zs = g(n-1, 'z');

            long total = 0;
            for (char s = s1.charAt(0); s <= s2.charAt(0); s++) {
                // if we have abc to xyz, we split it into abc-azz, baa-bzz, caa-czz, ..., waa-wzz, xaa-xyz
                String left = s == s1.charAt(0) ? s1.substring(1) : as;
                String right = s == s2.charAt(0) ? s2.substring(1) : zs;

                // if current symbol is potentially the next symbol of any candidate - add it to the new candidates list
                List<Integer> nextEvil = new ArrayList<>();
                for (int c : evilCandidates) {
                    if (s == evil.charAt(c)) {
                        nextEvil.add(c + 1);
                    }
                }
                // if current symbol is a beggining of evil - as 1 to candidates list
                if (s == evil.charAt(0)) {
                    nextEvil.add(1);
                }
                total += f(n - 1, left, right, evil, nextEvil);
            }

            int res = (int) (total % MOD);
            memo.put(key, res);
            return res;
        }

        private String g(int spaces, char c) {
            int k = c == 'a' ? 1 : 0;
            if (cache[k][spaces] == null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < spaces; i++) {
                    sb.append(c);
                }
                cache[k][spaces] = sb.toString();
            }
            return cache[k][spaces];
        }
    }
}
