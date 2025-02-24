import java.util.*;
import java.io.*;

public class Main {

	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int t = read();
		while (t-- > 0) {
			int n = read();
			int m = read();
			Deque<Integer> dq = new ArrayDeque<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
			for (int i = 0; i < n; i++) {
				int num = read();
				dq.offer(num);
				pq.offer(num);
			}
			
			int cnt = 1;
			while (true) {
				int now = dq.poll();
				if (now == pq.peek() && m == 0) {
					sb.append(cnt).append("\n");
					break;
				} else if (now == pq.peek()) {
					pq.poll();
					m--;
					cnt++;
				} else if (now != pq.peek()) {
					dq.offer(now);
					m--;
				}
				if (m < 0) m = pq.size() - 1;
			}
		}
		System.out.println(sb);
	}
}
