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
		int x = read();
		int[] views = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			views[i] = views[i - 1] + read();
		}
		int maxView = 0, maxCnt = 0;
		for (int i = 0; i < n - x + 1; i++) {
			if (views[i + x] - views[i] > maxView) {
				maxView = views[i + x] - views[i];
				maxCnt = 1;
			} else if (views[i + x] - views[i] == maxView) maxCnt++;
		}
		if (maxView == 0) System.out.println("SAD");
		else {
			System.out.println(maxView + "\n" + maxCnt);
		}
	}
}