import java.util.*;
import java.io.*;

public class Main {
	
	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	static int n, white = 0, blue = 0;
	static int[][] a;

	static void paper(int i, int j, int n) {
		int sum = 0;
		for (int row = i; row < i + n; row++) {
			for (int col = j; col < j + n; col++) {
				sum += a[row][col];
			}
		}
		if (sum == n * n) {
			blue++;
		} else if (sum == 0) {
			white++;
		} else {
			paper(i, j, n / 2);
			paper(i + n / 2, j, n / 2);
			paper(i, j + n / 2, n / 2);
			paper(i + n / 2, j + n / 2, n / 2);
		}
	}

	public static void main(String[] args) throws Exception {
		n = read();
		a = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = read();
			}
		}
		paper(0, 0, n);
		System.out.println(white);
		System.out.println(blue);
	}
}
