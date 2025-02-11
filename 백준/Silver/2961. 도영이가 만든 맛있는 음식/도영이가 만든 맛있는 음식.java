import java.util.*;
import java.io.*;

public class Main {

	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	static int n;
	static long min = Integer.MAX_VALUE;
	static long[][] food;

	public static void recursive(int depth, long sSum, long bSum) {
		if (depth == n) {
			if (sSum + bSum != 1) {
				min = Math.min(min, Math.abs(sSum - bSum));
			}
			return;
		}
		recursive(depth + 1, sSum * food[depth][0], bSum + food[depth][1]);
		recursive(depth + 1, sSum, bSum);
	}

	public static void main(String[] args) throws Exception {
		n = read();
		food = new long[n][2];
		for (int i = 0; i < n; i++) {
			food[i][0] = read();
			food[i][1] = read();
		}
		long result = 0;
		recursive(0, 1, 0);
		System.out.println(min);
	}
}
