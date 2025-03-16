import java.util.*;
import java.io.*;

public class Main {

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	public static void main(String[] args) throws Exception {
		int n = read();
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = read();
		}
		Deque<Integer> dq = new ArrayDeque<>();
		int idx = 1;
		for (int i = 0; i < n; i++) {
			if (num[i] > idx) dq.push(num[i]);
			else if (num[i] == idx) {
				idx++;
				while (!dq.isEmpty() && dq.peek() == idx) {
					dq.pop();
					idx++;
				}
			}
			else {
				System.out.println("Sad");
				System.exit(0);
			}
		}
		while (!dq.isEmpty()) {
			if (dq.pop() == idx) idx++;
			else {
				System.out.println("Sad");
				System.exit(0);
			}
		}
		System.out.println("Nice");
	}
}