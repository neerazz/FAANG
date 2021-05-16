package biweekly.biweekly51;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Created on:  May 01, 2021
 * Questions: https://leetcode.com/contest/biweekly-contest-51/problems/seat-reservation-manager/
 */

public class SeatReservationManager {

    public static void main(String[] args) {

    }

    static class SeatManager {
        TreeSet<Integer> set = new TreeSet<>();

        public SeatManager(int n) {
            IntStream.rangeClosed(1, n).forEach(num -> set.add(num));
        }

        public int reserve() {
            return set.pollFirst();
        }

        public void unreserve(int seatNumber) {
            set.add(seatNumber);
        }
    }
}
