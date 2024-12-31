import java.util.*;
import java.io.*;

public class Main {
	
	public static int[] numbers = new int[] { 1, 2, 3 };
	
	public static int sum(int[] arr) {
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			result += arr[i];
		}
		return result;
	}
	
	public static int dp(int[] arr, int depth, int num, int cnt) {
		if (num == sum(arr)) {
			cnt++;
			return cnt;
		}
		if (depth == num) return cnt;
		for (int i = 0; i < 3; i++) {
			arr[depth] = numbers[i];
			cnt = dp(arr, depth + 1, num, cnt);
			arr[depth] = 0;
		}
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(dp(new int[num], 0, num, 0) + "\n");
		}
		System.out.println(sb);
	}
}
