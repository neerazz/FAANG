package weekly.weekly221;

/**
 * Created on:  Dec 26, 2020
 * Questions:
 */

public class DetermineIfStringHalvesAreAlike {

    public static void main(String[] args) {
        System.out.println(halvesAreAlike("book"));
    }
    public static boolean halvesAreAlike(String s) {
        int len = s.length(), mid = len/2, left =0, right = 0;
        for(int i=0; i<len; i++){
            char c = s.charAt(i);
            if(c == 'a' || c =='e'|| c=='i'||c=='o'||c=='u' || c == 'A' || c =='E'|| c=='I'||c=='O'||c=='U'){
                if(i < mid) left++;
                else right++;
            }
        }
        return left == right;
    }
}
