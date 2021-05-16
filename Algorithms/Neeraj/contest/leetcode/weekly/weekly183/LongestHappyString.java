package weekly.weekly183;

import java.util.PriorityQueue;

/**
 * Crated on:  Apr 04, 2020
 */
public class LongestHappyString {
    public static void main(String[] args) {
        System.out.println(longestDiverseString(0, 8, 11) + " should be \nccbccbbccbbccbbccbc");
    }

    public static String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Characters> queue = new PriorityQueue<>((c1, c2) -> c1.count == c2.count ? c1.c - c2.c : c2.count - c1.count);
        if (a > 0) queue.add(new Characters('a', a));
        if (b > 0) queue.add(new Characters('b', b));
        if (c > 0) queue.add(new Characters('c', c));
        StringBuilder op = new StringBuilder();
        while (!queue.isEmpty()) {
            Characters poll = queue.poll();
            if (!queue.isEmpty()) {
                Characters poll2 = queue.poll();
                if (poll.count >= 2) {
                    op.append(poll.c).append(poll.c);
                    poll.count -= 2;
                } else {
                    op.append(poll.c);
                    poll.count--;
                }
                if (poll2.count >= 2) {
                    op.append(poll2.c).append(poll2.c);
                    poll2.count -= 2;
                } else {
                    op.append(poll2.c);
                    poll2.count--;
                }
                if (poll.count > 0) queue.add(poll);
                if (poll2.count > 0) queue.add(poll2);
            } else {
                char lastChar = op.charAt(op.length() - 1);
                if (poll.c != lastChar) {
                    if (poll.count >= 2) {
                        op.append(poll.c).append(poll.c);
                    } else {
                        op.append(poll.c);
                    }
                }
            }
        }
        return op.toString();
    }

    static class Characters {
        char c;
        int count;

        public Characters(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
}
