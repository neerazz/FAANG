import java.util.Deque;
import java.util.LinkedList;

class ValidParentheses{
	public static void main(String[] args){

	}

public boolean isValid(String s) {
    if(s==null || s.length()==0) return true;
    	Deque<Character> stack = new LinkedList<>();
    	for(int i=0; i<s.length(); i++){
    		char c = s.charAt(i);
    		if(c == '{' || c== '(' || c== '['){
    			stack.push(c);
    		}else{
                if(stack.isEmpty()) return false;
    			char out = stack.pop();
    			if(c == ']' && out != '['){
    				return false;
    			} 
    			if(c == '}' && out != '{'){
    				return false;
    			}
    			if(c == ')' && out != '('){
    				return false;
    			} 
    		}	
    	}
    	if(stack.isEmpty()){
    		return true;
    	}else{
    		return false;
	
    	}
    }

}