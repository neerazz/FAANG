import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created on:  Jun 21, 2021
 * Ref:
 */

public class FindTheCelebrity {

    public static void main(String[] args) {

    }

    static Stream<Arguments> inputOutputValues() {
//        Expected Value, Actual Value
        return Stream.of(
                Arguments.of(3, -1)
        );
    }

    static Function<Integer, Integer> function = FindTheCelebrity::findCelebrity_rev2;

    @ParameterizedTest
    @MethodSource("inputOutputValues")
    void runTest(Integer input, Integer expected) {
        assertEquals(expected, function.apply(input));
    }

    public static int findCelebrity_rev2(int n) {
        boolean[] possible = new boolean[n];
        for (int i = 0; i < n; i++) {
            boolean cur = true;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (knows(i, j)) {
//                     When j knows i, then i will no more be a possible cleb.
                    cur = false;
                    break;
                }
            }
            possible[i] = cur;
        }
        for (int i = 0; i < n; i++) {
            if (possible[i]) {
//                 If i is a possible cleb then, every one should know i.
                int knows = 0;
                for (int j = 0; j < n; j++) {
                    knows += i != j && knows(j, i) ? 1 : 0;
                }
                if (knows == n - 1) return i;
            }
        }
        return -1;
    }

    public static int findCelebrity_rev1(int n) {
        int possiblecleb = 0;
        for (int i = 1; i < n; i++) {
            if (knows(possiblecleb, i)) {
                possiblecleb = i;
            }
        }
        return isCeleb(possiblecleb, n) ? possiblecleb : -1;
    }

    private static boolean isCeleb(int possiblecleb, int n) {
        for (int i = 0; i < n; i++) {
            if (i == possiblecleb) continue;
            if (knows(possiblecleb, i) || !knows(i, possiblecleb)) return false;
        }
        return true;
    }

    public static int findCelebrity(int n) {
        Set<Integer> possibleCleb = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                boolean knows = knows(i, j);
                // System.out.println(String.format("%d knows %d", i, j) + " " + knows + " n = " + n);
                count += knows ? 1 : 0;
                if (count == 1) break;
            }
            if (count == 0) possibleCleb.add(i);
        }
        for (int pos : possibleCleb) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (pos == i) continue;
                boolean knows = knows(i, pos);
                count += knows ? 1 : 0;
            }
            if (count == n - 1) return pos;
        }
        return -1;
    }

    //    Inbuild api.
    private static boolean knows(int a, int b) {
        return false;
    }
}
