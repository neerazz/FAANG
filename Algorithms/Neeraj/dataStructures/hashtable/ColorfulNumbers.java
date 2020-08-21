import java.util.HashSet;
import java.util.Set;

/**
 * Created on:  Aug 19, 2020
 * Questions: https://algorithms.tutorialhorizon.com/colorful-numbers/
 * Colorful Numbers
 * Objective: Given a number, find out whether its colorful or not.
 * <p>
 * Colorful Number: When in a given number, product of every digit of a sub-sequence are different. That number is called Colorful Number. See Example
 * <p>
 * Example:
 * <p>
 * Given Number : 3245
 * Output : Colorful
 * Number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
 * this number is a colorful number, since product of every digit of a sub-sequence are different.
 * That is, 3 2 4 5 (3*2)=6 (2*4)=8 (4*5)=20, (3*2*4)= 24 (2*4*5)= 40
 * <p>
 * Given Number : 326
 * Output : Not Colorful.
 * 326 is not a colorful number as it generates 3 2 6 (3*2)=6 (2*6)=12.
 */
public class ColorfulNumbers {
    public static void main(String[] args) {

    }

    public static boolean getColorFul(int num) {
        String str = String.valueOf(num);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            int cur = 0;
            for (int j = i; j < str.length(); j++) {
                cur = cur * 10 + (str.charAt(j) - '0');
                if (!set.add(cur)) return false;
            }
        }
        return true;
    }
}
