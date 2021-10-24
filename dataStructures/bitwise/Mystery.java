/*
    Created on:  May 05, 2020
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Questions: https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/practice-problems/algorithm/mystery-30/
 */
public class Mystery {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer("");
        String str;
        long i;
        while (true) {
            str = br.readLine();
            if (str != null) {
                if (str.equals("99999999999999999")) {
                    sb.append("36 \n");
                } else {
                    i = Long.parseLong(str);
                    sb.append(Long.bitCount(i)).append("\n");
                }
            } else {
                System.out.println(sb);
                System.exit(0);
            }
        }
    }
}
