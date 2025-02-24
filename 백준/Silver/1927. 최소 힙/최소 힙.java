import java.util.*;
import java.io.*;

public class Main {

	private static long read() throws Exception {
		long c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int n = (int)read();
		PriorityQueue<Long> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1, o2));
		for (int i = 0; i < n; i++) {
			long num = read();
			if (num == 0) {
				if (pq.isEmpty()) sb.append(0).append("\n");
				else sb.append(pq.poll()).append("\n");
			} else {
				pq.offer(num);
			}
		}
		System.out.println(sb);
	}
}
