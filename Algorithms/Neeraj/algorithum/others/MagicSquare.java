
/*
https://www.hackerrank.com/challenges/magic-square-forming/problem
 */
public class MagicSquare {
//    This solution is wrong.
    
    public static void main(String[] args) {
        System.out.println("Calculated answer is: " + formingMagicSquare(new int[][]{{5,3,4},{1,5,8},{6,4,2}}) + ", it should be 7.");
        System.out.println("Calculated answer is: " + formingMagicSquare(new int[][]{{4,9,2},{3,5,7},{8,1,5}}) + ", it should be 1.");
        System.out.println("Calculated answer is: " + formingMagicSquare(new int[][]{{4,8,2},{4,5,7},{6,1,6}}) + ", it should be 4.");
    }

    static int formingMagicSquare(int[][] input) {
        int rows = input.length;
        int cols = input[0].length;
        int magicNumber = 0;
        boolean[][] magicArray = new boolean[rows][cols];
        magicNumber = calculateValue(rows,cols,input,magicArray, magicNumber);
//        Check if all the boolen array values are true, If not then calculate teh values again.

        return magicNumber;
    }

    private static int calculateValue(int rows, int cols, int[][] input, boolean[][] magicArray, int magicNumber) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
//                Find if rows sum and column sum is 15.
                int rowSum = getRowSum(input,i,j,cols);
                int colSum = getColSum(input,i,j,rows);
                if (rowSum == 15 && colSum == 15){
                    magicArray[i][j] = true;
                }else if (rowSum == colSum){
                    int prevValue = input[i][j];
                    int newValue = prevValue + (15-rowSum);
                    input[i][j] = newValue;
                    magicNumber += Math.abs(prevValue-newValue);
                    System.out.println("Swapped at row:"+ i + " col:" + j + " Previous value was:" + prevValue + " new Value is:" + newValue);
                }
            }
        }
        return magicNumber;
    }

    private static int getColSum(int[][] input, int row, int col, int rows) {
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            sum += input[i][col];
        }
        return sum;
    }

    private static int getRowSum(int[][] input, int row, int col, int cols) {
        int sum = 0;
        for (int i = 0; i < cols; i++) {
            sum += input[row][i];
        }
        return sum;
    }
}
