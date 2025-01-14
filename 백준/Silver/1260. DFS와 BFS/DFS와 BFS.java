import java.util.*;
import java.io.*;

public class Main {
	
	static int n;
	static boolean[][] graph;
	static boolean[] visited;
	static Deque<Integer> dq;
	static StringBuilder sb;
	
	public static void dfs(int v) {
		if (visited[v]) {
			return;
		}
		sb.append(v).append(" ");
		visited[v] = true;
		
		for (int i = 1; i <= n; i++) {
			if (graph[v][i]) {
				dfs(i);
			}
		}	
	}
	
	public static void bfs() {
		while (!dq.isEmpty()) {
			int v = dq.poll();
			sb.append(v).append(" ");
			visited[v] = true;

			for (int i = 1; i <= n; i++) {
				if (graph[v][i] && !visited[i]) {
					dq.offer(i);
					visited[i] = true;
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		graph = new boolean[n + 1][n + 1];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			graph[v1][v2] = graph[v2][v1] = true;
		}
		
		visited = new boolean[n + 1];
		dfs(v);
		sb.append("\n");
		
		visited = new boolean[n + 1];
		dq = new ArrayDeque<>();
		dq.offer(v);
		bfs();
		
		System.out.println(sb);
	}
}
