package weekly.weekly211;

/**
 * Created on:  Oct 17, 2020
 * Questions:
 */

public class LargestSubstringBetweenTwoEqualCharacters {

    public static void main(String[] args) {
        System.out.println(maxLengthBetweenEqualCharacters("mgntdygtxrvxjnwksqhxuxtrv"));
    }
    public static int maxLengthBetweenEqualCharacters(String s) {
        int len = s.length(), max = -1;
        Integer[] idx = new Integer[26];
        for(int i=0; i<len;i++){
            char cur = s.charAt(i);
            if(idx[cur-'a'] != null){
                max = Math.max(max, i-idx[cur-'a']-1);
            }else{
                idx[cur-'a'] = i;
            }
        }
        return max;
    }
}
