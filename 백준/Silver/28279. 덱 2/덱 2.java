import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new ArrayDeque<>();
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			if (f == 1) {
				int x = Integer.parseInt(st.nextToken());
				dq.offerFirst(x);
				continue;
			} else if (f == 2) {
				int x = Integer.parseInt(st.nextToken());
				dq.offerLast(x);
				continue;
			} else if (f == 3) {
				if (dq.isEmpty()) sb.append(-1);
				else sb.append(dq.pollFirst());
			} else if (f == 4) {
				if (dq.isEmpty()) sb.append(-1);
				else sb.append(dq.pollLast());
			} else if (f == 5) {
				sb.append(dq.size());
			} else if (f == 6) {
				if (dq.isEmpty()) sb.append(1);
				else sb.append(0);
			} else if (f == 7) {
				if (dq.isEmpty()) sb.append(-1);
				else sb.append(dq.peekFirst());
			} else if (f == 8) {
				if (dq.isEmpty()) sb.append(-1);
				else sb.append(dq.peekLast());
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}