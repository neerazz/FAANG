package weekly.weekly237;

/**
 * Created on:  Apr 17, 2021
 * Questions:
 */

public class CheckIfTheSentenceIsPangram {

    public static void main(String[] args) {

    }
    public boolean checkIfPangram(String s) {
        int[] counts = new int[26];
        for(char cur: s.toCharArray()){
            counts[cur-'a']++;
        }
        for(int count: counts){
            if(count ==0 ) return false;
        }
        return true;
    }
}
