import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Main {

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		boolean m = n == 13;
		if (m) n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return m ? ~n + 1 : n;
	}

	public static void main(String[] args) throws Exception {
		int n = read();
		int[][] num = new int[n][2];
		int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE, minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			num[i][0] = read();
			num[i][1] = read();
			minX = Math.min(minX, num[i][0]);
			maxX = Math.max(maxX, num[i][0]);
			minY = Math.min(minY, num[i][1]);
			maxY = Math.max(maxY, num[i][1]);
		}
		System.out.println((maxX - minX) * (maxY - minY));
	}
}