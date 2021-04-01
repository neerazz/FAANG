package abdoul;

/**
 * Created on:  Mar 31, 2021
 * Questions:
 */

public class Q1 {

    public static void main(String[] args) {
        System.out.println(solution("Wed", 2));
        System.out.println(solution("Sat", 23));
    }

    static String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

    private static String solution(String S, int K) {
        for (int i = 0; i < 7; i++) {
            if (S.equals(days[i])) {
                int idx = (K + i) % 7;
                return days[idx];
            }
        }
        return null;
    }
}
