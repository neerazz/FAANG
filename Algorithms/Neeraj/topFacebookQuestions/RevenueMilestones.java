import java.util.Arrays;
import java.util.TreeMap;

/**
 * Created on:  Sep 08, 2020
 * Questions: https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=192049171861831
 */
public class RevenueMilestones {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getMilestoneDays(new int[]{100, 200, 300, 400, 500}, new int[]{300, 800, 1000, 1400})) +
                " = " + Arrays.toString(new int[]{2, 4, 4, 5}));
        System.out.println(Arrays.toString(getMilestoneDays(new int[]{700, 800, 600, 400, 600, 700}, new int[]{3100, 2200, 800, 2100, 1000})) +
                " = " + Arrays.toString(new int[]{5, 4, 2, 3, 2}));
    }

    static int[] getMilestoneDays(int[] revenues, int[] milestones) {
        int sum = 0;
        int[] result = new int[milestones.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < revenues.length; i++) {
            sum += revenues[i];
            map.putIfAbsent(sum, i + 1);
        }
        for (int i = 0; i < milestones.length; i++) {
            int cur = milestones[i];
            Integer celling = map.ceilingKey(cur);
            result[i] = celling == null ? -1 : map.get(celling);
        }
        return result;
    }
}
