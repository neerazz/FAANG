import java.util.*;
import java.io.*;

/**
 * Created on:  Jan 22, 2021
 * Questions: https://leetcode.com/problems/one-edit-distance/
 */

public class OneEditDistance {

    public static void main(String[] args) {

    }
    public static boolean isOneEditDistance(String s, String t) {
        if(s.equals(t)) return false;
        return isOneEditDistance(s, 0, t, 0, true);
    }
    private static boolean isOneEditDistance(String s, int i1, String t, int i2, boolean ignore){
        int l1 = s.length(), l2 = t.length();
        if(Math.abs(l1 - l2) > 1) return false;
        while(i1 < l1 && i2 < l2){
            char c1 = s.charAt(i1), c2 = t.charAt(i2);
            if(c1 != c2){
                if(ignore){
                    ignore = false;
                    return isOneEditDistance(s, i1+1, t, i2+1, false) ||
                            isOneEditDistance(s, i1+1, t, i2, false) ||
                            isOneEditDistance(s, i1, t, i2+1, false);
                }else{
                    return false;
                }
            }
            i1++;
            i2++;
        }
        if(i1 == l1 && i2 == l2) return true;
        if((i1 == l1-1 && i2 == l2) || (i1 == l1 && i2 == l2-1)) return ignore;
        return false;
    }
}
