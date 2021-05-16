package weekly.weekly181;

import java.util.*;

class CheckIfThereIsAValidPathInAGrid {
    public static void main(String[] args) {

    }

    static int rows = 0, cols = 0;

    public static boolean hasValidPath(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int row =0, col = 0, pre = 0;
        while(row < rows && col < cols){
            int[] indxs = {row,col};
        }
        return false;
    }

    private static boolean move(int[][] grid, int[] indxs){
        int row = indxs[0], col = indxs[1];
        if(canMove(row,col,row+1,col,grid)){
            move(indxs,row,col,row+1,col,grid);
            return true;
        }
        if(canMove(row,col,row-1,col,grid)){
            move(indxs,row,col,row-1,col,grid);
            return true;
        }
        if(canMove(row,col,row,col+1,grid)){
            move(indxs,row,col,row,col+1,grid);
            return true;
        }
        if(canMove(row,col,row,col-1,grid)){
            move(indxs,row,col,row,col-1,grid);
            return true;
        }
        return false;
    }

    static Map<Integer, Set<Integer>> map = new HashMap<>();

    static{
        map.put(1,new HashSet<>(Arrays.asList(3,5)));
        map.put(2,new HashSet<>(Arrays.asList(5,6)));
        map.put(3,new HashSet<>(Arrays.asList(1,4,5,6)));
        map.put(4,new HashSet<>(Arrays.asList(1,2,3,5,6)));
        map.put(5,new HashSet<>(Arrays.asList(1,2,3,4,6)));
        map.put(6,new HashSet<>(Arrays.asList(1,2,3,4,5)));
    }

    private static void move(int[] idx, int i, int j, int k, int l, int[][] grid){
        int cur = grid[i][j], next = grid[k][l], row = idx[0], col = idx[1];
        if(cur == 1){
            col++;
        }else if(cur ==2){
            row++;
        }else if(cur ==3){
            if(next == 1 || next == 4){
                row++;
                col++;
            }else{
                row--;
                col--;
            }
        }else if(cur ==4){
            if(next == 1 || next == 3 || next == 5){
                row++;
                col--;
            }else{
                row--;
                col++;
            }
        }else if(cur ==5){

        }
    }

    private static boolean canMove(int i, int j, int k, int l, int[][] grid){
        if(i<0 || i >= rows || j < 0 || j >= cols || k <0 || k >= rows || l < 0 || l >= cols) return false;
        int cur = grid[i][j], next = grid[k][l];
        return map.get(cur).contains(next);
    }
}
