/**
 * Created on:  Sep 03, 2020
 * Questions: https://leetcode.com/problems/koko-eating-bananas/
 */
public class KokoEatingBananas {
    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{3, 6, 7, 11}, 8) + " = 4");
        System.out.println(minEatingSpeed(new int[]{312884470}, 968709470) + " = 1");
        System.out.println(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5) + " = 30");
        System.out.println(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6) + " = 23");
        System.out.println(minEatingSpeed(new int[]{332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184}, 823855818) + " = 14");
    }

    public static int minEatingSpeed(int[] piles, int H) {
        int start = 1, end = 1_000_000_000;
        long total = 0;
        for (int val : piles) total += val;
        while (start < end) {
            int mid = start + (end - start) / 2;
            boolean canEatAll = canEatAll(piles, mid, H, total);
//            System.out.println("start = " + start + " mid = " + mid + " end = " + end + " canEatAll=" + canEatAll);
            if (canEatAll) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static boolean canEatAll(int[] piles, int k, int h, long total) {
        int time = 0;
        for (int val : piles) {
            time += val / k + (val % k == 0 ? 0 : 1);
        }
        return time <= h;
    }
}
