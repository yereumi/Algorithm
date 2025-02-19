import java.util.*;
import java.io.*;

public class Main {

	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	static int[] num;

	public static void union(int a, int b) {
		if (find(a) != find(b)) {
			num[find(a)] = find(b);
		}
	}

	public static int find(int a) {
		if (num[a] == a)
			return a;
		return num[a] = find(num[a]);
	}

	public static boolean isSame(int a, int b) {
		return find(a) == find(b);
	}

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int n = read();
		int m = read();
		num = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			num[i] = i;
		}
		for (int i = 0; i < m; i++) {
			int f = read();
			int a = read();
			int b = read();

			if (f == 0) {
				union(a, b);
			} else if (f == 1) {
				String result = isSame(a, b) ? "YES" : "NO";
				sb.append(result).append("\n");
			}
		}
		System.out.println(sb);
	}
}
