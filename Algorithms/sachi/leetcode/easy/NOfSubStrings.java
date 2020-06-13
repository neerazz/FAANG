public class NOfSubStrings {

    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("aaacb"));
    }

    public static int numberOfSubstrings(String s) {
        int counter = 0;
        for (int i = s.length(); i >= 3; i--) {
            counter += getAllSubs(s, i - 1);
        }
        return counter;
    }

    public static int getAllSubs(String s, int pdiff) {
        int p1 = 0;
        int p2 = p1 + pdiff;
        int subCounter = 0;
        while (p2 < s.length()) {
            boolean aF = false, bF = false, cF = false;
            for (int i = p1; i <= p2; i++) {
                if (s.charAt(i) == 'a') aF = true;
                if (s.charAt(i) == 'b') bF = true;
                if (s.charAt(i) == 'c') cF = true;
            }
            if (aF && bF && cF) {
                subCounter++;
            }
            p1++;
            p2++;
        }
        return subCounter;
    }
}
