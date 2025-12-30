import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static List<List<Integer>> bridge;
	static int[][] dp;
	static boolean[] visited;
	
	static void dfs(int u) {
		visited[u] = true;
		
		dp[u][0] = 0;
		dp[u][1] = 1;
		
		for (int v : bridge.get(u)) {
			if (!visited[v]) {
				dfs(v);
				
				dp[u][1] += Math.min(dp[v][0], dp[v][1]);
				dp[u][0] += dp[v][1];
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		bridge = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			bridge.add(new ArrayList<>());
		}
		
		StringTokenizer st;
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			bridge.get(u).add(v);
			bridge.get(v).add(u);
		}
		
		dp = new int[n + 1][2];
		visited = new boolean[n + 1];
		
		dfs(1);
		int answer = Math.min(dp[1][0], dp[1][1]);
		System.out.println(answer);
	}
}
