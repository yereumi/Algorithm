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
	
	public static long recursive(boolean[] visited, int max, int d, int s) {
		if (d == max) {
			long sum = 0, multiple = 1;
			for (int i = 0; i < n; i++) {
				if (visited[i]) sum += food[i][1];
			}
			for (int i = 0; i < n; i++) {
				if (visited[i]) multiple *= food[i][0];
			}
			min = Math.min(min, Math.abs(sum - multiple));
			return min;
		}
		for (int i = s; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				min = recursive(visited, max, d + 1, s + 1);
				visited[i] = false;
			}
		}
		return min;
	}

	public static void main(String[] args) throws Exception {
		n = read();
		food = new long[n][2];
		for (int i = 0; i < n; i++) {
			food[i][0] = read();
			food[i][1] = read();
		}
		long result = 0;
		for (int i = 1; i <= n; i++) {
			boolean[] visited = new boolean[n];
			result = recursive(visited, i, 0, 0);
		}
		System.out.println(result);
	}
}
