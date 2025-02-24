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
		int n = read();
		int[] num = new int[n + 3];
		num[0] = 0;
		num[1] = 1;
		num[2] = 2;
		num[3] = 3;
		for (int i = 4; i <= n; i++) {
			num[i] = (num[i - 1] + num[i - 2]) % 10_007;
		}
		System.out.println(num[n]);
	}
}
