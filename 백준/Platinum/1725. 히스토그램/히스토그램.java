import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n + 1];
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		num[n] = 0;
		
		int max = 0;
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 0; i <= n; i++) {
			while (!dq.isEmpty() && num[dq.peek()] >= num[i]) {
				int wage = num[dq.pop()];
				int day = dq.isEmpty() ? i : i - dq.peek() - 1;
				max = Math.max(max, wage * day);
			}
			dq.push(i);
		}
		System.out.println(max);
	}
}
