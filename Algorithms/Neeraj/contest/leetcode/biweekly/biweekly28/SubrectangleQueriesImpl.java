package biweekly.biweekly28;

/**
 * Created on:  Jun 13, 2020
 * Questions:
 */
public class SubrectangleQueriesImpl {
    public static void main(String[] args) {
        SubrectangleQueries subrectangleQueries = new SubrectangleQueries(new int[][]{{1, 1, 1}, {2, 2, 2}, {3, 3, 3}});
        System.out.println(subrectangleQueries.getValue(0, 0)); // return 1
        subrectangleQueries.updateSubrectangle(0, 0, 2, 2, 100);
        System.out.println(subrectangleQueries.getValue(0, 0)); // return 100
        System.out.println(subrectangleQueries.getValue(2, 2)); // return 100
        subrectangleQueries.updateSubrectangle(1, 1, 2, 2, 20);
        System.out.println(subrectangleQueries.getValue(0, 0)); // return 100
        System.out.println(subrectangleQueries.getValue(2, 2)); // return 20
    }
}

class SubrectangleQueries {

    int[][] rectangle;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        int startRow = Math.min(row1, row2), startCol = Math.min(col1, col2);
        int endRow = Math.max(row1, row2), endCol = Math.max(col1, col2);
        for (int row = startRow; row <= endRow; row++) {
            for (int col = startCol; col <= endCol; col++) {
                rectangle[row][col] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return rectangle[row][col];
    }
}