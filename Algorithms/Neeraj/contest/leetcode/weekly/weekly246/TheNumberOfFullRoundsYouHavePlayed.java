package weekly.weekly246;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on:  Jun 19, 2021
 * Ref: https://leetcode.com/contest/weekly-contest-246/problems/the-number-of-full-rounds-you-have-played/
 */

public class TheNumberOfFullRoundsYouHavePlayed {

    public static void main(String[] args) {
//        System.out.println(numberOfRounds("12:01", "12:44") + " = 1");
        System.out.println(numberOfRounds("20:00", "06:00") + " = 40");
        System.out.println(numberOfRounds("00:00", "23:59") + " = 95");

//        System.out.println(numberOfRounds_2("12:01", "12:44") + " = 1");
//        System.out.println(numberOfRounds_2("20:00", "06:00") + " = 40");
//        System.out.println(numberOfRounds_2("00:00", "23:59") + " = 95");
    }

    public static int numberOfRounds_2(String startTime, String finishTime) {
        Game game = new Game(startTime, finishTime);
        List<Game> games = new ArrayList<>();
        if (game.isOverNight()) {
            games.add(new Game(game.start, new int[]{24, 0}));
            games.add(new Game(new int[]{0, 0}, game.end));
        } else {
            games.add(game);
        }
        int round = 0;
        for (int h = 0; h < 24; h++) {
            for (int m = 0; m < 60; m = m + 15) {
                int[] start = new int[]{h, m}, end = getNext(h, m + 15);
                if (canPlay(start, end, games)) round++;
            }
        }
        return round;
    }

    private static boolean canPlay(int[] start, int[] end, List<Game> games) {
        return games.stream().anyMatch(game -> game.inRange(start, end));
    }

    static class Game {
        int[] start, end;

        Game(String startTime, String finishTime) {
            start = getTime(startTime);
            end = getTime(finishTime);
        }

        Game(int[] start, int[] end) {
            this.start = start;
            this.end = end;
        }

        boolean isOverNight() {
            return start[0] > end[0] || (start[0] == end[0] && start[1] > end[1]);
        }

        public boolean inRange(int[] curStart, int[] curEnd) {
            return inRange(curStart) && inRange(curEnd);
        }

        private boolean inRange(int[] time) {
            return start[0] <= time[0] && time[0] <= end[0] && start[1] <= time[1] && time[1] <= end[1];
        }
    }

    public static int numberOfRounds(String startTime, String finishTime) {
        int[] start = getTime(startTime), end = getTime(finishTime);
        if (endLessThan(start, end)) {
            int rounds = getRounds(start, new int[]{24, 0});
            rounds += getRounds(new int[]{0, 0}, end);
            return rounds;
        } else {
            return getRounds(start, end);
        }
    }

    private static int getRounds(int[] start, int[] end) {
        int round = 0;
        int[] curStart = getNext(start[0], start[1]);
        int[] curEnd = getNext(curStart[0], curStart[1] + 15);
        while (!endLessThan(curEnd, end)) {
            round++;
            curStart = getNext(curStart[0], curStart[1] + 15);
            curEnd = getNext(curStart[0], curStart[1] + 15);
        }
        return round;
    }

    private static int[] getNext(int hour, int minute) {
        if (minute > 45) {
            hour = hour + 1;
            minute = 0;
        } else if (minute > 30) {
            minute = 45;
        } else if (minute > 15) {
            minute = 30;
        } else if (minute > 0) {
            minute = 15;
        }
        return new int[]{hour, minute};
    }

    private static boolean endLessThan(int[] start, int[] end) {
        return start[0] > end[0] || (start[0] == end[0] && start[1] > end[1]);
    }

    private static int[] getTime(String time) {
        int hour = time.charAt(0) - '0';
        hour = hour * 10 + (time.charAt(1) - '0');
        int minute = time.charAt(3) - '0';
        minute = minute * 10 + (time.charAt(4) - '0');
        return new int[]{hour, minute};
    }
}
