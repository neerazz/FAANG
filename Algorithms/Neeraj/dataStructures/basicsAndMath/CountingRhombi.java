import java.util.*;
import java.io.*;

/**
 * Created on:  Mar 03, 2021
 * Questions: https://codeforces.com/gym/318788/problem/B
 */

public class CountingRhombi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int w = sc.nextInt(), h = sc.nextInt();
        System.out.println(getCount(0, 0, w, h));
    }

    private static long getCount(int startRow, int startCol, int endRow, int endCol) {
        if (startRow + 1 == endRow || startCol + 1 == endCol) return 0;
        int midRow = (startRow + endRow) / 2, midCol = (startCol + endCol) / 2;
        long subCount = getCount(startRow, startCol, midRow, midCol);
        return (subCount * 4) + 1;
    }
}
