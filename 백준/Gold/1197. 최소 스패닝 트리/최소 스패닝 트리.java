import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		List<List<int[]>> graph = new ArrayList<>();
		for (int i = 0; i <= v; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 1; i <= e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph.get(start).add(new int[] { start, end, weight });
			graph.get(end).add(new int[] { end, start, weight });
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.add(new int[] { 1, 0 });
		boolean[] visited = new boolean[v + 1];
		int weightSum = 0;
		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			int u = now[0];
			int w = now[1];

			if (visited[u]) continue;
			weightSum += w;
			visited[u] = true;
			for (int[] next : graph.get(u)) {
				int nu = next[1];
				int nw = next[2];
				if (!visited[nu]) pq.add(new int[] { nu, nw });
			}
		}
		bw.write(String.valueOf(weightSum));
		bw.flush();
		br.close();
		bw.close();
	}
}
