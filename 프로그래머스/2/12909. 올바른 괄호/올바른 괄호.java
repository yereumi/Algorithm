import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
        	String str = Character.toString(s.charAt(i));
        	if (str.equals("(")) {
        		stack.push(str);
        	} else if (str.equals(")")) {
        		if (!stack.isEmpty() && stack.peek().equals("(")) {
        			stack.pop();
        		}
        		else return false;
        	}
        }
        if (stack.isEmpty())
        	return true;
        return false;
    }
}