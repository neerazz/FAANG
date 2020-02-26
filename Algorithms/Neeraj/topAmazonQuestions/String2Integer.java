import java.util.*;

public class String2Integer{
  public static void main(String[] args) {

  }
  public static int myAtoi(String str) {
    if(str.length() == 0) return 0;

    int index = 0, symbol = 1;
    String op ="";
    boolean negative = false;

    // Increase the index till you encounter a space.
    while(index < str.length() && str.charAt(index) == ' '){
      index++;
    }

    while(index < str.length()){
      char c = str.charAt(index++);
      if(op.length() == 0 && (c == '-' || c == '+')){
        // When you encounter a symbol decrease the value of symbol, so that next time it should not have any additional symbol.
        if(symbol == 1){
          symbol--;
          negative = c == '-';
        }else{
          // If we get any symbol then it is invalid return '0';
          return 0;
        }
      }else if(Character.isDigit(c)){
        op += c;
      }else{
        // Once we encounter any char other than number and symbol, then break the loop.
        break;
      }
    }
    if(op.length() == 0){
      return 0;
    }

    try{
      return negative ? Integer.valueOf(op) * -1 : Integer.valueOf(op);
    }catch(Exception e){
      return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
    }
  }
}
