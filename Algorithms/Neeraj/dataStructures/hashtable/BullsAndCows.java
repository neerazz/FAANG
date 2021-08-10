/**
 * Created on:  Aug 10, 2021
 * Ref : https://leetcode.com/problems/bulls-and-cows/
 */
public class BullsAndCows {
    public static void main(String[] args) {

    }

    /*
    "1123"
        i
    "0111"

    0 1 2 3 4 5 6 7 8 9 0
      0 1 1               = counts
      b =1
      c =1
*/
    public static String getHint(String s, String g) {
        int bulls = 0, cows =0, len = s.length();
        int[] counts = new int[10];
        for(char c: s.toCharArray()){
            counts[c-'0']++;
        }
        for(int i=0; i<len; i++){
            int a = s.charAt(i)-'0', b = g.charAt(i)-'0';
            if(a == b){
                if(counts[a] == 0){
                    cows--;
                }else{
                    counts[a]--;
                }
                bulls++;
            }else if(counts[b] > 0){
                counts[b]--;
                cows++;
            }
        }
        return String.format("%dA%dB", bulls, cows);
    }
}
