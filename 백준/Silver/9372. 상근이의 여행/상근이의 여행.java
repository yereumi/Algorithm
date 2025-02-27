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
			for (int i = 0; i < m; i++) {
				int v1 = read();
				int v2 = read();
			}
			sb.append(n - 1).append("\n");
		}
		System.out.println(sb);
	}
}
