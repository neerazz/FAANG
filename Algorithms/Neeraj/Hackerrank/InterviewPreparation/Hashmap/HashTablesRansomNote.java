package InterviewPreparation.Hashmap;

import java.util.HashMap;

/*
https://www.hackerrank.com/challenges/ctci-ransom-note/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
 */
public class HashTablesRansomNote {
    public static void main(String[] args) {
        checkMagazine("give me one grand today night".split(" "), "give one grand today".split(" "));
        checkMagazine("two times three is not four".split(" "), "two times two is four".split(" "));
    }

    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String,Integer> map = new HashMap<>();
        for (String s : magazine) {
            map.put(s,map.getOrDefault(s,0)+1);
        }
        for (String s : note) {
            if (map.containsKey(s)){
//                If the key is present more than once then reduce the count, or else remove teh key from map.
                if (map.get(s) > 1){
                    map.put(s,map.get(s)-1);
                }else {
                    map.remove(s);
                }
            }else {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
