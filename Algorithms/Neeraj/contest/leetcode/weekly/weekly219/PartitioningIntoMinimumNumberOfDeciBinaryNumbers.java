package weekly.weekly219;

/**
 * Created on:  Dec 12, 2020
 * Questions:
 */

public class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {

    public static void main(String[] args) {

    }

    public static int minPartitions(String n) {
        int max = 0;
        for (char cur : n.toCharArray()) {
            max = Math.max(max, cur - '0');
        }
        return max;
    }
}
