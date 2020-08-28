
/*
https://www.hackerrank.com/challenges/mars-exploration/problem
 */
public class MarsExploration {
    public static void main(String[] args) {
        System.out.println(marsExploration("SOSSOT") + " should be [1]");
        System.out.println(marsExploration("SOSSOS") + " should be [0]");
    }
    static int marsExploration(String s) {
        if (s == null || s.isEmpty()){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i++) != 'S'){
                count++;
            }
            if (s.charAt(i++) != 'O'){
                count++;
            }
            if (s.charAt(i) != 'S'){
                count++;
            }
        }
        return count;
    }
}
