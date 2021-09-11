/*
Given a square matrix[][] of size N x N. 
The task is to rotate it by 90 degrees in an anti-clockwise direction without using any extra space.
Example:
INPUT: N=3
       Matrix[][]=[[1,2,3],[4,5,6],[7,8,9]]
OUTPUT: 3   6   9   
        2   5   8   
        1   4   7
*/

//Initial Template for Java

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();

        Solution sol = new Solution();
        sol.rotate(arr);
        printMatrix(arr);

    }

    static void printMatrix(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println("");
        }
    }

    static class Solution {
        static void rotate(int matrix[][]) {

            for (int i = 0; i < matrix.length; i++) {
                for (int j = i; j < matrix.length; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                int k = matrix.length - 1;
                for (int j = 0; j < k; j++) {
                    int temp = matrix[j][i];
                    matrix[j][i] = matrix[k][i];
                    matrix[k][i] = temp;
                    k--;
                }
            }
        }
    }
}



