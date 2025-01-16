import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] num;
		
	public static int[] fibonacci(int n) {
		if (num[n][0] == -1) {
			int[] f1 = fibonacci(n - 1);
			int[] f2 = fibonacci(n - 2);
			num[n][0] = f1[0] + f2[0];
			num[n][1] = f1[1] + f2[1];
		}
		return new int[] { num[n][0], num[n][1] };
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			num = new int[n + 2][3];
			for (int j = 0; j < n + 1; j++) {
				Arrays.fill(num[j], -1);
			}
			num[0][0] = 1;
			num[0][1] = 0;
			num[1][0] = 0;
			num[1][1] = 1;
			int[] cnt = fibonacci(n);
			sb.append(cnt[0]).append(" ").append(cnt[1]).append("\n");
		}
		System.out.println(sb);
	}
}
