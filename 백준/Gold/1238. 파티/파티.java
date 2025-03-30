import java.util.*;
import java.io.*;

public class Main {

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
	
	static int n, m;
	static List<List<int[]>> graph;
	
	static int dijkstra(int start, int end) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		boolean[] visited = new boolean[n + 1];
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		pq.offer(new int[] { start, 0 });
		
		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			if (visited[now[0]]) continue;
			visited[now[0]] = true;
			dist[start] = 0;
			
			for (int[] next : graph.get(now[0])) {
				if (!visited[next[0]] && dist[next[0]] > dist[now[0]] + next[1]) {
					dist[next[0]] = dist[now[0]] + next[1];
					pq.offer(new int[] { next[0], dist[next[0]] });
				}
			}
		}
		return dist[end];
	}

	public static void main(String[] args) throws Exception {
		n = read();
		m = read();
		int x = read();
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());		
		}
		for (int i = 0; i < m; i++) {
			int s = read();
			int e = read();
			int w = read();
			graph.get(s).add(new int[] { e, w });
		}
		for (int i = 1; i <= n; i++) {
			Collections.sort(graph.get(i), (o1, o2) -> o1[1] - o2[1]);
		}
		int max = 0;
		for (int i = 1; i <= n; i++) {
			if (i == x) continue;
			max = Math.max(max, dijkstra(i, x) + dijkstra(x, i));
		}
		System.out.println(max);
	}
}