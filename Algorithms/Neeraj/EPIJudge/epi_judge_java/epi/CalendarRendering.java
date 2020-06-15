package epi;

import epi.test_framework.EpiTest;
import epi.test_framework.EpiUserType;
import epi.test_framework.GenericTest;

import java.util.List;
import java.util.PriorityQueue;

public class CalendarRendering {
    @EpiTest(testDataFile = "calendar_rendering.tsv")

    public static int findMaxSimultaneousEvents(List<Event> A) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((e1, e2) -> e1[0] == e2[0] ? e2[1] - e1[1] : e1[0] - e2[0]);
        for (Event event : A) {
            queue.add(new int[]{event.start, 1});
            queue.add(new int[]{event.finish, -1});
        }
        int count = 0, max = 0;
        while (!queue.isEmpty()) {
            count += queue.poll()[1];
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        System.exit(
                GenericTest
                        .runFromAnnotations(args, "CalendarRendering.java",
                                new Object() {
                                }.getClass().getEnclosingClass())
                        .ordinal());
    }

    @EpiUserType(ctorParams = {int.class, int.class})

    public static class Event {
        public int start, finish;

        public Event(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }

    private static class Endpoint {
        public int time;
        public boolean isStart;

        Endpoint(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }
    }
}
