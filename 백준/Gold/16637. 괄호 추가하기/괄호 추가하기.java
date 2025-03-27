import java.util.*;
import java.io.*;

public class Main {

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	static int max;
	static int[] num;
	static char[] op;

	static void dfs(int idx, int sum) {
		if (idx >= op.length) {
			max = Math.max(max, sum);
			return;
		}
		// 1. 괄호 안치고 진행하기
		int one = cal(idx, sum, num[idx + 1]);
		dfs(idx + 1, one);
		if (idx + 1 < op.length) {
			int two = cal(idx + 1, num[idx + 1], num[idx + 2]);
			int result = cal(idx, sum, two);
			dfs(idx + 2, result);
		}
	}

	public static int cal(int opIdx, int a, int b) {
		switch (op[opIdx]) {
		case '+': return a + b;
		case '-': return a - b;
		case '*': return a * b;
		}
		return 1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		num = new int[n / 2 + 1];
		op = new char[n / 2];
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) num[i / 2] = str.charAt(i) - '0';
			else op[i / 2] = str.charAt(i);
		}
		max = Integer.MIN_VALUE;
		dfs(0, num[0]);
		System.out.println(max);
	}
}