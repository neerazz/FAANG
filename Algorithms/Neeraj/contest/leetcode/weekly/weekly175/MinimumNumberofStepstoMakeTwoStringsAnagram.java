package weekly.weekly175;

public class MinimumNumberofStepstoMakeTwoStringsAnagram {
    public static void main(String[] args) {
        System.out.println(minSteps("leetcode", "practice"));
    }

    public static int minSteps(String s, String t) {
        int count = 0;

        // store the count of character
        int[] char_count = new int[26];

        // iterate though the first String and update
        // count
        for (int i = 0; i < s.length(); i++){
            char_count[s.charAt(i) - 'a']++;
        }

        // iterate through the second string
        // update char_count.
        // if character is not found in char_count
        // then increase count
        for (int i = 0; i < t.length(); i++) {
            if (char_count[t.charAt(i) - 'a']-- <= 0){
                count++;
            }
        }
        return count;
    }
}
