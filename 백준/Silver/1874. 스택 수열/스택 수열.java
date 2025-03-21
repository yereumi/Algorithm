import java.util.*;
import java.io.*;

public class Main {

//	static int read() throws Exception {
//		int c, n = System.in.read() & 15;
//		boolean m = n == 13;
//		if (m) n = System.in.read() & 15;
//		while ((c = System.in.read()) >= 48)
//			n = (n << 3) + (n << 1) + (c & 15);
//		return m ? ~n + 1 : n;
//	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int n = read();
		Deque<Integer> queue = new ArrayDeque<>();
		Deque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			queue.offer(read());
		}
		int idx = 1;
		while (!queue.isEmpty()) {
			if (!stack.isEmpty() && stack.peek().equals(queue.getFirst())) {
				stack.pop();
				queue.poll();
				sb.append("-").append("\n");
			} else if (idx <= queue.getFirst()) {
				while (idx <= queue.getFirst()) {
					stack.push(idx++);
					sb.append("+").append("\n");
				}
			} else {
				System.out.printf("NO");
				System.exit(0);
			}
		}
		System.out.println(sb);
	}
}