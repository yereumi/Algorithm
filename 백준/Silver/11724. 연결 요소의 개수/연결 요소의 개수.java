import java.util.*;
import java.io.*;

public class Main {
	
	public static int n, m;
	public static int[][] graph;
	public static boolean[] visited;
	
	public static void dfs(int idx) {
		if (visited[idx]) return;
		visited[idx] = true;
		for (int i = 1; i <= n; i++) {
			if (graph[idx][i] == 1) {
				dfs(i);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new int[n + 1][n + 1];
		visited = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			graph[y][x] = graph[x][y] = 1;
		}
		
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				dfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
