package biweekly.biweekly49;

/**
 * Created on:  Apr 03, 2021
 * Questions:
 */

public class MaximumNumberOfGroupsGettingFreshDonuts {

    public static void main(String[] args) {
        System.out.println(maxHappyGroups(3, new int[]{1, 2, 3, 4, 5, 6}) + " = 4");
        System.out.println(maxHappyGroups(4, new int[]{1, 3, 2, 5, 2, 2, 1, 6}) + " = 4");
        System.out.println(maxHappyGroups(3, new int[]{369821235, 311690424, 74641571, 179819879, 171396603, 274036220}) + " = 4");
        System.out.println(maxHappyGroups(6, new int[]{369205928, 981877451, 947462486, 899465743, 737778942, 573732515, 520226542, 824581298, 571789442, 251943251, 70139785, 778962318, 43379662, 90924712, 142825931, 182207697, 178834435, 978165687}) + " = 10");
    }

    public static int maxHappyGroups(int batchSize, int[] groups) {
        int[] counts = new int[batchSize];
        for (int num : groups) {
            counts[num % batchSize]++;
        }
        int happy = 0, processed = 0, total = groups.length, rem = 0;
        while (processed < total) {
            if (rem == 0) {
                happy++;
                for (int i = 0; i < counts.length; i++) {
                    if (counts[i] > 0) {
                        counts[i]--;
                        rem = i;
                        break;
                    }
                }
            } else {
//            Get the next best that will lead to a lower rem.
                int next = getNextBest(counts, rem);
                counts[next]--;
                rem = (rem + next) % batchSize;
            }
            processed++;
        }
        return happy;
    }

    private static int getNextBest(int[] counts, int rem) {
        int best = counts.length - rem, left = best, right = best;
        if (counts[best] > 0) return best;
        while (left >= 0 && counts[left] == 0) left--;
        while (right < counts.length && counts[right] == 0) right++;
        if (left < 0) {
//            Only option is to take right
            return right;
        } else if (right >= counts.length) return left;
        else {
//            Take the closest
            return right - best < best - left ? right : left;
        }
    }
}
