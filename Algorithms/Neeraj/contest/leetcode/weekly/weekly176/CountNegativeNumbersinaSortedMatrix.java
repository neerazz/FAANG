package weekly.weekly176;

public class CountNegativeNumbersinaSortedMatrix {
    public static void main(String[] args) {
        System.out.println(countNegatives(new int[][]{{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}}));
    }
    public static int countNegatives(int[][] grid) {
        int rows = grid.length;
        int cols = rows >0 ? grid[0].length : 0;
        int output = 0;
        if (cols > 0){
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] < 0){
                        output++;
                    }
                }
            }
        }
        return output;
    }
}
