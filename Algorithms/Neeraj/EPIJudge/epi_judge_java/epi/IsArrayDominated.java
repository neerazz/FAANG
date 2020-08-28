package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;
import epi.test_framework.TimedExecutor;

import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

class Team {
    private final List<Player> players;

    public Team(List<Integer> height) {
        players =
                height.stream().map(h -> new Player(h)).collect(Collectors.toList());
    }

    // Checks if team0 can be placed in front of team1.
    public static boolean validPlacementExists(Team team0, Team team1) {
        PriorityQueue<Player> t1 = new PriorityQueue<>(team0.players);
        PriorityQueue<Player> t2 = new PriorityQueue<>(team1.players);
        while (!t1.isEmpty() && !t2.isEmpty()) {
            if (t2.peek().height > t1.peek().height) {
                t2.poll();
                t1.poll();
            } else {
                return false;
            }
        }
        return true;
    }

    private static class Player implements Comparable<Player> {
        public Integer height;

        public Player(Integer h) {
            height = h;
        }

        @Override
        public int compareTo(Player that) {
            return Integer.compare(height, that.height);
        }
    }
}

public class IsArrayDominated {
    @EpiTest(testDataFile = "is_array_dominated.tsv")
    public static void
    validPlacementExistsWrapper(TimedExecutor executor, List<Integer> team0,
                                List<Integer> team1, boolean expected01,
                                boolean expected10) throws Exception {
        Team t0 = new Team(team0), t1 = new Team(team1);

        boolean result01 = executor.run(() -> Team.validPlacementExists(t0, t1));
        boolean result10 = executor.run(() -> Team.validPlacementExists(t1, t0));
        if (result01 != expected01 || result10 != expected10) {
            throw new TestFailure("");
        }
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "IsArrayDominated.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }
}
