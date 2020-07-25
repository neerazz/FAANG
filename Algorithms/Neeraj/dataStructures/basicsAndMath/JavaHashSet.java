import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

/*
https://www.hackerrank.com/challenges/java-hashset/problem
Sample Input
5
john tom
john mary
john tom
mary anna
mary anna
Sample Output
1
2
2
3
3
 */
public class JavaHashSet {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String[] pair_left = new String[t];
        String[] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }
        HashSet<String> pairHashSet = new HashSet<>();
        for (int i = 0; i < t; i++) {
            pairHashSet.add("LEFT" + pair_left[i] + "RIGHT" + pair_right[i]);
            System.out.println(pairHashSet.size());
        }
    }

    static class Pair {
        String left;
        String right;

        public Pair(String left, String right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (!Objects.equals(left, pair.left)) return false;
            return Objects.equals(right, pair.right);
        }

        @Override
        public int hashCode() {
            int result = left != null ? left.hashCode() : 0;
            result = 31 * result + (right != null ? right.hashCode() : 0);
            return result;
        }
    }
}
