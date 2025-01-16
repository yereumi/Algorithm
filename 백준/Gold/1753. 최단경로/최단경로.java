import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		List<List<int[]>> graph = new ArrayList<>();
		for (int i = 0; i <= v; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(v1).add(new int[] { v2, w });
		}
		
		int[] distance = new int[v + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[k] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.add(new int[] { k, 0 });
		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			int u = now[0];
			int w = now[1];
			
			if (w > distance[u]) continue;
			
			for (int[] edge : graph.get(u)) {
				int nu = edge[0];
				int nw = edge[1];
				if (distance[u] + nw < distance[nu]) {
					distance[nu] = distance[u] + nw;
					pq.add(new int[] { nu, distance[nu] });
				}
			}
		}

		for (int i = 1; i <= v; i++) {
			if (distance[i] == Integer.MAX_VALUE) {
				sb.append("INF");
			} else {
				sb.append(distance[i]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
