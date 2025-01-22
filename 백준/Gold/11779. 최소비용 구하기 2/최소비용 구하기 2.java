import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		List<List<int[]>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		StringTokenizer st;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			graph.get(start).add(new int[] { end, weight });
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		int[][] distance = new int[n + 1][2];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		}
		distance[start][0] = 0;
		distance[start][1] = 1;
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
//		list.get(end).add(start);
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		pq.add(new int[] { start, 0 });

		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			int u = now[0];
			int w = now[1];

			if (w > distance[u][0])
				continue;

			for (int[] edge : graph.get(u)) {
				int nu = edge[0];
				int nw = edge[1];

				if (distance[u][0] + nw < distance[nu][0]) {
					distance[nu][0] = distance[u][0] + nw;
					distance[nu][1] = distance[u][1] + 1;
					pq.add(new int[] { nu, nw });
					list.get(nu).clear();
					list.get(nu).addAll(list.get(u));
					list.get(nu).add(u);
				}
			}
		}
		
		sb.append(distance[end][0]).append("\n").append(distance[end][1]).append("\n");
		for (int i = 0; i < list.get(end).size(); i++) {
			sb.append(list.get(end).get(i)).append(" ");
		}
		sb.append(end);
		System.out.println(sb);
	}
}
