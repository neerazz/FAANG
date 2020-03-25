import java.util.*;

class BracketMatch{
  public static void main(String[] args) {
    System.out.println(bracketMatch("(()"));
  }
  static int bracketMatch(String text) {
    int count =0;
    Stack<Character> stack = new Stack<>();
    for(char c: text.toCharArray()){
      if(c == '('){
        stack.add(c);
      }else if(c == ')'){
        if(stack.isEmpty() || stack.peek() != '('){
          count++;
        }else{
          stack.pop();
        }
      }
    }
    count += stack.size();
    return count;
  }
}
