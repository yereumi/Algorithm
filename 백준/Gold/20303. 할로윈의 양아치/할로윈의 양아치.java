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
		int n = read();
		int m = read();
		int k = read();
		int[] children = new int[n + 1];
		List<List<Integer>> list = new ArrayList<>();
		list.add(new ArrayList<>());
		for (int i = 1; i <= n; i++) {
			children[i] = read();
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			int v = read();
			int u = read();
			list.get(u).add(v);
			list.get(v).add(u);
		}
		List<int[]> group = new ArrayList<>();
		boolean[] visited = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				Deque<Integer> dq = new ArrayDeque<>();
				dq.offer(i);
				visited[i] = true;
				int people = 0, totalCandy = 0;
				while (!dq.isEmpty()) {
					int now = dq.poll();
					people += 1;
					totalCandy += children[now];
					for (int u : list.get(now)) {
						if (!visited[u]) {
							visited[u] = true;
							dq.offer(u);
						}
					}
				}
				group.add(new int[] { people, totalCandy });
			}
		}
//		Collections.sort(group, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] - o1[1]);
		int[] dp = new int[k + 1];
		for (int[] g : group) {
			int people = g[0];
			int totalCandy = g[1];
			for (int j = k - 1; j >= people; j--) {
				dp[j] = Math.max(dp[j], dp[j - people] + totalCandy);
			}
		}
		System.out.println(dp[k - 1]);
	}
}
