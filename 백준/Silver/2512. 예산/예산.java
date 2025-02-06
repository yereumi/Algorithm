import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] budget = new int[n];
		int total = 0, maxB = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			budget[i] = Integer.parseInt(st.nextToken());
			total += budget[i];
			maxB = Math.max(maxB, budget[i]);
		}
		int m = Integer.parseInt(br.readLine());
		if (total <= m) {
			System.out.println(maxB);
			System.exit(0);
		}
		int l = 0, r = m, mid = 0, maxBudget = 0;
		while (l <= r) {
			mid = (l + r) / 2;
			int sum = 0;
			for (int b : budget) {
				if (b > mid) sum += mid;
				else sum += b;
				}
			if (sum <= m) {
				l = mid + 1;
				maxBudget = mid;
			} else r = mid - 1;
		}		
		System.out.println(maxBudget);
		br.close();
	}
}
