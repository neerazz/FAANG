package biweekly.biweekly49;

/**
 * Created on:  Apr 03, 2021
 * Questions:
 */

public class DetermineColorOfAChessboardSquare {

    public static void main(String[] args) {

    }

    public static boolean squareIsWhite(String coordinates) {
        int row = coordinates.charAt(0) - 'a', col = coordinates.charAt(1) - '1';
        return (row + col) % 2 != 0;
    }

}
