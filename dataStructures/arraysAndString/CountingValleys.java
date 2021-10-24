/*
Problem: https://www.hackerrank.com/challenges/counting-valleys/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup&h_r=next-challenge&h_v=zen
Sample Input
8
UDDDUDUU
Sample Output
1
 */
public class CountingValleys {

    public static void main(String[] args) {
        System.out.println(countingValleys(8, "UDDDUDUU"));
        System.out.println(countingValleys(12, "DDUUDDUDUUUD"));
    }

    static int countingValleys(int n, String s) {
        int level = 0;
        int previous;
        int valleys = 0;
        for (int i = 0; i < n; i++) {
            previous = level;
            if (s.charAt(i) == 'U') level++;
            else level--;
            if (level == 0 && previous < 0) valleys++;
        }
        return valleys;
    }
}
