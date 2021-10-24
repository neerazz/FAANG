/**
 * Created on:  Jan 19, 2021
 * Questions: https://aonecode.com/amazon-online-assessment-questions#dl
 */

public class RollDice {

    public static void main(String[] args) {
        System.out.println(getCount(new int[]{6, 5, 4}) + " = 2");
        System.out.println(getCount(new int[]{6, 6, 1}) + " = 2");
        System.out.println(getCount(new int[]{6, 1, 5, 4}) + " = 3");
    }

    private static int getCount(int[] dics) {
        int[] counts = new int[7];
        for (int dic : dics) counts[dic]++;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= 6; i++) {
            min = Math.min(min, getAllDist(counts, i));
        }
        return min;
    }

    private static int getAllDist(int[] counts, int cur) {
        int rotate = 0;
        for (int i = 1; i <= 6; i++) {
            if (i == cur) continue;
            int dist = getDist(i, cur);
            rotate += counts[i] * dist;
        }
        return rotate;
    }

    private static int getDist(int from, int to) {
        switch (from) {
            case 1:
                return to == 6 ? 2 : 1;
            case 2:
                return to == 5 ? 2 : 1;
            case 3:
                return to == 4 ? 2 : 1;
            case 4:
                return to == 3 ? 2 : 1;
            case 5:
                return to == 2 ? 2 : 1;
            case 6:
                return to == 1 ? 2 : 1;
        }
        return 3;
    }
}
