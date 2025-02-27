import java.util.*;
import java.io.*;

public class Main {

	private static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) >= 48)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
	
	static int resultW;
	static List<List<int[]>> graph;
	static boolean[] visited;
	static PriorityQueue<int[]> pq;
	
	static void mst(int vertex) {
		for (int[] vw : graph.get(vertex)) {
			if (!visited[vw[0]]) pq.offer(vw);
		}
		while (!pq.isEmpty() && visited[pq.peek()[0]]) pq.poll();
		if (!pq.isEmpty() && !visited[pq.peek()[0]]) {
			int[] now = pq.poll();
			visited[now[0]] = true;
			resultW += now[1];
			mst(now[0]);
		}
	}
	
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int m, n, v1, v2, w, totalW;
		while (true) {
			m = read();
			n = read();
			if (m == 0 && n == 0) break;
			totalW = 0;
			resultW = 0;
			graph = new ArrayList<>();
			visited = new boolean[m];
			pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
			for (int i = 0; i < m ; i++) {
				graph.add(new ArrayList<>());
			}
			for (int i = 0; i < n; i++) {
				v1 = read();
				v2 = read();
				w = read();
				graph.get(v1).add(new int[] { v2, w });
				graph.get(v2).add(new int[] { v1, w });
				totalW += w;
			}
			visited[0] = true;
			mst(0);
			sb.append(totalW - resultW).append("\n");
		}
		System.out.println(sb);
	}	
}
