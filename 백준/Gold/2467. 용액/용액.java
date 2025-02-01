import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] solution = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			solution[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(solution);
		long min = Long.MAX_VALUE;
		long[] answer = new long[2];
		int l = 0, r = solution.length - 1;
		while (l < r) {
			long sum = solution[l] + solution[r];
			if (Math.abs(sum) < Math.abs(min)) {
				answer[0] = solution[l];
				answer[1] = solution[r];
				min = sum;
			}
			if (sum < 0) l++;
			else r--;
		}
		System.out.println(answer[0] + " " + answer[1]);
	}
}
