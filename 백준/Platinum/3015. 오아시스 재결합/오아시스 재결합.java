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
		int n = (int)read();
		long[] num = new long[n];
		for (int i = 0; i < n; i++) {
			num[i] = read();
		}
		long result = 0;
		Deque<long[]> dq = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			long cnt = 1L;
			while (!dq.isEmpty() && dq.peek()[0] <= num[i]) {
				long[] top = dq.pop();
				result += top[1];
				if (top[0] == num[i]) cnt += top[1];
			}
			if (!dq.isEmpty()) result++;
			dq.push(new long[] { num[i], cnt });
		}
		System.out.println(result);
	}
}
