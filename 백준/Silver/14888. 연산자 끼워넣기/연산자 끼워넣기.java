import java.util.*;
import java.io.*;

public class Main {

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	static int n, min, max;
	static int[] num, operator;

	static void backtracking(int depth, int plus, int minus, int multiple, int divide, int[] result) {
		if (depth == n - 1) {
			int answer = num[0];
			for (int i = 0; i < n - 1; i++) {
				if (result[i] == 0) {
					answer += num[i + 1];
				} else if (result[i] == 1) {
					answer -= num[i + 1];
				} else if (result[i] == 2) {
					answer *= num[i + 1];
				} else if (result[i] == 3) {
					answer /= num[i + 1];
				}
			}
			min = Math.min(min, answer);
			max = Math.max(max, answer);
		}
		for (int i = 0; i < plus; i++) {
			result[depth] = 0;
			backtracking(depth + 1, plus - 1, minus, multiple, divide, result);
		}
		for (int i = 0; i < minus; i++) {
			result[depth] = 1;
			backtracking(depth + 1, plus, minus - 1, multiple, divide, result);
		}
		for (int i = 0; i < multiple; i++) {
			result[depth] = 2;
			backtracking(depth + 1, plus, minus, multiple - 1, divide, result);
		}
		for (int i = 0; i < divide; i++) {
			result[depth] = 3;
			backtracking(depth + 1, plus, minus, multiple, divide - 1, result);
		}
	}

	public static void main(String[] args) throws Exception {
		n = read();
		num = new int[n];
		operator = new int[4];
		for (int i = 0; i < n; i++) {
			num[i] = read();
		}
		for (int i = 0; i < 4; i++) {
			operator[i] = read();
		}
		int[] result = new int[n - 1];
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		backtracking(0, operator[0], operator[1], operator[2], operator[3], result);
		System.out.println(max + "\n" + min);
	}
}