import java.util.*;
import java.io.*;

public class Main {
	
	static int n;
	static int[] depth;
	static StringBuilder sb = new StringBuilder();

	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
	
	public static void recursive(int d) {
		if (d == n) {
			for (int i = 0; i < n; i++) {
				sb.append(depth[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= n; i++) {
			boolean flag = false;
			for (int j = 0; j < n; j++) {
				if (depth[j] == i) {
					flag = true;
					break;
				}
			}
			if (flag) continue;
			depth[d] = i;
			recursive(d + 1);
		}
		depth[d] = 0;
	}
	
	public static void main(String[] args) throws Exception {
		n = read();
		depth = new int[n];
		recursive(0);
		System.out.println(sb);
	}
}
