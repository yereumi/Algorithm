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
		int s = read();
		int e = read();
		boolean[] visited = new boolean[n + 1];
		int[] maxCount = new int[n + 1];
		maxCount[s] = 1_000_000;
		List<List<int[]>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			int h1 = read();
			int h2 = read();
			int k = read();
			graph.get(h1).add(new int[] { h2, k });
			graph.get(h2).add(new int[] { h1, k });
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
		pq.offer(new int[] { s, maxCount[s] });
		while (!pq.isEmpty()) {
			int[] v = pq.poll();
			if (visited[v[0]]) continue;
			visited[v[0]] = true;

			for (int[] now : graph.get(v[0])) {
				maxCount[now[0]] = v[1] >= now[1] ? Math.max(now[1], maxCount[now[0]]) : Math.max(v[1], maxCount[now[0]]);
				if (maxCount[now[0]] > v[1]) continue;
				pq.offer(new int[] { now[0], maxCount[now[0]] });
			}
		}
		System.out.println(maxCount[e]);
	}
}
