package biweekly.biweekly43;

/**
 * Created on:  Jan 09, 2021
 * Questions:
 */

public class MaximumScoreFromRemovingSubstrings {

    public static void main(String[] args) {
//        System.out.println(maximumGain("cdbcbbaaabab", 4, 5));
        System.out.println(maximumGain("aabbaaxybbaabb", 5, 4));
    }

    public static int maximumGain(String s, int x, int y) {
        if (s == null || s.length() < 2) return 0;
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            boolean ab = s.charAt(i) == 'a' && s.charAt(i + 1) == 'b', ba = s.charAt(i) == 'b' && s.charAt(i + 1) == 'a';
            if(x == y){
                if(ab){
                    count += x;
                    i++;
                }else if(ba){
                    count += y;
                    i++;
                }else{
                    sb.append(s.charAt(i));
                }
            }else if(x > y){
                if(ab){
                    count += x;
                    i++;
                }else if(ba){
                    if(!sb.isEmpty() && sb.charAt(sb.length()-1) == 'a'){
                        sb.append(s.charAt(i));
                    }else{
                        count += y;
                        i++;
                    }
                }else{
                    sb.append(s.charAt(i));
                }
            }else {
                if(ba){
                    count += x;
                    i++;
                }else if(ab){
                    if(!sb.isEmpty() && sb.charAt(sb.length()-1) == 'b'){
                        sb.append(s.charAt(i));
                    }else{
                        count += y;
                        i++;
                    }
                }else{
                    sb.append(s.charAt(i));
                }
            }
        }
        return count == 0 ? count : count + maximumGain(sb.toString(), x, y);
    }
}
