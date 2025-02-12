import java.util.*;
import java.io.*;

public class Main {
	
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		boolean m = n == 13;
		if (m)
			n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return m ? ~n + 1 : n;
	}

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int n = read();
		int[][] num = new int[n][2];
		for (int i = 0; i < n; i++) {
			num[i][0] = read();
			num[i][1] = read();
		}
		Arrays.sort(num, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
		for (int i = 0; i < n; i++) {
			sb.append(num[i][0]).append(" ").append(num[i][1]).append("\n");
		}
		System.out.println(sb);
	}
}
