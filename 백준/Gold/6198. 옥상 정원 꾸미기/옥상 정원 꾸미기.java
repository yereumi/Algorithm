import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new ArrayDeque<>();
		long answer = 0;
		
		for (int i = 0; i < N; i++) {
			int h = Integer.parseInt(br.readLine());
			while (!dq.isEmpty() && dq.peek() <= h) {
				dq.pop();
			}
			answer += dq.size();
			dq.push(h);
		}
		
		System.out.println(answer);
	}
}
