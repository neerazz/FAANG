/*
    Created on:  Apr 19, 2020
 */

/**
 * Questions:
 */
public class Kangaroo {
    public static void main(String[] args) {

    }

    /**
     *
     * @param x1 Kangaroo1 start point
     * @param v1 Kangaroo1 steps at each jump
     * @param x2 Kangaroo2 start point
     * @param v2 Kangaroo2 steps at each jump
     * @return If both the kangaroos can meet at a point.
     * @implNote Imagine that both of them meets after x steps. Then the equations would look like
     *              x1 + x * v1 = x2 + x * v2;
     *              x (v1-v2) = x2-x1
     *              x = (x2 - x1) / (v1 - v2)
     *           By using the above formula, if both the kangaroors to meet then x >= 0 && x would be a whole number.
     */
    static String kangaroo(int x1, int v1, int x2, int v2) {
        int jumpDif = v1 -v2;
        int startDif = x2-x1;
        if(jumpDif != 0 && startDif/jumpDif >= 0 && startDif % jumpDif == 0) return "YES";
        return "NO";
    }
}
