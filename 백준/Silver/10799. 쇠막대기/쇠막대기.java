import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		Stack<Character> stack = new Stack<>();
		int cnt = 0;
		int answer = 0;
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			if (c == '(') {
				stack.push(c);
				cnt++;
			} else {
				if (line.charAt(i - 1) == '(') {
					cnt--;
					answer += cnt;
					stack.pop();
				} else {
					answer++;
					cnt--;
				}
			}
		}
		
		System.out.println(answer);
	}
}
