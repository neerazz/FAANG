/**
 * Created on:  Sep 17, 2020
 * Questions: https://leetcode.com/problems/robot-bounded-in-circle/
 */
public class RobotBoundedInCircle {
    public static void main(String[] args) {
        System.out.println(isRobotBounded("RRGRRGLLLRLGGLGLLGRLRLGLRLRRGLGGLLRRRLRLRLLGRGLGRRRGRLG") + " = false");
        System.out.println(isRobotBounded("GG") + " = false");
        System.out.println(isRobotBounded("RRLRRLGLRGLRGLGRRGRLRLGRRLRGLR") + " = true");
        System.out.println(isRobotBounded("GGLLGG") + " = true");
        System.out.println(isRobotBounded("GL") + " = true");
    }

    public static boolean isRobotBounded(String instructions) {
        char dir = 'n';
        int[] cur = {0, 0};
        for (char c : instructions.toCharArray()) {
            if (c == 'R') {
                if (dir == 'n') dir = 'e';
                else if (dir == 'e') dir = 's';
                else if (dir == 'w') dir = 'n';
                else dir = 'w';
            } else if (c == 'L') {
                if (dir == 'n') dir = 'w';
                else if (dir == 'e') dir = 'n';
                else if (dir == 'w') dir = 's';
                else dir = 'e';
            } else {
                move(cur, dir);
            }
        }
        return (cur[0] == 0 && cur[1] == 0) || dir != 'n';
    }

    private static void move(int[] cur, char dir) {
        if (dir == 'n') cur[1]++;
        if (dir == 'e') cur[0]++;
        if (dir == 'w') cur[0]--;
        if (dir == 's') cur[1]--;
    }
}
