import java.io.*;
import java.util.*;

public class Main {
	
	static int n, start, finish, m;
	static List<List<Integer>> graph;
	static int[][] edges;
	static int[] money;
	static long[] dist;
	static long INF = Long.MIN_VALUE;
	
	static boolean shortestPath() {
		dist = new long[n];
		Arrays.fill(dist, INF);
		dist[start] = money[start];
		
		for (int i = 0; i < n - 1; i++) {
			for (int[] e : edges) {
				int s = e[0];
				int f = e[1];
				int w = e[2];
				
				if (dist[s] != INF && dist[s] + w > dist[f]) {
					dist[f] = dist[s] + w;
				}
			}
		}
		
		List<Integer> updateVertexes = new ArrayList<>();
		for (int[] e : edges) {
			int s = e[0];
			int f = e[1];
			int w = e[2];
			
			if (dist[s] != INF && dist[s] + w > dist[f]) {
				updateVertexes.add(f);
			}
		}
		
		for (int v : updateVertexes) {
			if (bfs(v)) return false;
		}
		
		return true;
	}
	
	static boolean bfs(int v) {
		Deque<Integer> dq = new ArrayDeque<>();
		dq.offer(v);
		boolean[] visited = new boolean[n];
		visited[v] = true;
		
		while (!dq.isEmpty()) {
			int cur = dq.poll();
			
		    if (cur == finish) return true;

			for (int nc : graph.get(cur)) {
				if (!visited[nc]) {
					dq.offer(nc);
					visited[nc] = true;
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		finish = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for (int i = 0; i < n ; i++) {
			graph.add(new ArrayList<>());
		}
		edges = new int[m][3];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
			edges[i][2] = Integer.parseInt(st.nextToken()) * -1;
		}
		
		money = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			money[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < m; i++) {
			edges[i][2] += money[edges[i][1]];
			graph.get(edges[i][0]).add(edges[i][1]);
		}
		
		boolean result = shortestPath();
		if (dist[finish] == INF) System.out.println("gg");
		else if (!result) System.out.println("Gee");
		else System.out.println(dist[finish]);
	}
}
