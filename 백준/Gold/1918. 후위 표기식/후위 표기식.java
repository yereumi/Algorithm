import java.util.*;
import java.io.*;

public class Main {
	
    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
    
    public static int precedence(char c) {
        if (c == '*' || c == '/') return 2;
        if (c == '+' || c == '-') return 1;
        return 0;
    }
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		Deque<Character> dq = new ArrayDeque<>();
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '(') {
				dq.push(c);
			} else if (c == ')') {
				while (!dq.isEmpty()) {
					if (dq.peek() == '(') {
						dq.pop();
						break;
					}
					sb.append(dq.pop());
				}
			} else if (isOperator(c)) {
                while (!dq.isEmpty() && precedence(dq.peek()) >= precedence(c)) {
                    sb.append(dq.pop());
                }
                dq.push(c);
            } else {
				sb.append(c);
			}
		}
		while (!dq.isEmpty()) {
			sb.append(dq.pop());
		}
		System.out.println(sb);
	}
}
