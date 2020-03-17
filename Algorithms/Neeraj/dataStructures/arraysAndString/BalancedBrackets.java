import java.util.*;

class BalancedBrackets{
  public static void main(String[] args) {

  }
  public static boolean balancedBrackets(String str) {
    if(str == null || str.length() == 0) return true;
    Stack<Character> stack = new Stack<>();
    for(char c : str.toCharArray()){
      if(c == '{' || c == '[' || c == '('){
        stack.add(c);
      }else if(stack.isEmpty()){
        return false;
      }else{
        if(c == '}' && stack.peek() == '{'){
          stack.pop();
        }else if(c == ']' && stack.peek() == '['){
          stack.pop();
        }else if(c == ')' && stack.peek() == '('){
          stack.pop();
        }else{
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}
