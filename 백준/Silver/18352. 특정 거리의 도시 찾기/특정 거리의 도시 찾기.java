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
		StringBuilder sb = new StringBuilder();
		int n = read();
		int m = read();
		int k = read();
		int x = read();
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			int v = read();
			int u = read();
			graph.get(v).add(u);
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.offer(new int[] { x, 0 });
		boolean[] visited = new boolean[n + 1];
		visited[x] = true;
		List<Integer> list = new ArrayList<>();
		int cnt = 0;
		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			if (now[1] == k) {
				list.add(now[0]);
				cnt++;
			}
			for (int v : graph.get(now[0])) {
				if (!visited[v]) {
					pq.offer(new int[] { v, now[1] + 1 });
					visited[v] = true;
				}
			}
		}
		if (cnt == 0) {
			System.out.println(-1);
		} else {
			Collections.sort(list);
			for (int i = 0; i < list.size(); i++) {
				sb.append(list.get(i)).append("\n");
			}
			System.out.println(sb);
		}
	}
}
