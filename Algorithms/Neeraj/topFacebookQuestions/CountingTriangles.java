import java.util.*;

/**
 * Created on:  Sep 09, 2020
 * Questions: https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=720422605157879
 */
public class CountingTriangles {
    public static void main(String[] args) {

    }

    int countDistinctTriangles(ArrayList<Sides> arr) {
        Set<List<Integer>> sides = new HashSet<>();
        for (Sides cur : arr) {
            List<Integer> curSides = new ArrayList<>(Arrays.asList(cur.a, cur.b, cur.c));
            Collections.sort(curSides);
            sides.add(curSides);
        }
        return sides.size();
    }

    static class Sides {
        int a;
        int b;
        int c;

        Sides(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
