import java.util.*;

class WordSearch{
  public static void main(String[] args) {
    System.out.println(exist(new char[][]{
      {'A','B','C','E'},
      {'S','F','C','S'},
      {'A','D','E','E'}
    },"ABCCED"));
    System.out.println(exist(new char[][]{
      {'a','b'},
      {'c','d'}
    },"cdba"));
  }
  static int rows, cols;
  public static boolean exist(char[][] board, String word) {
      rows = board.length;
      cols = board[0].length;
      for(int row = 0; row < rows; row++){
          for(int col =0; col<cols ; col++){
              if(board[row][col] == word.charAt(0) &&
                 helper(board,word,new HashSet<>(),row,col)){
                  return true;
              }
          }
      }
      return false;
  }
  private static boolean helper(char[][] board,String word, Set<Integer> set, int row, int col){
    System.out.println("word = " + word + ", set = " + set + ", row = " + row + ", col = " + col);
      if(row < 0 || row >= rows || col < 0 || col >= cols) return false;
      char cur = board[row][col];
      int hash = row * 1000 + col;
      if(set.contains(hash)) return false;
      if(word.charAt(0) == cur){
          if(word.length() == 1){
              return true;
          }
          word = word.substring(1);
          Set<Integer> temp = new HashSet<>(set);
          temp.add(hash);
          return helper(board,word,temp,row+1,col) ||
              helper(board,word,temp,row-1,col) ||
              helper(board,word,temp,row,col+1) ||
              helper(board,word,temp,row,col-1);
      }
      return false;
  }
}
