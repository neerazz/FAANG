package leetcode.v1.medium;

import java.util.*;

public class SortIntegersByPower {

    static Map<Integer, Integer> map = new HashMap<>();
    private static Map<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        System.out.println(getKth(1, 100000, 7777));
        long end = System.currentTimeMillis();
        System.out.println("My Sol: " + String.valueOf(end - start));

        start = System.currentTimeMillis();
        System.out.println(getCoolKth(1, 100000, 7777));
        end = System.currentTimeMillis();
        System.out.println("Cool Sol: " + String.valueOf(end - start));
    }

    public static int getKth(int lo, int hi, int k) {
        Integer[] arr = new Integer[hi - lo + 1];
        int c = 0;
        for (int i = lo; i <= hi; i++) {
            arr[c++] = i;
            map.put(i, getPower(i));
        }

        //Sort input based on Pow values
        Arrays.sort(arr, (o1, o2) -> {
            if (map.get(o1).equals(map.get(o2))) {
                return o1 - o2;
            } else {
                return map.get(o1) - map.get(o2);
            }
        });
        return arr[k - 1];
    }

    public static int getPower(int x) {
        if (map.containsKey(x)) return map.get(x);
        if (x == 1) return 0;
        int newx = (x % 2 == 0) ? (x / 2) : (3 * x + 1);
        int v = getPower(newx);
        map.put(x, ++v);
        return v;
    }

    public static int getCoolKth(int lo, int hi, int k) {
        cache.put(1, 0);
        Queue<Pair> heap = new PriorityQueue<>();
        for (int i = lo; i <= hi; i++) {
            heap.add(new Pair(i, getCoolPower(i)));
            if (heap.size() > k) {
                heap.remove();
            }
        }
        return heap.remove().number;
    }

    private static int getCoolPower(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int result;
        if (n % 2 == 0) {
            result = getPower(n / 2) + 1;
        } else {
            result = getPower(n * 3 + 1) + 1;
        }
        cache.put(n, result);
        return result;
    }

    //Eleg solution
    private static class Pair implements Comparable<Pair> {
        int number;
        int power;

        Pair(int number, int power) {
            this.number = number;
            this.power = power;
        }

        @Override
        public int compareTo(Pair o) {
            if (power != o.power) {
                return o.power - power;
            }
            return o.number - number;
        }
    }

}
