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
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
			int n = read();
			int cnt = 1;
			for (int i = 0; i < n; i++) {
				int first = read();
				int second = read();
				pq.offer(new int[] { first, second });
			}
			int[] now = pq.poll();
			while (pq.size() > 0) {
				if (now[0] < pq.peek()[0] || now[1] < pq.peek()[1]) {
					if (now[0] < pq.peek()[0] && now[1] < pq.peek()[1]) pq.poll();
					else {
						now = pq.poll();
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}
