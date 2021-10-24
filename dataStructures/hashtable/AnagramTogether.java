/*
Given an array of strings, return all groups of strings that are anagrams. 
The groups must be created in order of their appearance in the original array.
Example:
INPUT: N=5
       words[]={act,dog,cat,tac,god}
OUTPUT: act,cat,tac
        dog,god
*/

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class AnagramTogether {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String x = br.readLine().trim();
        String string_list[] = x.split(" ", n);

        Solution ob = new Solution();

        List<List<String>> ans = ob.Anagrams(string_list);

        Collections.sort(ans, new Comparator<List<String>>() {
            public int compare(List<String> l1, List<String> l2) {
                String s1 = l1.get(0);
                String s2 = l2.get(0);

                return s1.compareTo(s2);
            }
        });

        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    static class Solution {
        public List<List<String>> Anagrams(String[] string_list) {
            List<List<String>> res = new ArrayList<>();
            HashMap<String, List<String>> hm = new HashMap<>();
            for (String s : string_list) {
                char c[] = s.toCharArray();
                Arrays.sort(c);
                String str = new String(c);
                if (!hm.containsKey(str)) {
                    hm.put(str, new ArrayList<>());
                }
                hm.get(str).add(s);

            }
            res.addAll(hm.values());
            return res;
        }
    }
}




