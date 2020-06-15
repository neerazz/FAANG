public class MaximumScoreAfterSplittingAString {

    public static int maxScore(String s) {
        int left = 0, right = 0, max = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') right++;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            if (c == '0') {
                left++;
            } else {
                right--;
            }
            max = Math.max(max, left + right);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxScore("00"));
    }
}
