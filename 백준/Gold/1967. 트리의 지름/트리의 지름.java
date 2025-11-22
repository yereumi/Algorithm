import java.util.*;
import java.io.*;

public class Main {
	
	static int n, maxV, maxW;
	static List<List<int[]>> graph;
	static boolean[] visited;
	
	static void dfs(int v, int w) {
		for (int[] g : graph.get(v)) {
			int nextV = g[0];
			int nextW = g[1];
			if (!visited[nextV]) {
				visited[nextV] = true;
				dfs(nextV, w + nextW);
			}
		}
		
		if (w > maxW) {
			maxV = v;
			maxW = w;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		
		StringTokenizer st;
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph.get(v1).add(new int[] { v2, w });
			graph.get(v2).add(new int[] { v1, w });
		}
		
		maxW = 0;
		visited = new boolean[n + 1];
		visited[1] = true;
		dfs(1, 0);
		
		maxW = 0;
		visited = new boolean[n + 1];
		visited[maxV] = true;
		dfs(maxV, 0);
		
		System.out.println(maxW);
	}
}
