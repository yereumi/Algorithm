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
		int n = read();
		int m = read();
		num = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			num[i] = i;
		}
		for (int i = 0; i < m; i++) {
			int a = read();
			int b = read();
			union(a, b);
		}
		int[] timetable = new int[n];
		for (int i = 0; i < n; i++) {
			timetable[i] = read();
		}
		int cnt = 0;
		for (int i = 0; i < n - 1; i++) {
			if (!isSame(timetable[i], timetable[i + 1])) cnt++;
		}
		System.out.println(cnt);
	}
}
