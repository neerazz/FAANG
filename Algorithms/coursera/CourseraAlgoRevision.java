import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CourseraAlgoRevision {
    public static void main(String[] args) {
//        System.out.println(minimumRefills(new int[]{200, 375, 550, 750}, 400, 950));
//        System.out.println(minimumRefills(new int[]{1,2,5,9}, 3, 10));
//        System.out.println("\n" +moneyChange(28));
//        System.out.println("\n" +moneyChange(2));
//        System.out.println(maximumMoneyInLoot(3,50,new int[][]{{60,20},{100,50},{120,30}}));
//        System.out.println(maximumMoneyInLoot(1,10,new int[][]{{500,30}}));
//        System.out.println(maximumAdRevenue(1,new int[]{23},new int[]{39}));
//        System.out.println(maximumAdRevenue(3,new int[]{1,3,-5},new int[]{-2,4,1}));
        System.out.println(collectingSignatures(3, new int[][]{{1, 3}, {2, 5}, {3, 6}}));
        System.out.println(collectingSignatures(4, new int[][]{{4, 7}, {1, 3}, {2, 5}, {5, 6}}));
    }

    private static List<Integer> collectingSignatures(int totalSegments, int[][] segments) {
        List<Segment> segmentList = new ArrayList<>();
        for (int[] seg : segments) {
            segmentList.add(new Segment(seg[0], seg[1]));
        }
        segmentList.sort((s1, s2) -> s1.start == s2.start ? s1.end - s2.end : s1.start - s2.start);
        List<Integer> output = new ArrayList<>();
        Stack<Segment> stack = new Stack<>();
        Integer start = null, end = null;
        for (Segment seg : segmentList) {
            if (start == null && end == null) {
                start = seg.start;
                end = seg.end;
                stack.push(seg);
                continue;
            }
            if (seg.start <= end) {
                start = seg.start;
                stack.push(seg);
            } else {
                output.add(start);
                start = seg.start;
                end = seg.end;
                stack.clear();
            }
        }
        if (!stack.isEmpty()) {
            output.add(start);
        }
        return output;
    }

    private static long maximumAdRevenue(int totalAds, int[] profitPerClick, int[] clicksPerDay) {
        Arrays.sort(profitPerClick);
        Arrays.sort(clicksPerDay);
        long revenue = 0;
        for (int i = 0; i < totalAds; i++) {
            revenue += profitPerClick[i] * clicksPerDay[i];
        }
        return revenue;
    }

    private static Double maximumMoneyInLoot(int totalItems, int bagCapacity, int[][] items) {
        List<Items> itemsList = new ArrayList<>();
        for (int[] item : items) {
            itemsList.add(new Items(item[0], item[1]));
        }
        itemsList.sort((i1, i2) -> i2.valuePerWeight.compareTo(i1.valuePerWeight));
        int weight = 0;
        Double value = 0.0;
        for (Items currentItem : itemsList) {
            int remainingWeight = bagCapacity - weight;
            Double weightFraction = (double) remainingWeight / currentItem.weight;
            weight += weightFraction * currentItem.weight;
            value += weightFraction * currentItem.value;
            if (weight == bagCapacity) {
                break;
            }
        }
        return value;
    }

    private static int moneyChange(int money) {
        int[] denominations = {10, 5, 1};
        int numberOfCoins = 0;
        int amountTillNow = 0;
        int index = 0;
        while (amountTillNow <= money && index < denominations.length) {
            while (amountTillNow + denominations[index] <= money) {
                amountTillNow += denominations[index];
                numberOfCoins++;
                System.out.print(denominations[index] + " \t");
            }
            index++;
        }
        return numberOfCoins;
    }

    private static int minimumRefills(int[] pumpsDistanceArray, int capacityOfFuelTank, int totalDistance) {
        int totalRefills = 0;
        int distance = 0;
        while (distance + capacityOfFuelTank <= totalDistance) {
//        Get next refill.
            int prev = 0;
            for (int i = 0; i < pumpsDistanceArray.length; i++) {
                int cur = pumpsDistanceArray[i];
                if (distance + capacityOfFuelTank >= cur) {
                    prev = cur;
                } else {
                    if (cur - prev > capacityOfFuelTank) {
                        return -1;
                    } else {
                        totalRefills++;
                        distance = prev;
                        prev = cur;
                    }
                }
            }
            if (distance + capacityOfFuelTank < totalDistance) {
                totalRefills++;
                distance = prev;
            }
        }
        return totalRefills;
    }

    static class Segment {
        int start;
        int end;

        public Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class Items {
        int value;
        int weight;
        Double valuePerWeight;

        public Items(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.valuePerWeight = (double) value / weight;
        }
    }
}
