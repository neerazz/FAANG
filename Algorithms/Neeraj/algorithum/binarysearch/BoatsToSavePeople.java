import java.util.Arrays;

/**
 * Created on:  Jan 13, 2021
 * Questions: https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/580/week-2-january-8th-january-14th/3602/
 */

public class BoatsToSavePeople {

    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{1, 2}, 3));
        System.out.println(numRescueBoats(new int[]{2, 2}, 6));
        System.out.println(numRescueBoats(new int[]{3, 2, 2, 1}, 3));
        System.out.println(numRescueBoats(new int[]{3, 5, 3, 4}, 5));
        System.out.println(numRescueBoats(new int[]{3, 5, 3, 4}, 4));
        System.out.println(numRescueBoats(new int[]{2, 5, 5, 5}, 5));
        System.out.println(numRescueBoats(new int[]{1, 8, 4, 9, 7, 1, 5, 9, 3, 4}, 10));
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int start = 0, end = people.length - 1, boats = 0;
        while (start < end) {
            int person = people[end--];
            if (person == limit) {
                boats++;
            } else if (people[start] + person <= limit) {
                boats++;
                start++;
            } else {
                boats++;
            }
            if (start == end) boats++;
        }
        return boats;
    }
}
