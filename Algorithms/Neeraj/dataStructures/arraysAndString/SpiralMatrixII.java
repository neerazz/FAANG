import java.util.*;
import java.io.*;

/**
 * Created on:  Dec 07, 2020
 * Questions: https://leetcode.com/explore/challenge/card/december-leetcoding-challenge/569/week-1-december-1st-december-7th/3557/
 */

public class SpiralMatrixII {

    public static void main(String[] args) {

    }

    public static int[][] generateMatrix(int n) {
        int rowStart = 0, rowEnd = n-1, colStart = 0, colEnd = n-1;
        int[][] result = new int[n][n];
        int num =1;
        while(rowStart <= rowEnd && colStart <= colEnd){
            for(int i=colStart; i<= colEnd; i++){
                result[rowStart][i] = num++;
            }
            rowStart++;
            for(int i=rowStart; i<= rowEnd; i++){
                result[i][colEnd] = num++;
            }
            colEnd--;
            if(colStart < colEnd){
                for(int i=colEnd;i>=colStart; i--){
                    result[rowEnd][i] = num++;
                }
                rowEnd--;
            }
            if(rowStart < rowEnd){
                for(int i=rowEnd; i>= rowStart; i--){
                    result[i][colStart] = num++;
                }
                colStart++;
            }
        }
        return result;
    }
}
