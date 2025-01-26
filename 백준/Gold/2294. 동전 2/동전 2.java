import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		TreeSet<Integer> ts = new TreeSet<>((o1, o2) -> o1 - o2);
		int[] dp = new int[k + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		for (int i = 1; i <= n; i++) {
			ts.add(Integer.parseInt(br.readLine()));
		}
		List<Integer> coin = new ArrayList<>(ts);
		for (int i = 1; i <= k; i++) {
			if (coin.contains(i)) {
				dp[i] = 1;
				continue;
			}
			for (int c : coin) {
				if (i - c <= 0 || dp[i - c] == Integer.MAX_VALUE) continue;
				dp[i] = Math.min(dp[i], dp[i - c] + 1);
			}
		}
		if (dp[k] == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(dp[k]);
		}
	}
}
